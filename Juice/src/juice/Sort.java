/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package juice;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Анна
 */
public class Sort implements Runnable{
    private  ArrayList<String> ingridients = new ArrayList(100);
    public Sort(Set<String> ingridients) {
     Iterator<String> it = ingridients.iterator();
while(it.hasNext()){
this.ingridients.add(it.next());
}
    }
    public void run() {
        try {
            PrintStream ps = new PrintStream("juice2.txt");
            Comparator<String> comparator = new Comparator<String>(){
        public int compare(String o1, String o2){
            return o1.compareTo(o2);

        }
      };
         Collections.sort(ingridients,comparator);
     for(int i=0;i<ingridients.size();i++){
       ps.print(ingridients.get(i)+" ");

     }
    }
     catch (FileNotFoundException ex) {
            Logger.getLogger(Sort.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
