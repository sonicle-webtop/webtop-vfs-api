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

import com.google.gson.annotations.SerializedName;
import com.sonicle.commons.PathUtils;
import com.sonicle.webtop.core.sdk.UserProfileId;
import com.sonicle.webtop.core.sdk.WTException;
import com.sonicle.webtop.core.sdk.WTRuntimeException;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 *
 * @author malbinola
 */
public class SharingLink {
	private String linkId;
	private String domainId;
	private String userId;
	private LinkType linkType;
	private Integer storeId;
	private String filePath;
	private String fileHash;
	private DateTime createdOn;
	private DateTime expiresOn;
	private AuthMode authMode;
	private String password;
	private Boolean notify;
	
	public SharingLink() {}
	
	public String getLinkId() {
		return linkId;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
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
	
	public LinkType getLinkType() {
		return linkType;
	}

	public void setLinkType(LinkType linkType) {
		this.linkType = linkType;
	}
	
	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public String getFileHash() {
		return fileHash;
	}

	public void setFileHash(String fileHash) {
		this.fileHash = fileHash;
	}

	public DateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(DateTime createdOn) {
		this.createdOn = createdOn;
	}

	public DateTime getExpiresOn() {
		return expiresOn;
	}

	public void setExpiresOn(DateTime expiresOn) {
		this.expiresOn = expiresOn;
	}

	public AuthMode getAuthMode() {
		return authMode;
	}

	public void setAuthMode(AuthMode authMode) {
		this.authMode = authMode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getNotify() {
		return notify;
	}

	public void setNotify(Boolean notify) {
		this.notify = notify;
	}
	
	public boolean isExpired(DateTime now) {
		if(expiresOn == null) return false;
		DateTime expires = expiresOn.toDateTime(DateTimeZone.UTC);
		return now.isAfter(expires) || now.isEqual(expires);
	}
	
	public UserProfileId getProfileId() {
		return new UserProfileId(getDomainId(), getUserId());
	}
	
	public void setProfileId(UserProfileId pid) {
		setDomainId(pid.getDomain());
		setUserId(pid.getUser());
	}
	
	public void validate(boolean silent) {
		if (!silent && linkType.equals(LinkType.UPLOAD) && !PathUtils.isFolder(filePath)) throw new WTRuntimeException("File path must target a directory");
		if (!silent && authMode == null) throw new WTRuntimeException("Provide a value for authMode");
		if (authMode.equals(AuthMode.PASSWORD)) {
			if (StringUtils.isBlank(password)) throw new WTRuntimeException("Provide a value for password");
		} else {
			password = null;
		}
	}
	
	public String relativizePath(String path) {
		return PathUtils.ensureBeginningSeparator(StringUtils.removeStart(path, getFilePath()));
	}
	
	public static enum LinkType {
		@SerializedName("D") DOWNLOAD,
		@SerializedName("U") UPLOAD;
	}
	
	public static enum AuthMode {
		@SerializedName("N") NONE,
		@SerializedName("P") PASSWORD;
	}
	
	public static class BuilderForAdd {
		private final SharingLink obj = new SharingLink();
		
		public BuilderForAdd(int storeId, String filePath) {
			obj.setStoreId(storeId);
			obj.setFilePath(filePath);
			permanent();
			free();
			silent();
		}
		
		public final BuilderForAdd free() {
			obj.setAuthMode(AuthMode.NONE);
			obj.setPassword(null);
			return this;
		}
		
		public final BuilderForAdd permanent() {
			obj.setExpiresOn(null);
			return this;
		}
		
		public final BuilderForAdd silent() {
			obj.setNotify(false);
			return this;
		}
		
		public final BuilderForAdd withExpiry(DateTime expiresOn) {
			obj.setExpiresOn(expiresOn);
			return this;
		}
		
		public final BuilderForAdd withPassword(String password) {
			obj.setAuthMode(AuthMode.PASSWORD);
			obj.setPassword(password);
			return this;
		}
		
		public final BuilderForAdd withNotification() {
			obj.setNotify(true);
			return this;
		}
		
		public final SharingLink build() {
			return obj;
		}
	}
}
