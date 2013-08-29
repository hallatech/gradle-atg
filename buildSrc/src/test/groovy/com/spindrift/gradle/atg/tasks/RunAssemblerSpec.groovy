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

import spock.lang.Specification
import org.gradle.api.*
import org.gradle.api.plugins.*
import org.gradle.testfixtures.ProjectBuilder
import org.apache.commons.lang3.SystemUtils

/**
 * @author warren
 *
 */
class RunAssemblerSpec extends Specification {
  static final TASK_NAME = 'runAssembler'
  Project project
  
  def setup() {
    project = ProjectBuilder.builder().build()
  }
  
  def "Adds runAssembler task"() {
    expect:
      project.tasks.findByName(TASK_NAME) == null
    when:
      project.task(TASK_NAME, type: RunAssembler) {
        workingDir = "${System.env['ATG_HOME']}/home/bin"
        outputFilePath = "${project.buildDir}/atg/ATGProduction.ear"
        options = ['liveconfig']
        modules = ['DafEar.Admin','DPS','DSS','DCS.PublishingAgent']
        generateArguments()
        commandLine arguments
      }
    then:
    Task task = project.tasks.findByName(TASK_NAME)
    task != null
    task.outputFilePath.endsWith('build/atg/ATGProduction.ear')
    task.commandLine.join(',') == "./runAssembler,-liveconfig,${project.buildDir}/atg/ATGProduction.ear,-m,DafEar.Admin,DPS,DSS,DCS.PublishingAgent"
  }

  def "Executes runAssembler task without generating arguments"() {
    expect:
      project.tasks.findByName(TASK_NAME) == null
    when:
      project.task(TASK_NAME, type: RunAssembler) {
        workingDir = "${System.env['ATG_HOME']}/home/bin"
        outputFilePath = "${project.buildDir}/atg/ATGProduction.ear"
        options = ['liveconfig']
        modules = ['DafEar.Admin','DPS','DSS','DCS.PublishingAgent']
        commandLine arguments
      }
    then:
    Task task = project.tasks.findByName(TASK_NAME)
    if (!SystemUtils.IS_OS_WINDOWS) {
      task.commandLine.join(',') == "./runAssembler"
    }
    else {
      task.commandLine.join(',') == "cmd, /c,./runAssembler"
    }
    //thrown(GradleException)
  }

}
