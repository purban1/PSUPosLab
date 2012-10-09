package psuposlab;

/**
 * This class outputs to the receipt to the console
 * @author Patrick Urban
 */
public class ReceiptOutputToConsole implements ReceiptOutputStrategy{

    
    @Override
    public void ouputTheReceipt(String receipt) {
        System.out.println(receipt);
    }
    
}
