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

import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile

/**
 * @author warren
 * Executes ATG runAssembler script
 */
class RunAssembler extends DefaultTask {
  
  // options
  @Input def pack=false
  @Input def standalone=false
  @Input def overwrite=false
  @Input def collapseClassPath=false
  @Input def collapseExcludeDirs=false
  @Input def collapseExcludeFiles=false
  @Input def jardirs=false
  @Input def verbose=false
  @Input def classesonly=false
  @Input def displayname=''
  @Input def server=''
  @Input def liveconfig=false
  @Input def distributable=false
  @Input def addEarFile=''
  @Input def contextRootsFile=''
  @Input def dynamoEnvProperties=''
  @Input def excludeAccResources=false 
  @Input def nofix=false
  @Input def prependJars=''
  @Input def runInPlace=false
  @Input def tomcat=false
  @Input def tomcatAdditionalResourcesFile=''
  @Input def tomcatInitialResourcesFile=''
  @Input def tomcatUseJotm=false
  @Input def tomcatUseAtomikos=false

  @Input def layers=''
  @Input List<String> modules
  @Input def outputFile=''
  
//  @OutputFile
//  File earFile = new File(outputFile)
  
  RunAssembler() {
    description='Assembles ATG Modules into a single ear file'
    group='ATG'
  }
  
  @TaskAction
  public void start() {
    withExceptionHandling {
      println "Assembling ..."
//      this.getProperties().each {k,v ->
//        logger.quiet "$k=$v"
//      }
      println "Modules=${modules}"
    }
  }
  
  /**
   * Error handling
   * @param c closure
   */
  private void withExceptionHandling(Closure c) {
    try {
      c()
    }
    catch(Exception e) {
      throw new GradleException(e.message)
    }
  }
  
}
