import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    private ArrayList<Cupcake> cupcakeMenu;
    private ArrayList<Drink> drinkMenu;

    public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu) {
        this.cupcakeMenu = cupcakeMenu;
        this.drinkMenu = drinkMenu;

    }

    public <T> void takeOder() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello customer. Would you like to place an order? (Y or N)");
        List<T> order = new ArrayList<T>();
        String placeOrder = scanner.nextLine();
        if ((placeOrder).toLowerCase().equals("y")) {
            System.out.println("working");
        } else {
            System.out.println("have a nice day");
        }

        order.add((T) LocalDate.now());
        order.add((T) LocalDate.now());
        System.out.println("Here is the menu for CUPCAKES: ");
        int itemNumber = 0;
        for (Cupcake cupcake : cupcakeMenu) {
            itemNumber++;
            System.out.print(itemNumber + ": ");
            cupcake.type();
            System.out.println(cupcake.getPrice());
        }

        for (Drink drink : this.drinkMenu) {
            itemNumber++;
            System.out.print(itemNumber + ": ");
            drink.type();
            System.out.println(drink.getPrice());

        }
        //throw away
        boolean ordering = true;
        while (ordering) {
            System.out.println("What would you like to order?");
            int orderChoice = scanner.nextInt();

            if (orderChoice == 1) {
                order.add((T) cupcakeMenu.get(0));
                System.out.println("Item Added to order");
            } else if (orderChoice == 2) {
                order.add((T) cupcakeMenu.get(1));
                System.out.println("Item Added to order");
            } else if (orderChoice == 3) {
                order.add((T) cupcakeMenu.get(2));
                System.out.println("Item Added to order");
            } else if (orderChoice == 4) {
                order.add((T) drinkMenu.get(0));
                System.out.println("Item Added to order");
            } else if (orderChoice == 5) {
                order.add((T) drinkMenu.get(1));
                System.out.println("Item Added to order");
            } else if (orderChoice == 6) {
                order.add((T) drinkMenu.get(2));

            } else {
                System.out.println("Sorry, we don’t seem to have that on the menu.");
            }

            System.out.println("Would you like to continue ordering? (Y/N)");
            scanner.nextLine();
            placeOrder = scanner.nextLine();
            if (placeOrder.equalsIgnoreCase("y")) {

            } else {
                ordering = false;
                System.out.println(order);
            }
        }

    }
}
