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
package com.floreantpos.ui.model;

import java.awt.BorderLayout;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import com.floreantpos.Messages;
import com.floreantpos.model.CouponAndDiscount;
import com.floreantpos.model.dao.CouponAndDiscountDAO;
import com.floreantpos.swing.FixedLengthDocument;
import com.floreantpos.swing.MessageDialog;
import com.floreantpos.ui.BeanEditor;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

/**
 * Created by IntelliJ IDEA.
 * User: mshahriar
 * Date: Oct 5, 2006
 * Time: 1:18:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class CouponForm extends BeanEditor {
    private JPanel contentPane;
    private JTextField tfCouponName;
    private JComboBox cbCouponType;
    private JFormattedTextField tfCouponValue;
    private JCheckBox chkDisabled;
    private JCheckBox chkNeverExpire;
    private JXDatePicker dpExperation;

    public CouponForm() {
        this(new CouponAndDiscount());
    }

    public CouponForm(CouponAndDiscount coupon) {
        this.setLayout(new BorderLayout());
        add(contentPane);

        tfCouponName.setDocument(new FixedLengthDocument(30));
        cbCouponType.setModel(new DefaultComboBoxModel(CouponAndDiscount.COUPON_TYPE_NAMES));

        setBean(coupon);
    }

    @Override
    public boolean save() {
        try {
            if (!updateModel()) return false;

            CouponAndDiscount coupon = (CouponAndDiscount) getBean();
            CouponAndDiscountDAO dao = new CouponAndDiscountDAO();
            dao.saveOrUpdate(coupon);
        } catch (Exception e) {
            MessageDialog.showError(com.floreantpos.POSConstants.SAVE_ERROR, e);
            return false;
        }
        return true;
    }

    @Override
    protected void updateView() {
        CouponAndDiscount coupon = (CouponAndDiscount) getBean();
        if (coupon == null) return;

        tfCouponName.setText(coupon.getName());
        tfCouponValue.setValue(Double.valueOf(coupon.getValue()));
        cbCouponType.setSelectedIndex(coupon.getType());
        dpExperation.setDate(coupon.getExpiryDate());
        chkDisabled.setSelected(coupon.isDisabled());
        chkNeverExpire.setSelected(coupon.isNeverExpire());
    }

    @Override
    protected boolean updateModel() {
        String name = tfCouponName.getText();
        double couponValue = 0;
        couponValue = ((Double) tfCouponValue.getValue()).doubleValue();
        int couponType = cbCouponType.getSelectedIndex();
        Date expiryDate = dpExperation.getDate();
        boolean disabled = chkDisabled.isSelected();
        boolean neverExpire = chkNeverExpire.isSelected();

        if (name == null || name.trim().equals("")) { //$NON-NLS-1$
            MessageDialog.showError(Messages.getString("CouponForm.1")); //$NON-NLS-1$
            return false;
        }
        if (couponType != CouponAndDiscount.FREE_AMOUNT && couponValue <= 0) {
            MessageDialog.showError(Messages.getString("CouponForm.2")); //$NON-NLS-1$
            return false;
        }

        CouponAndDiscount coupon = (CouponAndDiscount) getBean();
        coupon.setName(name);
        coupon.setValue(couponValue);
        coupon.setExpiryDate(expiryDate);
        coupon.setType(couponType);
        coupon.setDisabled(disabled);
        coupon.setNeverExpire(neverExpire);

        return true;
    }

    @Override
    public String getDisplayText() {
        CouponAndDiscount coupon = (CouponAndDiscount) getBean();
        if (coupon.getId() == null) {
            return Messages.getString("CouponForm.3"); //$NON-NLS-1$
        }
        return Messages.getString("CouponForm.4"); //$NON-NLS-1$
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new FormLayout("fill:d:noGrow,left:4dlu:noGrow,fill:d:grow,left:4dlu:noGrow,fill:100px:grow", "center:d:noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow")); //$NON-NLS-1$ //$NON-NLS-2$
        contentPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), null));
        final JLabel label1 = new JLabel();
        label1.setText(Messages.getString("CouponForm.0") + ":"); //$NON-NLS-1$ //$NON-NLS-2$
        CellConstraints cc = new CellConstraints();
        contentPane.add(label1, cc.xy(1, 1));
        final JLabel label2 = new JLabel();
        label2.setText(Messages.getString("CouponForm.9") + ":"); //$NON-NLS-1$ //$NON-NLS-2$
        contentPane.add(label2, cc.xy(1, 5));
        tfCouponName = new JTextField();
        contentPane.add(tfCouponName, cc.xyw(3, 1, 3, CellConstraints.FILL, CellConstraints.DEFAULT));
        dpExperation = new JXDatePicker();
        contentPane.add(dpExperation, cc.xy(3, 5));
        final JLabel label3 = new JLabel();
        label3.setText(Messages.getString("CouponForm.11") + ":"); //$NON-NLS-1$ //$NON-NLS-2$
        contentPane.add(label3, cc.xy(1, 3));
        cbCouponType = new JComboBox();
        contentPane.add(cbCouponType, cc.xy(3, 3));
        final JLabel label4 = new JLabel();
        label4.setText(Messages.getString("CouponForm.13") + ":"); //$NON-NLS-1$ //$NON-NLS-2$
        contentPane.add(label4, cc.xy(1, 7));
        tfCouponValue = new JFormattedTextField();
        contentPane.add(tfCouponValue, cc.xy(3, 7, CellConstraints.FILL, CellConstraints.DEFAULT));
        chkDisabled = new JCheckBox();
        chkDisabled.setText(Messages.getString("CouponForm.15")); //$NON-NLS-1$
        contentPane.add(chkDisabled, cc.xy(3, 9));
        chkNeverExpire = new JCheckBox();
        chkNeverExpire.setText(Messages.getString("CouponForm.16")); //$NON-NLS-1$
        contentPane.add(chkNeverExpire, cc.xy(3, 11));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}
