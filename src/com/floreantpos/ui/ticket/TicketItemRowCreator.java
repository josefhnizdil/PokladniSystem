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
package com.floreantpos.ui.ticket;

import java.util.List;
import java.util.Map;

import com.floreantpos.model.ITicketItem;
import com.floreantpos.model.Ticket;
import com.floreantpos.model.TicketItem;
import com.floreantpos.model.TicketItemCookingInstruction;
import com.floreantpos.model.TicketItemModifier;
import com.floreantpos.model.TicketItemModifierGroup;

public class TicketItemRowCreator {

	public static void calculateTicketRows(Ticket ticket, Map<String, ITicketItem> tableRows) {
		calculateTicketRows(ticket, tableRows, true, true);
	}

	public static void calculateTicketRows(Ticket ticket, Map<String, ITicketItem> tableRows, boolean includeModifiers, boolean includeCookingInstructions) {
		tableRows.clear();

		int rowNum = 0;

		if (ticket == null || ticket.getTicketItems() == null)
			return;

		List<TicketItem> ticketItems = ticket.getTicketItems();
		for (TicketItem ticketItem : ticketItems) {

			ticketItem.setTableRowNum(rowNum);
			tableRows.put(String.valueOf(rowNum), ticketItem);
			rowNum++;

			if (includeModifiers) {
				rowNum = includeModifiers(ticketItem, tableRows, rowNum, false);
			}

			if (includeCookingInstructions) {
				rowNum = includeCookintInstructions(ticketItem, tableRows, rowNum);
			}
		}
	}

//	public static void calculateKitchenTicketRows(KitchenTicket ticket, Map<String, ITicketItem> tableRows) {
//		tableRows.clear();
//
//		int rowNum = 0;
//
//		if (ticket == null || ticket.getTicketItems() == null)
//			return;
//
//		List<TicketItem> ticketItems = ticket.getTicketItems();
//		for (TicketItem ticketItem : ticketItems) {
//
//			ticketItem.setTableRowNum(rowNum);
//			tableRows.put(String.valueOf(rowNum), ticketItem);
//			rowNum++;
//
//			rowNum = includeModifiers(ticketItem, tableRows, rowNum, true);
//			rowNum = includeCookintInstructions(ticketItem, tableRows, rowNum);
//		}
//	}

	private static int includeCookintInstructions(TicketItem ticketItem, Map<String, ITicketItem> tableRows, int rowNum) {
		List<TicketItemCookingInstruction> cookingInstructions = ticketItem.getCookingInstructions();
		if (cookingInstructions != null) {
			for (TicketItemCookingInstruction ticketItemCookingInstruction : cookingInstructions) {
				ticketItemCookingInstruction.setTableRowNum(rowNum);
				tableRows.put(String.valueOf(rowNum), ticketItemCookingInstruction);
				rowNum++;
			}
		}
		return rowNum;
	}

	private static int includeModifiers(TicketItem ticketItem, Map<String, ITicketItem> tableRows, int rowNum, boolean kitchenPrint) {
		List<TicketItemModifierGroup> ticketItemModifierGroups = ticketItem.getTicketItemModifierGroups();
		if (ticketItemModifierGroups != null) {
			for (TicketItemModifierGroup ticketItemModifierGroup : ticketItemModifierGroups) {
				List<TicketItemModifier> ticketItemModifiers = ticketItemModifierGroup.getTicketItemModifiers();
				if (ticketItemModifiers != null) {
					for (TicketItemModifier itemModifier : ticketItemModifiers) {

						if (kitchenPrint && (itemModifier.isPrintedToKitchen() || !itemModifier.isShouldPrintToKitchen())) {
							continue;
						}

						itemModifier.setTableRowNum(rowNum);
						tableRows.put(String.valueOf(rowNum), itemModifier);
						rowNum++;
					}
				}
			}
		}
		return rowNum;
	}

}
