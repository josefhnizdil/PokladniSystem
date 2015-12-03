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
 * OkCancelDialog.java
 *
 * Created on July 30, 2006, 10:36 PM
 */

package com.floreantpos.ui.dialog;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.floreantpos.main.Application;
import com.floreantpos.swing.PosButton;
import com.floreantpos.ui.BeanEditor;
import com.floreantpos.util.POSUtil;

/**
 *
 * @author  MShahriar
 */
public class BeanEditorDialog extends javax.swing.JDialog implements WindowListener {
	protected BeanEditor beanEditor;
	private boolean canceled = false;
	
	public BeanEditorDialog() {
		this(null);
	}


	public BeanEditorDialog(BeanEditor beanEditor) {
		super(POSUtil.getFocusedWindow(), ModalityType.APPLICATION_MODAL);
		initComponents();

		setBeanEditor(beanEditor);

		addWindowListener(this);
	}


	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
	private void initComponents() {
		titlePanel = new com.floreantpos.ui.TitlePanel();
		jPanel1 = new com.floreantpos.swing.TransparentPanel();
		jSeparator1 = new javax.swing.JSeparator();
		buttonPanel = new com.floreantpos.swing.TransparentPanel();
		btnOk = new PosButton();
		btnCancel = new PosButton();
		beanEditorContainer = new com.floreantpos.swing.TransparentPanel();

		setIconImage(Application.getApplicationIcon().getImage());
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE); 
		getContentPane().add(titlePanel, java.awt.BorderLayout.NORTH);

		jPanel1.setLayout(new java.awt.BorderLayout());

		jPanel1.add(jSeparator1, java.awt.BorderLayout.NORTH);

		buttonPanel.setLayout(new java.awt.FlowLayout());

		btnOk.setPreferredSize(new Dimension(100, 60));
		btnOk.setText(com.floreantpos.POSConstants.OK.toUpperCase());
		btnOk.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				performOk(evt);
			}
		});

		buttonPanel.add(btnOk);

		btnCancel.setPreferredSize(new Dimension(100, 60));
		btnCancel.setText(com.floreantpos.POSConstants.CANCEL.toUpperCase());
		btnCancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				performCancel(evt);
			}
		});

		buttonPanel.add(btnCancel);

		jPanel1.add(buttonPanel, java.awt.BorderLayout.CENTER);

		getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

		beanEditorContainer.setLayout(new java.awt.BorderLayout());

		getContentPane().add(beanEditorContainer, java.awt.BorderLayout.CENTER);
	}// </editor-fold>//GEN-END:initComponents

	@Override
	public void dispose() {
		if (beanEditor != null) {
			beanEditor = null;
		}

		super.dispose();
	}

	private void performCancel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_performCancel
		canceled = true;
		dispose();
	}//GEN-LAST:event_performCancel

	private void performOk(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_performOk
		if (beanEditor == null) {
			return;
		}

		boolean saved = beanEditor.save();
		if (saved) {
			dispose();
		}
	}//GEN-LAST:event_performOk

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private com.floreantpos.swing.TransparentPanel beanEditorContainer;
	private PosButton btnCancel;
	private PosButton btnOk;
	private com.floreantpos.swing.TransparentPanel jPanel1;
	private com.floreantpos.swing.TransparentPanel buttonPanel;
	private javax.swing.JSeparator jSeparator1;
	private com.floreantpos.ui.TitlePanel titlePanel;

	// End of variables declaration//GEN-END:variables

	public void setTitle(String title) {
		super.setTitle(title);

		titlePanel.setTitle(title);
	}

	public void open() {
		canceled = false;
		this.pack();
		this.setLocationRelativeTo(this.getOwner());
		super.setVisible(true);
	}

	public boolean isCanceled() {
		return canceled;
	}

	public Frame getParentFrame() {
		return (Frame) getOwner();
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
		performCancel(null);
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public BeanEditor getBeanEditor() {
		return beanEditor;
	}

	public Object getBean() {
		if (beanEditor != null) {
			return beanEditor.getBean();
		}
		return null;
	}

	public void setBean(Object bean) {
		if (beanEditor != null) {
			beanEditor.setBean(bean);
		}
	}

	public void setBeanEditor(BeanEditor beanEditor) {
		if (this.beanEditor != beanEditor) {
			this.beanEditor = beanEditor;
			beanEditorContainer.removeAll();

			if (beanEditor != null) {
				beanEditor.setEditorDialog(this);
				beanEditorContainer.add(beanEditor);
				setTitle(beanEditor.getDisplayText());
			}
			beanEditorContainer.revalidate();
		}
	}
	
	public com.floreantpos.swing.TransparentPanel getButtonPanel() {
		return buttonPanel;
	}
}
