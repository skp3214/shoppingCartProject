package shoppingCartProject;

import java.util.Scanner;

public class Main {
    static boolean isChecked = false;
    private static Scanner scanner = new Scanner(System.in);
    private static Product[] allProducts = {
            new Product(11, "Apple", 10),
            new Product(31, "Potato", 3),
            new Product(54, "Shampoo", 100),
            new Product(62, "Colgate", 35),
            new Product(69, "HandkerChief", 25),
            new Product(36, "Trimmer", 800),
            new Product(26, "Type-C DataCable", 120),
            new Product(96, "Pencil", 5),
    };

    private static Product chooseProduct() {
        System.out.println("Available products: ");
        System.out.println("-------------------------------------------");
        System.out.println("ID        |Item                |Rs        |");
        System.out.println("-------------------------------------------");

        for (Product product : allProducts) {
            System.out.print(product.getDisplayName());
        }
        System.out.println("-------------------------------------------");
        System.out.println();
        System.out.println("Enter 0 for EXIT ");
        System.out.println("");
        System.out.print("Enter the ID to add the item: ");

        int choice = scanner.nextInt();
        for (Product product : allProducts) {
            if (product.getId() == (choice)) {
                return product;
            } else if (choice == 0) {
                return null;
            }
        }
        System.out.println("Product not found");
        return null;
    }

    private static Product chooseFromCart(Cart cart) {
        System.out.println("Product in your cart are: ");
        System.out.println("------------------------------------------------------");
        System.out.println("ID        |Qty       |Item                |Rs        |");
        System.out.println("------------------------------------------------------");

        System.out.println(cart.viewCart());
        System.out.println();
        System.out.println("Enter 0 for EXIT");
        System.out.println();
        System.out.print("Enter the ID of the item to remove it from cart: ");
        int choice = scanner.nextInt();
        System.out.println();

        for (Product product : allProducts) {
            if (product.getId() == (choice)) {
                return product;
            } else if (choice == 0) {
                return null;
            }
        }
        System.out.println("Product not found");
        System.out.println();
        return null;
    }

    private static boolean checkout(Cart cart) {
        if (cart.isEmpty()) {
            return false;
        }

        int total = cart.getTotal();
        System.out.print("Pay Here: ");
        int paid = scanner.nextInt();

        if (paid > total) {
            System.out.println();
            System.out.println("------------------------------");
            System.out.println("Change: " + (paid - total));
            System.out.println("Thank you for shopping with us.");
            System.out.println("------------------------------");
            System.out.println();
            isChecked = true;
            return true;
        } else {
            System.out.println();
            System.out.println("-------------------");
            System.out.println("Not enough cash!");
            System.out.println("-------------------");
            System.out.println();
            return false;
        }
    }

    public static void main(String[] args) {
        int action;
        Cart cart = new Cart();
        boolean go = true;
        while (go) {
            System.out.println();
            System.out.println("1. Add Item to Cart");
            System.out.println("2. Remove item from cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Select an action: ");
            action = scanner.nextInt();
            System.out.println();

            if (action == 1) {
                Product product = chooseProduct();
                if (product != null) {
                    System.out.println();
                    System.out.println("---------------------------------------------");
                    System.out.println(product.getName() + " -> added to the cart.");
                    System.out.println("---------------------------------------------");
                    System.out.println();
                    cart.addProduct(product);
                }
            } else if (action == 2) {
                Product product = chooseFromCart(cart);
                if (product != null) {
                    cart.removeProduct(product);
                }

            } else if (action == 3) {
                System.out.println("-------------------\n");
                System.out.println("Product in your cart are: ");
                System.out.println("------------------------------------------------------");
                System.out.println("ID        |Qty       |Item                |Rs        |");
                System.out.println("------------------------------------------------------");
                System.out.println(cart.viewCart());
                System.out.println("--------------------\n");
            } else if (action == 4) {
                System.out.println("Product in your cart are: ");
                System.out.println("------------------------------------------------------");
                System.out.println("ID        |Qty       |Item                |Rs        |");
                System.out.println("------------------------------------------------------");
                System.out.println(cart.viewCart());
                if (checkout(cart)) {
                    go = false;
                }
            } else if (action == 5) {
                if (cart.isEmpty()) {
                    System.out.println();
                    System.out.println("Your Cart is empty.");
                    System.out.println("Thanks for visiting us.");
                    System.out.println();
                    go = false;
                } else {
                    if (isChecked == true) {
                        go = false;
                    } else {
                        System.out.println("--------------------------");
                        System.out.println("Can't go without checkout.");
                        System.out.println("--------------------------");
                        go = true;
                    }
                }
            } else {
                System.out.println("Choose correct option.");
                go = true;
            }
        }
    }
}
