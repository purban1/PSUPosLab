package psuposlab;

import javax.swing.JOptionPane;

/**
 * This class outputs to the receipt to the Screen
 * @author Patrick Urban
 */
public class ReceiptOutputToScreen implements ReceiptOutputStrategy{

    
    @Override
    public void ouputTheReceipt(String receipt) {
        JOptionPane.showMessageDialog(null, receipt);
    }
    
}
