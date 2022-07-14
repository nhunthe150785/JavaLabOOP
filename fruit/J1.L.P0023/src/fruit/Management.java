package fruit;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author Nguyễn Thị Như !
 */
public class Management {

    private final ArrayList<Fruit> fruitList = new ArrayList<>();
    private final ArrayList<Order> orderList = new ArrayList<>();
    private final Hashtable<String, ArrayList<Order>> list = new Hashtable<>();
    private final Validation validation = new Validation();

    void displayListFruit() {
        System.out.printf("%-10s%-15s%-10s%-10s%-10s\n", "Fruit ID", "Name", "Price", "Quantity", "Origin");
        for (Fruit fruit : fruitList) {
            if (!fruit.getFruitId().isEmpty()) {
                System.out.printf("%-10s%-15s%-10.1f%-10d%-10s\n", fruit.getFruitId(),
                        fruit.getFruitName(), fruit.getPrice(), fruit.getQuantity(), fruit.getOrigin());
            }
        }
    }

    void addFruit() {
        Fruit fruit = new Fruit();
        while (true) {
            fruit.setFruitId(validation.getStringType("Fruit id: "));
            if (validation.checkIdExist(fruit.getFruitId()) == false) {
                System.out.println("Id already exist");
                return;
            }
            fruit.setFruitName(validation.getStringType("Fruit name: "));
            fruit.setPrice(validation.getDoubleType("Price: "));
            fruit.setQuantity(validation.getIntegerType("Quantity: "));
            fruit.setOrigin(validation.getStringType("Origin: "));
            if (validation.checkYesNo() == true) { //are you sure add fruit?
                fruitList.add(fruit);
                displayListFruit();
                return;
            }
            return;
        }
    }

    void updateFruit() {
        Scanner scanner = new Scanner(System.in);
        String id = validation.getStringType("Fruit id: ");
        for (int i = 0; i < fruitList.size(); i++) {
            if (fruitList.get(i).getFruitId().equals(id)) {
                int quantity = validation.getIntegerType("Update quantity: ");
                if (validation.checkYesNo() == true) {  //are you sure add fruit?
                    fruitList.get(i).setQuantity(quantity);
                    displayListFruit();
                    return;
                } else {
                    displayListFruit();
                    return;
                }

            }
        }
        while (true) {
            System.out.print("Id does not exist. Do you want to create product(yes/no)?: ");
            String check = scanner.nextLine();
            if (check.equalsIgnoreCase("yes")) {
                addFruit();
                return;
            }
            if (check.equalsIgnoreCase("no")) {
                return;
            }
        }
    }

    void displayListOrder() {
        System.out.printf("%-15s%-10s%-10s%-10s\n", "Product |", "Quantity |", "Price |", "Amount |");
        double totalAmount = 0;
        for (Order order : orderList) {
            System.out.print("Cocount");
            System.out.printf("%-10s%-5d%-5.1f$%-5.1f$\n",
                    order.getFruitName(), order.getQuantity(), order.getPrice(),
                    order.getQuantity() * order.getPrice());
            totalAmount += order.getQuantity() * order.getPrice();
        }
        System.out.println("Total amount: " + totalAmount + "$");
    }

    void viewOrder() {
        if (list.isEmpty()) {
            System.out.println("Don't have order !");
            return;
        }
        for (String name : list.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Order> order = list.get(name);
            displayListOrder();
        }
    }

    void displayFruit(){
        int countItem = 1;
        System.out.printf("%s%s%s%s%s%s%s%s%s\n", "|++", "Item", "++|++", "Fruit name", "++|++", "Origin", "++|++", "Price", "++|");
        for (Fruit fruit : fruitList) {
            if(fruit.getQuantity() != 0){
                System.out.printf("%d%-14sd%-11s%f$\n",countItem++,
                        fruit.getFruitName(),fruit.getOrigin(),fruit.getPrice());
            }
        }
    }
    
    Fruit getFruit(int item) {
        int countItem = 1;
        for (Fruit fruit : fruitList) {
            if (fruit.getQuantity() != 0) {
                countItem++;
            }
            if (countItem - 1 == item) {
                return fruit;
            }
        }
        return null;
    }

    String getNameFruit(int item) {
        String nameFruit = "";
        int countItem = 1;
        for (Fruit fruit : fruitList) {
            if (fruit.getFruitName().isEmpty()) {
                countItem++;
            }
            if (countItem - 1 == item) {
                nameFruit += fruit.getFruitName();
            }
        }
        return nameFruit;
    }

    void updateOrder(String id, int quantity) {
        for (Order order : orderList) {
            if (order.getFruitId().equalsIgnoreCase(id)) {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }

    void goShopping() {
        if (fruitList.isEmpty()) {
            System.out.println("Don't have fruit !");
            return;
        }
        while (true) {
            displayFruit();
            int item = validation.getIntegerType("Select item: ");
            Fruit fruit = getFruit(item);
            System.out.println("You selected: " + getNameFruit(item));
            int quantity = validation.getIntegerType("Please input quantity: ");
            fruit.setQuantity(fruit.getQuantity() - quantity);
            if (validation.checkItemExist(fruit.getFruitId()) == true) {
                updateOrder(fruit.getFruitId(), quantity);
            } else {
                orderList.add(new Order(fruit.getFruitId(), fruit.getFruitName(),
                        fruit.getPrice(), quantity));
            }
            if (validation.checkYesNo() == true) {
                break;
            }
        }
        displayListOrder();
        String name = validation.getStringType("Enter your name: ");
        list.put(name, orderList);
        System.out.println("Add successfull !");
    }

    public static void main(String[] args) {
        Management management = new Management();
        Validation validation = new Validation();
        while (true) {
            System.out.println("============== FRUIT SHOP SYSTEM ==============\n"
                    + "1. Creat Fruit\n"
                    + "2. Update Fruit\n"
                    + "3. View orders\n"
                    + "4. Shopping (for buyer)\n"
                    + "5. Exit");
            int option = 0;
            while (true) {
                option = validation.getIntegerType("Your choice: ");
                if (option >= 1 && option <= 5) {
                    break;
                }
            }
            switch (option) {
                case 1:
                    management.addFruit();
                    break;
                case 2:
                    management.updateFruit();
                    break;
                case 3:
                    management.viewOrder();
                    break;
                case 4:
                    management.goShopping();
                    break;
                case 5:
                    return;
            }
        }

    }

}
