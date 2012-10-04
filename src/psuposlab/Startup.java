/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package psuposlab;

/**
 *
 * @author production
 */
public class Startup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CashRegister cr = new CashRegister();
        
        cr.addItemToSale("M102", 4);
        cr.addItemToSale("W101", 3);
        cr.addItemToSale("M104", 1);
        cr.addItemToSale("W103", 1);
        
//        cr.setupTheCustomer("C003");
        cr.setupTheCustomer("C002");
                            
        cr.printTheReceipt();
    }
}
