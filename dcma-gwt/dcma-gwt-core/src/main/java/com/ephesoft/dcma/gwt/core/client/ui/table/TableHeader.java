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

package com.ephesoft.dcma.gwt.core.client.ui.table;

import java.util.LinkedList;
import java.util.List;

import com.ephesoft.dcma.core.common.DomainProperty;

public class TableHeader {

	private final List<HeaderColumn> headerColumns = new LinkedList<HeaderColumn>();

	public void addHeaderColumn(HeaderColumn column) {
		headerColumns.add(column);
	}

	public List<HeaderColumn> getHeaderColumns(boolean isRadioButton) {
		boolean columnToAdd = true;
		if (isRadioButton) {
			for(HeaderColumn column : headerColumns) {
				if(column.getName().equalsIgnoreCase("radio")) {
					columnToAdd = false;
				}
			}
			if(columnToAdd) {
			HeaderColumn radioButton = new HeaderColumn(0, "radio", 5);
			headerColumns.add(0, radioButton);
			}
		}
		return headerColumns;
	}

	public HeaderColumn[] getHeaderColumns() {
		return headerColumns.toArray(new HeaderColumn[headerColumns.size()]);
	}

	public static class HeaderColumn {

		private final int index;
		private String name;
		private final int width;
		private boolean sortable;
		private boolean primaryAsc = true;
		private final DomainProperty domainProperty;

		public HeaderColumn(int index, String name, int width) {
			this(index, name, width, false, null);
		}

		public HeaderColumn(int index, String name, int width, boolean sortable, DomainProperty domainProperty) {
			this.index = index;
			this.name = name;
			this.width = width;
			this.sortable = sortable;
			this.domainProperty = domainProperty;
		}

		@Override
		public int hashCode() {
			int prime = 31;
			int result = 1;
			result = prime * result + index;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			boolean isEqual = true;
			if (this == obj){
				isEqual = true;
			}				
			if (obj == null){
				isEqual = false;
			}				
			if (getClass() != obj.getClass()){
				isEqual = false;
			}				
			HeaderColumn other = (HeaderColumn) obj;
			if (index != other.index){
				isEqual = false;
			}				
			if (name == null) {
				if (other.name != null){
					isEqual = false;
				}					
			} else if (!name.equals(other.name)){
				isEqual = false;
			}				
			return isEqual;
		}

		public int getIndex() {
			return index;
		}

		public String getName() {
			return name;
		}

		public int getWidth() {
			return width;
		}

		public DomainProperty getDomainProperty() {
			return domainProperty;
		}

		public boolean isPrimaryAsc() {
			return primaryAsc;
		}

		public void setPrimaryAsc(boolean primaryAsc) {
			this.primaryAsc = primaryAsc;
		}
		
		public void setName(String name) {
			this.name = name;
		}

		public void setSortable(boolean sortable) {
			this.sortable = sortable;
		}

		public boolean isSortable() {
			return sortable;
		}
	}
}
