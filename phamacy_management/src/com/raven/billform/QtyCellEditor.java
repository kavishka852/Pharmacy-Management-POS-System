
package com.raven.billform;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultFormatter;


public class QtyCellEditor extends DefaultCellEditor{
    private EventCellInputChange event;
    
    private JSpinner input;
    
    private JTable tableDark;
    private int row;
    private double cp;
    
    public QtyCellEditor() {
        super(new JCheckBox());
        input = new JSpinner();
        SpinnerNumberModel numberModel = (SpinnerNumberModel) input.getModel();
        numberModel.setMinimum(1);
        JSpinner.NumberEditor editor = (JSpinner.NumberEditor) input.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) editor.getTextField().getFormatter();
        formatter.setCommitsOnValidEdit(true);
        editor.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
        input.addChangeListener((ChangeEvent e) -> {
            inputChange();
        });
        
    }
    @Override
    public Component getTableCellEditorComponent(JTable tableDark, Object value, boolean isSelected, int row, int column) {
        super.getTableCellEditorComponent(tableDark, value, isSelected, row, column);
        this.tableDark = tableDark;
        this.row = row;
        int qty = Integer.parseInt(value.toString());
        input.setValue(qty);
        return input;
    }
    @Override
    public Object getCellEditorValue(){
        return input.getValue();
    }
    private void inputChange() {
        String p = TotalPrice.price;
        int qty = Integer.parseInt(input.getValue().toString());
        //Object currentPrice = tableDark.getValueAt(row, 3);
        double cPrice = Double.parseDouble(p.toString());
        cPrice =cPrice * qty;
        System.out.println("sadasdasda"+p);
        
        TableModel model = tableDark.getModel();
        
        if (qty == 0) {
             System.out.println("Error");
        }else {
            tableDark.getModel().setValueAt(cPrice, row, 3);
            System.out.println(qty);
        }
    }
}
