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

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ephesoft.dcma.da.dao.ServerRegistryDao;
import com.ephesoft.dcma.da.domain.ServerRegistry;

/**
 * This is a database service to read data required by Server Registry Service.
 * 
 * @author Ephesoft
 * @version 1.0
 * @see com.ephesoft.dcma.da.service.ServerRegistryService
 */
@Service
public class ServerRegistryServiceImpl implements ServerRegistryService {

	/**
	 * serverRegistryDao {@link ServerRegistryDao}.
	 */
	@Autowired
	private ServerRegistryDao serverRegistryDao;

	/**
	 * API to create a new Server Registry.
	 * 
	 * @param serverRegistry {@link ServerRegistry}
	 */
	@Override
	@Transactional(readOnly = false)
	public void createServerRegistry(ServerRegistry serverRegistry) {
		serverRegistryDao.createServerRegistry(serverRegistry);
	}

	/**
	 * An API to fetch all Server Registry.
	 * 
	 * @return List<{@link ServerRegistry}> return the server registry list.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<ServerRegistry> getAllServerRegistry() {
		List<ServerRegistry> serverRegistries = null;
		serverRegistries = serverRegistryDao.getAllServerRegistry();
		return serverRegistries;
	}

	/**
	 * An API to fetch a Server Registry.
	 * 
	 * @param identifier {@link Serializable}
	 * @return {@link ServerRegistry}
	 */
	@Override
	@Transactional(readOnly = true)
	public ServerRegistry getServerRegistry(Serializable identifier) {
		return serverRegistryDao.getServerRegistry(identifier);
	}

	/**
	 * An API to fetch all the Server Registry by IP address, port number and context.
	 * 
	 * @param ipAddress {@link String}
	 * @param portNumber {@link String}
	 * @param context {@link String} 
	 * @return {@link ServerRegistry} return the server registry.
	 */
	@Override
	@Transactional(readOnly = true)
	public ServerRegistry getServerRegistry(String ipAddress, String portNumber, String context) {
		return serverRegistryDao.getServerRegistry(ipAddress, portNumber, context);
	}

	/**
	 * API to remove an existing Server Registry.
	 * 
	 * @param serverRegistry {@link ServerRegistry}
	 */
	@Override
	@Transactional(readOnly = false)
	public void removeServerRegistry(ServerRegistry serverRegistry) {
		serverRegistryDao.removeServerRegistry(serverRegistry);
	}

	/**
	 * API to save or update a Server Registry.
	 * 
	 * @param serverRegistry {@link ServerRegistry}
	 */
	@Override
	@Transactional(readOnly = false)
	public void updateServerRegistry(ServerRegistry serverRegistry) {
		serverRegistryDao.updateServerRegistry(serverRegistry);
	}

	/**
	 * API to get the inactive servers.
	 * 
	 * @return List<{@link ServerRegistry}>
	 */
	@Override
	@Transactional(readOnly = true)
	public List<ServerRegistry> getInactiveServers() {
		return serverRegistryDao.getInactiveServers();
	}

}
