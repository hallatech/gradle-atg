/**
 * Copyright (C) 2013 Spindrift B.V. All Rights Reserved
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.spindrift.gradle.atg.tasks

import org.gradle.api.tasks.Exec
import org.gradle.api.tasks.Input;

import javax.inject.Inject

import org.apache.commons.lang3.SystemUtils

/**
 * @author warren
 * Extends the Exec task with runAssembler configuration
 *
 */
class RunAssembler extends Exec {
  public static final String RUN_ASSEMBLER_NAME='runAssembler'
  public static final String RUN_ASSEMBLER_DESC='Assembles ATG Modules into a single ear file'
  public static final String RUN_ASSEMBLER_GROUP='ATG'
  
  @Input String outputEarFile
  @Input List<String> options = new ArrayList()
  @Input List<String> modules = new ArrayList()
  @Input List<String> layers = new ArrayList()
  @Input boolean generateArguments
  
  List<String> arguments = new ArrayList()
  
  @Inject
  RunAssembler() {
    this(RUN_ASSEMBLER_DESC)
  }
  
  RunAssembler(String description) {
    this(description, RUN_ASSEMBLER_GROUP)
  }

  RunAssembler(String description, String group) {
    this.description=description
    this.group=group
    setOSCommand()
  }
  
  private void setOSCommand() {
    if (SystemUtils.IS_OS_WINDOWS) {
      arguments.add('cmd')
      arguments.add('/c')
      arguments.add("$RUN_ASSEMBLER_NAME.bat")
    }
    else {
      arguments.add("./$RUN_ASSEMBLER_NAME")
    }
  }
  
  public void options(List<String> options) {
    this.options = options
//    logger.quiet "options=$options"
  }
  public void layers(List<String> modules) {
    this.layers = layers
//    logger.quiet "layers=$layers"
  }
  public void modules(List<String> modules) {
    this.modules = modules
//    logger.quiet "modules=$modules"
  }
  
  /**
   * Generates the remaining arguments according runAssembler requirements
   * This method must be called on the task otherwise runAssembler will fail without any parameters
   */
  public void generateArguments() {
    // Add non-parameterised options (Extend DSL for parameterised later)
    options.each { option ->
      arguments.add("-${option}")
    }
    // Add target ear file
    arguments.add(outputEarFile)
    // Add assembly modules
    arguments.add('-m')
    modules.each { module ->
      arguments.add(module)
    }
    logger.quiet "$RUN_ASSEMBLER_NAME args=$arguments"
  }
  
}
