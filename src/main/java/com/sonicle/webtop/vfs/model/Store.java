/* 
 * Copyright (C) 2014 Sonicle S.r.l.
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License version 3 as published by
 * the Free Software Foundation with the addition of the following permission
 * added to Section 15 as permitted in Section 7(a): FOR ANY PART OF THE COVERED
 * WORK IN WHICH THE COPYRIGHT IS OWNED BY SONICLE, SONICLE DISCLAIMS THE
 * WARRANTY OF NON INFRINGEMENT OF THIRD PARTY RIGHTS.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, see http://www.gnu.org/licenses or write to
 * the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301 USA.
 *
 * You can contact Sonicle S.r.l. at email address sonicle[at]sonicle[dot]com
 *
 * The interactive user interfaces in modified source and object code versions
 * of this program must display Appropriate Legal Notices, as required under
 * Section 5 of the GNU Affero General Public License version 3.
 *
 * In accordance with Section 7(b) of the GNU Affero General Public License
 * version 3, these Appropriate Legal Notices must retain the display of the
 * Sonicle logo and Sonicle copyright notice. If the display of the logo is not
 * reasonably feasible for technical reasons, the Appropriate Legal Notices must
 * display the words "Copyright (C) 2014 Sonicle S.r.l.".
 */
package com.sonicle.webtop.vfs.model;

import com.sonicle.vfs2.VfsURI;
import com.sonicle.webtop.core.sdk.UserProfileId;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author malbinola
 */
public class Store {
	public static final Short BUILTIN_NO = 0;
	public static final Short BUILTIN_DOMAINIMAGES = 98;
	public static final Short BUILTIN_MYDOCUMENTS = 100;
	private Integer storeId;
	private String domainId;
	private String userId;
	private Short builtIn;
	private String name;
	private URI uri;
	private String parameters;
	
	public Store() {}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public Short getBuiltIn() {
		return builtIn;
	}

	public void setBuiltIn(Short builtIn) {
		this.builtIn = builtIn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public URI getUri() {
		return uri;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	
	public UserProfileId getProfileId() {
		return new UserProfileId(getDomainId(), getUserId());
	}
	
	public void setProfileId(UserProfileId pid) {
		setDomainId(pid.getDomain());
		setUserId(pid.getUser());
	}
	
	public static URI buildURI(String scheme, String host, Integer port, String username, String password, String path) throws URISyntaxException {
		return new VfsURI.Builder()
				.scheme(scheme)
				.host(host)
				.port(port)
				.username(username)
				.password(password)
				.path(path)
				.build();
	}
	
	public static URI buildFileURI(String path) throws URISyntaxException {
		return Store.buildURI("file", null, null, null, null, path);
	}
	
	public static URI buildDropboxURI(String accountId, String accessToken) throws URISyntaxException {
		return Store.buildURI("dropbox", "dropbox.com", null, accountId, accessToken, null);
	}
	
	public static URI buildGoogleDriveURI(String accountEmail, String accessToken) throws URISyntaxException {
		String[] tokens = StringUtils.split(accountEmail, "@");
		return Store.buildURI("googledrive", tokens[1], null, tokens[0], accessToken, null);
	}
}
