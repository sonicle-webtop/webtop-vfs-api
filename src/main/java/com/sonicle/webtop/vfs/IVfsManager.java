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
package com.sonicle.webtop.vfs;

import com.google.gson.annotations.SerializedName;
import com.sonicle.webtop.core.sdk.WTException;
import com.sonicle.webtop.vfs.model.SharingLink;
import com.sonicle.webtop.vfs.model.Store;
import com.sonicle.webtop.vfs.model.StoreShareFolder;
import com.sonicle.webtop.vfs.model.StoreShareRoot;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;

/**
 *
 * @author malbinola
 */
public interface IVfsManager {
	
	public List<StoreShareRoot> listIncomingStoreRoots() throws WTException;
	public HashMap<Integer, StoreShareFolder> listIncomingStoreFolders(String rootShareId) throws WTException;
	public List<Store> listStores() throws WTException;
	public Integer getMyDocumentsStoreId() throws WTException;
	public Store getStore(int storeId) throws WTException;
	public Store addStore(Store item) throws WTException;
	public Store addBuiltInStoreMyDocuments() throws WTException;
	public Store addBuiltInStoreDomainImages(String domainId) throws WTException;
	public Store updateStore(Store item) throws WTException;
	public void deleteStore(int storeId) throws WTException;
	public void deleteBuiltInStoreDomainImages(String domainId) throws WTException;
	public FileObject[] listStoreFiles(StoreFileType fileType, int storeId, String path) throws FileSystemException, WTException;
	public FileObject getStoreFile(int storeId, String path) throws FileSystemException, WTException;
	public String addStoreFileFromStream(int storeId, String parentPath, String name, InputStream is) throws IOException, FileSystemException, WTException;
	public String addStoreFileFromStream(int storeId, String parentPath, String name, InputStream is, boolean overwrite) throws IOException, FileSystemException, WTException;
	public String addStoreFile(StoreFileType fileType, int storeId, String parentPath, String name) throws FileSystemException, WTException;
	public String renameStoreFile(int storeId, String path, String newName) throws FileSystemException, FileOverwriteException, WTException;
	public String renameStoreFile(int storeId, String path, String newName, boolean overwrite) throws FileSystemException, FileOverwriteException, WTException;
	public void deleteStoreFile(int storeId, String path) throws FileSystemException, WTException;
	public void deleteStoreFile(int storeId, Collection<String> paths) throws FileSystemException, WTException;
	public LinkedHashMap<String, SharingLink> listDownloadLinks(int storeId, String path) throws WTException;
	public LinkedHashMap<String, SharingLink> listUploadLinks(int storeId, String path) throws WTException;
	public SharingLink getSharingLink(String linkId) throws WTException;
	public SharingLink addDownloadLink(SharingLink link) throws WTException;
	public SharingLink addUploadLink(SharingLink link) throws WTException;
	public void updateSharingLink(SharingLink link) throws WTException;
	public void deleteSharingLink(String linkId) throws WTException;
	public URI[] getSharingLinkPublicURLs(SharingLink link) throws WTException;
	public String getSharingLinkEmbedCode(SharingLink link, Locale locale, String dateFormat);
	
	public static enum StoreFileType {
		@SerializedName("file") FILE,
		@SerializedName("folder") FOLDER,
		@SerializedName("fileOrFolder") FILE_OR_FOLDER
	}
	
	public static enum StoreFileTemplate {
		@SerializedName("txt") TEXT_FILE,
		@SerializedName("html") HTML_FILE,
		@SerializedName("docx") OOX_DOCUMENT, // MS Word - Office Open XML
		@SerializedName("xlsx") OOX_SPREADSHEET, // MS Excel - Office Open XML
		@SerializedName("pptx") OOX_PRESENTATION, // MS PowerPoint - Office Open XML
		//@SerializedName("odt") ODF_DOCUMENT, // OO Document - OASIS Open Document Format
		//@SerializedName("ods") ODF_SPREADSHEET, // OO Spreadsheet - OASIS Open Document Format
		//@SerializedName("odp") ODF_PRESENTATION, // OO Presentation - OASIS Open Document Format
	}
}
