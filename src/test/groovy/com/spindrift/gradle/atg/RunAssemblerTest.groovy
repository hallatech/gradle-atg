package com.spindrift.gradle.atg
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder

import com.spindrift.gradle.atg.RunAssembler

/**
 * Copyright (C) 2013 Spindrift B.V. All Rights Reserved
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author warren
 *
 */
class RunAssemblerTest {

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void canAddRunAssemblerTaskToProject() {
    Project project = ProjectBuilder.builder().build()
    def task = project.task('runAssembler', type: RunAssembler)
    assertTrue(task instanceof RunAssembler)
  }

}
