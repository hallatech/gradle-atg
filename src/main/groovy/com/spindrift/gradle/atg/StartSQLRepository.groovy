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
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

/**
 * @author warren
 *
 */
class StartSQLRepository extends DefaultTask {
  
  @Input def repository=''
  @Input def modules=''
  @Input def server=''
  @Input def outputSQL=false
  @Input def outputSQLFile=''
  @Input def database='oracle'
  
  StartSQLRepository() {
    description='Instantiates a repository, parses and combines XML, import and export repository data.'
    group='ATG'
  }
  
  @TaskAction
  public void start() {
    withExceptionHandling {
      println "StartSQLRepository ..."
//      this.getProperties().each {k,v ->
//        logger.quiet "$k=$v"
//      }
      println "Modules=${modules}"
    }
  }

}
