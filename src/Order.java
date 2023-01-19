import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

    @Override
    public String toString() {
        return "Order{" +
                "cupcakeMenu=" + cupcakeMenu +
                ", drinkMenu=" + drinkMenu +
                '}';
    }

    public void takeOder() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello customer. Would you like to place an order? (Y or N)");
        List<Object> order = new ArrayList<Object>();
        String placeOrder = scanner.nextLine();
        if ((placeOrder).toLowerCase().equals("y")) {
            System.out.println("working");
        } else {
            System.out.println("have a nice day");
        }

        order.add((Object) LocalDate.now());
        order.add((Object) LocalDate.now());
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
                order.add((Object) cupcakeMenu.get(0));
                System.out.println("Item Added to order");
            } else if (orderChoice == 2) {
                order.add((Object) cupcakeMenu.get(1));
                System.out.println("Item Added to order");
            } else if (orderChoice == 3) {
                order.add((Object) cupcakeMenu.get(2));
                System.out.println("Item Added to order");
            } else if (orderChoice == 4) {
                order.add((Object) drinkMenu.get(0));
                System.out.println("Item Added to order");
            } else if (orderChoice == 5) {
                order.add((Object) drinkMenu.get(1));
                System.out.println("Item Added to order");
            } else if (orderChoice == 6) {
                order.add((Object) drinkMenu.get(2));

            } else {
                System.out.println("Sorry, we don’t seem to have that on the menu.");
            }

            System.out.println("Would you like to continue ordering? (Y/N)");
            scanner.nextLine();
            placeOrder = scanner.nextLine();
            if (placeOrder.equalsIgnoreCase("y")) {

            } else {
                ordering = false;

            }
        }

        System.out.println(order);
        System.out.println(order.get(2));
        double subTotal = 0.0;
        for (int i = 2; i < order.size(); i++) {
            if (order.get(i).equals(cupcakeMenu.get(0))) {
                cupcakeMenu.get(0).type();
                System.out.println(cupcakeMenu.get(0).getPrice());
                subTotal += subTotal + cupcakeMenu.get(0).getPrice();
            } else if (order.get(i).equals(cupcakeMenu.get(1))) {
                cupcakeMenu.get(1).type();
                System.out.println(cupcakeMenu.get(1).getPrice());
                subTotal += subTotal + cupcakeMenu.get(1).getPrice();
            } else if (order.get(i).equals(cupcakeMenu.get(2))) {
                cupcakeMenu.get(2).type();
                System.out.println(cupcakeMenu.get(2).getPrice());
                subTotal += subTotal + cupcakeMenu.get(2).getPrice();
            } else if (order.get(i).equals(drinkMenu.get(0))) {
                drinkMenu.get(0).type();
                System.out.println(drinkMenu.get(0).getPrice());
                subTotal += subTotal + drinkMenu.get(0).getPrice();
            } else if (order.get(i).equals(drinkMenu.get(1))) {
                drinkMenu.get(1).type();
                System.out.println(drinkMenu.get(1).getPrice());
                subTotal += subTotal + drinkMenu.get(1).getPrice();
            } else if (order.get(i).equals(drinkMenu.get(2))) {
                drinkMenu.get(2).type();
                System.out.println(drinkMenu.get(2).getPrice());
                subTotal += subTotal + drinkMenu.get(2).getPrice();
            }

        }

        System.out.println("$" + subTotal + "\n");

    }
}


class CreateFile {
    public CreateFile() {

        try {
            File salesData = new File("salesData.txt");

            if (salesData.createNewFile()) {
                System.out.println("file created successfully" + salesData.getName());
            } else {
                System.out.println("File already exists");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class WriteToFile {
    private ArrayList<Object> order;

    public WriteToFile(ArrayList<Object> order) {
        this.order = order;


        try {
            FileWriter fw = new FileWriter("salesData.txt", true);

            PrintWriter salesWriter = new PrintWriter(fw);

            for (int i = 0; i < order.size(); i++) {
                salesWriter.println(order.get(i));

            }
            salesWriter.close();
            System.out.println("Successfully wrote to the file");
        } catch (IOException ex) {
            System.out.println("An error occurred");
            throw new RuntimeException(ex);
        }

    }


}