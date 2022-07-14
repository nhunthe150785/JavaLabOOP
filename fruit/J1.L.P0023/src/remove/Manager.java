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
public class Manager {

    Scanner sc = new Scanner(System.in);

    public int Menu() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("\t1. Creat Fruit");
        System.out.println("\t2. Update Fruit");
        System.out.println("\t3. View orders");
        System.out.println("\t4. Shoping(for buyer)");
        System.out.println("\t5. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        return choice;
    }

    public void addFruit(ArrayList<Fruit> f) {
        sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Fruit ID : ");
            String fruitID = sc.nextLine();
            System.out.print("Enter Fruit Name : ");
            String fruitname = sc.nextLine();
            sc = new Scanner(System.in);
            System.out.print("Enter Price : ");
            int price = sc.nextInt();
            System.out.print("Enter Quality : ");
            int quality = sc.nextInt();
            System.out.print("Enter Origin : ");
            sc = new Scanner(System.in);
            String origin = sc.nextLine();
            f.add(new Fruit(fruitID, fruitname, price, quality, origin));
            System.out.println("Add Sucssesful!");
            if (!checkInputYN()) {
                return;
            }
        }
    }

    public boolean checkInputYN() {
        System.out.print("Do you want to continue (Y/N)? ");
        sc = new Scanner(System.in);
        //loop until user input correct
        while (true) {
            String result = sc.nextLine();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("n")) {
                return false;
            }
        }
    }

    public void updateFruit(ArrayList<Fruit> f, String n) {
        String k = "";
        int q = 0;
        for (int i = 0; i < f.size(); i++) {
            if (f.get(i).getFruitId().equals(n)) {
                System.out.print("Update Quanity : ");
                sc = new Scanner(System.in);
                q = sc.nextInt();
                f.get(i).setQuanlity(q);
                displayListFruit(f);
                break;
            } else {
                System.out.println("Do You want to Creat(Yes/No)?");
                sc = new Scanner(System.in);
                k = sc.nextLine();
                if (k.equalsIgnoreCase("yes")) {
                    addFruit(f);
                    displayListFruit(f);
                } else {
                    if (k.equalsIgnoreCase("no")) {
                        Menu();
                    }
                }

            }
        }
    }

    public void shoping(ArrayList<Fruit> f, Hashtable<String, ArrayList<Order>> ht) {
        sc = new Scanner(System.in);
        if (f.isEmpty()) {
            System.out.println("Don't have fruit!");
            return;
        }
        ArrayList<Order> lo = new ArrayList<>();
        while (true) {
            displayFruit(f);
            System.out.print("Enter Item: ");
            int Item = sc.nextInt();
            Fruit fru = getFruit(f, Item);
            System.out.println("You Choice: " + getNameFruit(f, Item));
            System.out.print("Please Input Quantily: ");
            int quality = checkInputIntLimit(1, fru.getQuanlity());
            fru.setQuanlity(fru.getQuanlity() - quality);
            if (!checkItemExist(lo, fru.getFruitId())) {
                updateOrder(lo, fru.getFruitId(), quality);
            } else {
                lo.add(new Order(fru.getFruitId(), fru.getFruitName(),
                        quality, fru.getPrice()));
            }
            if (!checkInputYN()) {
                break;
            }
        }
        displayOrder(lo);
        System.out.print("Enter name: ");
        sc = new Scanner(System.in);
        String name = sc.nextLine();
        ht.put(name, lo);
        System.err.println("Add successfull");
    }

    public static void updateOrder(ArrayList<Order> lo, String id, int quantity) {
        for (Order order : lo) {
            if (order.getFruitId().equalsIgnoreCase(id)) {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }

    public static boolean checkItemExist(ArrayList<Order> lo, String id) {
        for (Order order : lo) {
            if (order.getFruitId().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }

    public int checkInputIntLimit(int min, int max) {
        sc = new Scanner(System.in);
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String getNameFruit(ArrayList<Fruit> f, int item) {
        String k = "";
        int countItem = 1;
        for (Fruit fruit : f) {
            if (!fruit.getFruitName().isEmpty()) {
                countItem++;
            }
            if (countItem - 1 == item) {
                k += fruit.getFruitName();
            }
        }
        return k;
    }

    public Fruit getFruit(ArrayList<Fruit> f, int item) {
        int countItem = 1;
        for (Fruit fruit : f) {
            //check shop have item or not 
            if (fruit.getQuanlity() != 0) {
                countItem++;
            }
            if (countItem - 1 == item) {
                return fruit;
            }
        }
        return null;
    }

    public void viewOrder(Hashtable<String, ArrayList<Order>> ht) {
        if (ht.isEmpty()) {
            System.out.println("Don't have order today!");
            return;
        }
        for (String name : ht.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Order> lo = ht.get(name);
            displayOrder(lo);
        }
    }

    public void displayOrder(ArrayList<Order> lo) {
        System.out.printf("%15s%s%s%s\n", "Product|", "Quantity|", "Price|", "Amount");
        int total = 0;
        for (Order order : lo) {
            System.out.print("CoCount");
            System.out.printf("%5s%8d%7.0f$%7.0f$\n", order.getFruitName(),
                    order.getQuantity(), order.getPrice(),
                    order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
        }
        System.out.println("Total: " + total + "$");
    }

    public static void displayListFruit(ArrayList<Fruit> f) {
        System.out.printf("%s%s%s%s%s\n", "Fruit ID | ", "Name | ", "Price | ", "Quantily | ", "Origin");
        for (Fruit fruit : f) {
            if (!fruit.getFruitId().isEmpty()) {
                System.out.printf("%5s%9s%8d%8d%15s\n", fruit.getFruitId(),
                        fruit.getFruitName(), fruit.getPrice(), fruit.getQuanlity(), fruit.getOrigin());
            }
        }
    }

    public void displayFruit(ArrayList<Fruit> f) {
        int countItem = 1;
        System.out.printf("%s%s%s%s%s%s%s%s%s\n", "|++", "Item", "++|++", "Fruit name", "++|++", "Origin", "++|++", "Price", "++|");
        for (Fruit fruit : f) {
            //check shop have item or not 
            if (fruit.getQuanlity() != 0) {
                System.out.printf("%s%-13d%-14s%-11s%d$\n", " ", countItem++,
                        fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            }
        }
    }
}
