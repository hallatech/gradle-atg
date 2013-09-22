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

/**
 * @author warren
 *
 */
class ATGPluginExtension {
  
  // runAssembler task properties
  def runAssembler=[
    'modules':['DafEar.Admin','DPS','DSS','DCS.PublishingAgent'],
    'layers':[],
    'outputEarFileName':'ATGProduction.ear',
    'outputRootDir':'build',
    'outputATGDir':'atg',
    'options':['liveconfig']
  ]


}
