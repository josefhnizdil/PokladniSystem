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
/*
 * CategoryBeanEditor.java
 *
 * Created on July 30, 2006, 11:20 PM
 */

package com.floreantpos.ui.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

import com.floreantpos.Messages;
import com.floreantpos.model.MenuCategory;
import com.floreantpos.model.dao.MenuCategoryDAO;
import com.floreantpos.swing.FixedLengthTextField;
import com.floreantpos.swing.IntegerTextField;
import com.floreantpos.swing.MessageDialog;
import com.floreantpos.ui.BeanEditor;
import com.floreantpos.util.POSUtil;

/**
 *
 * @author  MShahriar
 */
public class MenuCategoryForm extends BeanEditor {

	/** Creates new form CategoryBeanEditor */
	public MenuCategoryForm() throws Exception {
		this(new MenuCategory());
	}

	public MenuCategoryForm(MenuCategory category) throws Exception {
		initComponents();

		setBean(category);
	}

	public String getDisplayText() {
		MenuCategory foodCategory = (MenuCategory) getBean();
		if (foodCategory.getId() == null) {
			return com.floreantpos.POSConstants.NEW_MENU_CATEGORY;
		}
		return com.floreantpos.POSConstants.EDIT_MENU_CATEGORY;
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		chkVisible = new javax.swing.JCheckBox();
		tfName = new com.floreantpos.swing.FixedLengthTextField();
		tfName.setLength(120);
		chkBeverage = new javax.swing.JCheckBox();

		jLabel1.setText(com.floreantpos.POSConstants.NAME + ":"); //$NON-NLS-1$

		chkVisible.setText(com.floreantpos.POSConstants.VISIBLE);
		chkVisible.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		chkVisible.setMargin(new java.awt.Insets(0, 0, 0, 0));

		chkBeverage.setText(com.floreantpos.POSConstants.BEVERAGE);
		chkBeverage.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		chkBeverage.setMargin(new java.awt.Insets(0, 0, 0, 0));

		lblSortOrder = new JLabel(Messages.getString("MenuCategoryForm.1")); //$NON-NLS-1$

		tfSortOrder = new IntegerTextField();
		tfSortOrder.setColumns(10);

		lblButtonColor = new JLabel(Messages.getString("MenuCategoryForm.2")); //$NON-NLS-1$

		btnButtonColor = new JButton();
		btnButtonColor.setPreferredSize(new Dimension(140, 40));
		
		setLayout(new MigLayout("", "[87px][327px,grow]", "[19px][][19px][][][21px][15px]")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		add(jLabel1, "cell 0 0,alignx left,aligny center"); //$NON-NLS-1$
		
		lblTranslatedName = new JLabel(Messages.getString("MenuCategoryForm.7")); //$NON-NLS-1$
		add(lblTranslatedName, "cell 0 1,alignx trailing"); //$NON-NLS-1$
		
		tfTranslatedName = new FixedLengthTextField();
		tfTranslatedName.setLength(120);
		add(tfTranslatedName, "cell 1 1,growx"); //$NON-NLS-1$
		add(lblSortOrder, "cell 0 2,alignx left,aligny center"); //$NON-NLS-1$
		add(lblButtonColor, "cell 0 3,alignx left,growy"); //$NON-NLS-1$
		add(tfName, "cell 1 0,growx,aligny top"); //$NON-NLS-1$
		add(tfSortOrder, "cell 1 2,alignx left,aligny top"); //$NON-NLS-1$
		
		lblTextColor = new JLabel("Text color"); //$NON-NLS-1$
		add(lblTextColor, "cell 0 4"); //$NON-NLS-1$
		
		btnTextColor = new JButton();
		btnTextColor.setText(Messages.getString("MenuCategoryForm.16")); //$NON-NLS-1$
		btnTextColor.setPreferredSize(new Dimension(140, 40));
		add(btnTextColor, "cell 1 4,growy"); //$NON-NLS-1$
		add(chkBeverage, "cell 1 5,alignx left,growy"); //$NON-NLS-1$
		add(chkVisible, "cell 1 6,alignx left,aligny top"); //$NON-NLS-1$
		add(btnButtonColor, "cell 1 3,alignx left,growy"); //$NON-NLS-1$
		
		btnButtonColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(MenuCategoryForm.this, Messages.getString("MenuCategoryForm.21"), btnButtonColor.getBackground()); //$NON-NLS-1$
				btnButtonColor.setBackground(color);
				btnTextColor.setBackground(color);
			}
		});
		
		btnTextColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(MenuCategoryForm.this, Messages.getString("MenuCategoryForm.22"), btnTextColor.getForeground()); //$NON-NLS-1$
				btnTextColor.setForeground(color);
			}
		});
	}// </editor-fold>//GEN-END:initComponents

	protected void updateView() {
		MenuCategory menuCategory = (MenuCategory) getBean();

		if (menuCategory == null) {
			tfName.setText(""); //$NON-NLS-1$
			tfTranslatedName.setText(""); //$NON-NLS-1$
			tfSortOrder.setText("0"); //$NON-NLS-1$
			chkVisible.setSelected(false);
			return;
		}
		
		tfName.setText(menuCategory.getName());
		tfTranslatedName.setText(menuCategory.getTranslatedName());
		
		if (menuCategory.getSortOrder() != null) {
			tfSortOrder.setText(menuCategory.getSortOrder().toString());
		}

		if (menuCategory.getButtonColor() != null) {
			Color color = new Color(menuCategory.getButtonColor());
			btnButtonColor.setBackground(color);
			btnTextColor.setBackground(color);
		}
		
		if(menuCategory.getTextColor() != null) {
			Color color = new Color(menuCategory.getTextColor());
			btnTextColor.setForeground(color);
		}
		
		chkBeverage.setSelected(menuCategory.isBeverage());
		if (menuCategory.getId() == null) {
			chkVisible.setSelected(true);
		}
		else {
			chkVisible.setSelected(menuCategory.isVisible());
		}
	}

	protected boolean updateModel() {
		MenuCategory menuCategory = (MenuCategory) getBean();
		if (menuCategory == null) {
			return false;
		}

		String categoryName = tfName.getText();
		if (POSUtil.isBlankOrNull(categoryName)) {
			MessageDialog.showError(Messages.getString("MenuCategoryForm.26")); //$NON-NLS-1$
			return false;
		}

		menuCategory.setName(categoryName);
		menuCategory.setTranslatedName(tfTranslatedName.getText());
		menuCategory.setSortOrder(tfSortOrder.getInteger());

		menuCategory.setButtonColor(btnButtonColor.getBackground().getRGB());
		menuCategory.setTextColor(btnTextColor.getForeground().getRGB());
		
		menuCategory.setBeverage(chkBeverage.isSelected());
		menuCategory.setVisible(chkVisible.isSelected());

		return true;
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JCheckBox chkBeverage;
	private javax.swing.JCheckBox chkVisible;
	private javax.swing.JLabel jLabel1;
	private com.floreantpos.swing.FixedLengthTextField tfName;
	private IntegerTextField tfSortOrder;
	private JButton btnButtonColor;
	private JLabel lblSortOrder;
	private JLabel lblButtonColor;
	private JLabel lblTranslatedName;
	private FixedLengthTextField tfTranslatedName;
	private JLabel lblTextColor;
	private JButton btnTextColor;

	// End of variables declaration//GEN-END:variables
	@Override
	public boolean save() {
		try {
			
			if (!updateModel())
				return false;

			MenuCategory menuCategory = (MenuCategory) getBean();
			MenuCategoryDAO.getInstance().saveOrUpdate(menuCategory);
			
			return true;
			
		} catch (Exception x) {
			MessageDialog.showError(x);
			return false;
		}
	}
}
