/**
 * eobjects.org SassyReader
 * Copyright (C) 2011 eobjects.org
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.eobjects.metamodel.sas;

import java.util.Date;

/**
 * Represents the header metadata in the sas7bdat file format.
 *
 * @author Kasper Sørensen
 */
final class SasHeader {

	private final boolean u64;
	private final int pageSize;
	private final long pageCount;
	private final String sasRelease;
	private final String sasHost;
	private final String sasFile;
	private final String datasetName;
	private final String fileType;
	private final Date dateCreated;
	private final Date dateModified;
	private final String osVersion;
	private final String osVendor;
	private final String osName;

	public SasHeader(boolean u64, int pageSize, long pageCount, String sasRelease, String sasHost, String sasFile, String datasetName, String fileType, Date dateCreated, Date dateModified, String osVersion, String osVendor, String osName) {
		this.u64 = u64;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.sasRelease = sasRelease;
		this.sasHost = sasHost;
		this.sasFile = sasFile;
		this.datasetName = datasetName;
		this.fileType = fileType;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
		this.osVersion = osVersion;
		this.osVendor = osVendor;
		this.osName = osName;
	}

	public boolean isU64() {
		return u64;
	}

	public int getPageSize() {
		return pageSize;
	}

	public long getPageCount() {
		return pageCount;
	}

	public String getSasRelease() {
		return sasRelease;
	}

	public String getSasHost() {
		return sasHost;
	}

	public String getSasFile() {
		return sasFile;
	}

	public String getDatasetName() {
		return datasetName;
	}

	public String getFileType() {
		return fileType;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public String getOsVendor() {
		return osVendor;
	}

	public String getOsName() {
		return osName;
	}

	@Override
	public String toString() {
		return "SasHeader [" + "u64=" + u64 +
				", pageSize=" + pageSize +
				", pageCount=" + pageCount +
				", sasRelease='" + sasRelease + '\'' +
				", sasHost='" + sasHost + '\'' +
				", sasFile='" + sasFile + '\'' +
				", datasetName='" + datasetName + '\'' +
				", fileType='" + fileType + '\'' +
				", dateCreated=" + dateCreated +
				", dateModified=" + dateModified +
				", osVersion='" + osVersion + '\'' +
				", osVendor='" + osVendor + '\'' +
				", osName='" + osName + '\'' +
				']';
	}
}
