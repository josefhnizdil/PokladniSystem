/**
 * ************************************************************************
 * * The contents of this file are subject to the MRPL 1.2
 * * (the  "License"),  being   the  Mozilla   Public  License
 * * Version 1.1  with a permitted attribution clause; you may not  use this
 * * file except in compliance with the License. You  may  obtain  a copy of
 * * the License at http://www.floreantpos.org/license.html
 * * Software distributed under the License  is  distributed  on  an "AS IS"
 * * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * * License for the specific  language  governing  rights  and  limitations
 * * under the License.
 * * The Original Code is FLOREANT POS.
 * * The Initial Developer of the Original Code is OROCUBE LLC
 * * All portions are Copyright (C) 2015 OROCUBE LLC
 * * All Rights Reserved.
 * ************************************************************************
 */
package com.floreantpos.customer;

import java.util.List;

import com.floreantpos.Messages;
import com.floreantpos.model.Customer;
import com.floreantpos.swing.ListTableModel;

public class CustomerListTableModel extends ListTableModel<Customer> {
	private final static String[] columns = { Messages.getString("CustomerListTableModel.0"), Messages.getString("CustomerListTableModel.1"), Messages.getString("CustomerListTableModel.2"), Messages.getString("CustomerListTableModel.3"), Messages.getString("CustomerListTableModel.4"), Messages.getString("CustomerListTableModel.5") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$

	public CustomerListTableModel() {
		super(columns);
	}

	public CustomerListTableModel(List<Customer> customers) {
		super(columns, customers);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Customer customer = getRowData(rowIndex);

		switch (columnIndex) {
			case 0:
				return customer.getHomePhoneNo();
			case 1:
				return customer.getFirstName();

			case 2:
				return customer.getDob();
				
			case 3:
				return customer.getAddress();
				
			case 4:
				return customer.getCity();
				
			case 5:
				return customer.getState();

		}
		return null;
	}
}