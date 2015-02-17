/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package juice;

import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
public class Squeezer {
    private  Set<String> ingridients;
private ArrayList<Cocteil> juices;
private int size = 0;

public Squeezer() throws FileNotFoundException{
Scanner scanner = new Scanner(new File("juice.txt"));
ingridients = new HashSet<String>(100);
juices = new ArrayList <Cocteil>(100);
String temp;
while(scanner.hasNextLine()){
  Cocteil tmp = new Cocteil();
  temp = scanner.nextLine();
 if(!temp.isEmpty()){
   StringTokenizer tok = new StringTokenizer(temp," ");
while(tok.hasMoreTokens()){
 temp = tok.nextToken();
 ingridients.add(temp);
 tmp.add(temp);
}
juices.add(tmp);
size++;
}
}
  }
public ArrayList<Cocteil> getCocteil(){
    return juices;
}
public void printIngridients() throws FileNotFoundException{
PrintStream ps = new PrintStream("juice1.txt");
Iterator<String> it = ingridients.iterator();
ps.println("В порядке их следования");
while(it.hasNext()){
ps.println(it.next());
}
sort();
}
public void printCodes() throws InterruptedException{

    Runnable r = new Sort(ingridients);
    Thread my = new Thread(r);
    my.start();
    my.join();
}

public void sort(){
    Comparator<Cocteil> comparator = new Comparator<Cocteil>(){
        public int compare(Cocteil o1, Cocteil o2){
            return o1.getSize()-o2.getSize();

        }
      };
      Collections.sort(juices,comparator);
}
public void printResult() throws FileNotFoundException{
PrintStream ps = new PrintStream("juice3.txt");
ArrayList<Integer> list = new ArrayList<Integer>(size);
for(int i=0; i<size;i++){
    list.add(1);
}
int count = 0;
int i = 0;
boolean f = true;
boolean F;
while( i< juices.size() && f){
    F = false;
    int j = i;
    for(int k = 0; k<size;k++){
        list.set(i, 0);
        if(list.get(k)==1)
        if(juices.get(i).contains(juices.get(k))){
            list.set(k, 0);
            i = k;
            F = true;

        }
    } i = j; i++;
    count++;
    if( i< size -1)
    if(list.get(i)==0){
        while (list.get(i)==0) { i++; if(i == size-1) break;}
    }

    if(isEmpty(list)) f = false;
}

ps.println(count);


}
public boolean isEmpty(ArrayList<Integer> tmp){
    for(int i=0; i<tmp.size();i++){
        if(tmp.get(i) != 0) return false;
    }
    return true;
}


}
