/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package juice;

import java.io.FileNotFoundException;

/**
 *
 * @author Анна
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        try{

        Squeezer juice  = new Squeezer();
        juice.printIngridients();
        juice.printCodes();
        juice.printResult();

        }
        catch(FileNotFoundException e){
            System.err.println(" File not found");
        }
             catch(InterruptedException e){
            System.err.println(" Interrupted process ");

        }
    }

}
