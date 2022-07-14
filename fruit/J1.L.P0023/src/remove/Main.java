package remove;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mi tom
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Fruit> f = new ArrayList<>();
        Hashtable<String, ArrayList<Order>> ht = new Hashtable<>();
        Scanner sc = new Scanner(System.in);
        Manager m = new Manager();
        int k =0 ;
        while(k < 1) {  
            int choice = m.Menu();
            switch( choice ){
                case 1 : 
                    m.addFruit(f);
                    break;
                case 2 : 
                    String n="";
                    System.out.print("ID Fruit you want to update: ");
                    n = sc.nextLine();
                    m.updateFruit(f, n);
                    break;
                case 3 :
                    m.viewOrder(ht);
                    break;
                case 4 :
                    m.shoping(f, ht);
                    break;
                case 5 :
                    k =1;
                    break;
            }
        }
    }
    
}

