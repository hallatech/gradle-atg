/**
 * Copyright (C) 2013 Spindrift B.V. All Rights Reserved
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.spindrift.gradle.atg

import java.util.List;

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Input;

import com.spindrift.gradle.atg.tasks.RunAssembler

/**
 * @author warren
 *
 */
class ATGPlugin implements Plugin<Project>{
  static final String PLUGIN_EXTENSION_NAME = 'atg'

  /* (non-Javadoc)
   * @see org.gradle.api.Plugin#apply(java.lang.Object)
   */
  @Override
  public void apply(Project project) {
    //project.extensions.create(PLUGIN_EXTENSION_NAME, ATGPluginExtension)
    project.extensions."${PLUGIN_EXTENSION_NAME}" = new ATGPluginExtension()
    addTasks(project)
  }
  
  private void addTasks(Project project) {
    project.tasks.withType(RunAssembler).whenTaskAdded { task ->
      task.outputEarFile = "${project.getAt(PLUGIN_EXTENSION_NAME).runAssembler.outputRootDir}/${project.getAt(PLUGIN_EXTENSION_NAME).runAssembler.outputATGDir}/${project.getAt(PLUGIN_EXTENSION_NAME).runAssembler.outputEarFileName}"
      task.options = project.getAt(PLUGIN_EXTENSION_NAME).runAssembler.options
      task.modules = project.getAt(PLUGIN_EXTENSION_NAME).runAssembler.modules
      task.layers = project.getAt(PLUGIN_EXTENSION_NAME).runAssembler.layers
    }
  }

}
