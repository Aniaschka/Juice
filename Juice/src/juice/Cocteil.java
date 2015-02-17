/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package juice;

import java.util.ArrayList;

/**
 *
 * @author Анна
 */
public class Cocteil {
    private ArrayList<String> cocteil = new ArrayList<String>(10);
    private int size = 0;
    public Cocteil(){

    }
    public void add(String temp){
        boolean f = true;
        for(int i=0; i<size;i++)
            if(temp.equals(get(i)))
                f = false;
        if(f){
            cocteil.add(temp);
            size++;
        }
    }
    public String get(int i){
        return cocteil.get(i);
    }
    public int getSize(){ return size; }
    public boolean isEqual(Cocteil tmp){
        int count = 0;
        for(int i=0; i< size ;i++){
            for(int j=0; j< size ;j++){
                if(cocteil.get(i).equals(tmp.get(j))){
                    count++;
                }
            }
                   }
        if(count==size) return true;
        return false;
    }
   public boolean contains( Cocteil tmp){
       int count = 0;
               
               for(int i=0; i< getSize();i++){
                   for(int j=0; j < tmp.getSize();j++){
               if(cocteil.get(i).equals(tmp.get(j))){
                   count++;
               }
                   if( count== getSize())
           return true;
                   }
         }
       if( count== getSize())
           return true;
       else return false;
   }
}
