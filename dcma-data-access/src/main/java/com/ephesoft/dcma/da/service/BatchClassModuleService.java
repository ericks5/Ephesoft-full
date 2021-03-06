/********************************************************************************* 
* Ephesoft is a Intelligent Document Capture and Mailroom Automation program 
* developed by Ephesoft, Inc. Copyright (C) 2010-2012 Ephesoft Inc. 
* 
* This program is free software; you can redistribute it and/or modify it under 
* the terms of the GNU Affero General Public License version 3 as published by the 
* Free Software Foundation with the addition of the following permission added 
* to Section 15 as permitted in Section 7(a): FOR ANY PART OF THE COVERED WORK 
* IN WHICH THE COPYRIGHT IS OWNED BY EPHESOFT, EPHESOFT DISCLAIMS THE WARRANTY 
* OF NON INFRINGEMENT OF THIRD PARTY RIGHTS. 
* 
* This program is distributed in the hope that it will be useful, but WITHOUT 
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
* FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more 
* details. 
* 
* You should have received a copy of the GNU Affero General Public License along with 
* this program; if not, see http://www.gnu.org/licenses or write to the Free 
* Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 
* 02110-1301 USA. 
* 
* You can contact Ephesoft, Inc. headquarters at 111 Academy Way, 
* Irvine, CA 92617, USA. or at email address info@ephesoft.com. 
* 
* The interactive user interfaces in modified source and object code versions 
* of this program must display Appropriate Legal Notices, as required under 
* Section 5 of the GNU Affero General Public License version 3. 
* 
* In accordance with Section 7(b) of the GNU Affero General Public License version 3, 
* these Appropriate Legal Notices must retain the display of the "Ephesoft" logo. 
* If the display of the logo is not reasonably feasible for 
* technical reasons, the Appropriate Legal Notices must display the words 
* "Powered by Ephesoft". 
********************************************************************************/ 

package com.ephesoft.dcma.da.service;

import java.util.List;

import com.ephesoft.dcma.core.common.Order;
import com.ephesoft.dcma.da.domain.BatchClassModule;
import com.ephesoft.dcma.da.domain.Module;

/**
 * This is a database service to get the modules related to a batch class.
 * 
 * @author Ephesoft
 * @version 1.0
 * @see com.ephesoft.dcma.da.service.BatchClassModuleServiceImpl
 */
public interface BatchClassModuleService {

	/**
	 * API to fetch count of modules inside a batch class.
	 * 
	 * @param batchClassIdentifier {@link String}
	 * @return {@link Integer} count of Modules.
	 */
	Integer countModules(String batchClassIdentifier);

	/**
	 * API to fetch all the modules contained in the batch class.
	 * 
	 * @param batchClassIdentifier {@link String}
	 * @return List<{@link Module}>.
	 */
	List<Module> getBatchClassModule(String batchClassIdentifier);

	/**
	 * API to fetch Modules starting from firstIndex and as many results as MaxResults from a batch class.
	 * 
	 * @param batchClassIdentifier {@link String}
	 * @param firstResult int
	 * @param maxResults int
	 * @return List<{@link Module}>
	 */
	List<Module> getModules(String batchClassIdentifier, final int firstIndex, final int maxResults);

	/**
	 * API to fetch BatchClassModule by batch class id and module name.
	 * 
	 * @param batchClassIdentifier {@link String}	 
	 * @param moduleName {@link String}
	 * @return {@link BatchClassModule}
	 */
	BatchClassModule getBatchClassModuleByName(String batchClassIdentifier, String moduleName);
	
	/**
	 * API to evict a batch class module object.
	 * 
	 * @param batchClassModule {@link BatchClassModule}
	 */
	void evict(BatchClassModule batchClassModule);
	
	/**
	 * API to fetch BatchClassModule by workflow name.
	 * 
	 * @param batchClassIdentifier {@link String}
	 * @param workflowName {@link String}
	 * @return {@link BatchClassModule}
	 */
	BatchClassModule getBatchClassModuleByWorkflowName(String batchClassIdentifier, String workflowName);
	
	/**
	 * API to get list of all batch class modules given the batch class identifier.
	 * @param batchClassIdentifier {@link String}
	 * @return {@link List}< {@link BatchClassModule}>
	 */
	List<BatchClassModule> getAllBatchClassModulesByIdentifier(String batchClassIdentifier);
	
	/**
	 * API to get all the batch class modules available.
	 * @return {@link List}< {@link BatchClassModule}>
	 */
	List<BatchClassModule> getAllBatchClassModules();
	
	/**
	 * API to get the list of all batch class modules in ascending or descending workflow name order.
	 * @param order Order
	 * @return {@link List}< {@link BatchClassModule}>
	 */
	List<BatchClassModule> getAllBatchClassModules(Order order);
}
