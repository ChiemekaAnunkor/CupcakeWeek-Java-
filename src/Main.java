import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Cupcake> cupcakeManu = new ArrayList<>();
        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();
        //cupcake
        System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu but we need to decide on pricing.");
        Scanner input = new Scanner(System.in);
        System.out.println("We are deciding on the price for our standard cupcake. Here is the description:");
        cupcake.type();
        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        String priceText = input.nextLine();
        double price = Double.parseDouble(priceText);
        cupcake.setPrice(price);
        ///redvelvet
        System.out.println("We are deciding on the price for our standard cupcake. Here is the description:");
        redVelvet.type();
        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        redVelvet.setPrice(price);

        //chocolate
        System.out.println("We are deciding on the price for our standard cupcake. Here is the description:");
        chocolate.type();
        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        chocolate.setPrice(price);

        cupcakeManu.add(cupcake);
        cupcakeManu.add(redVelvet);
        cupcakeManu.add(chocolate);


    }

}

class Cupcake {

    public double price;

    public Cupcake() {

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void type() {
        System.out.println("A basic, generic cupcake, with vanilla frosting");
    }


}

class RedVelvet extends Cupcake {


    @Override
    public void type() {
        super.type();

        System.out.println("A red velvet based cupcake, with cream cheese frosting.");
    }
}

class Chocolate extends Cupcake {
    @Override
    public void type() {
        super.type();
        System.out.println("A chocolate based cupcake, with chocolate frosting.");
    }
}