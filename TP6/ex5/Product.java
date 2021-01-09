import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Product {
    int number = 120, amount;
    String name;
    double price;
    ArrayList<Product> products = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public Product(int number, String name, double price, int amount) {
        this.number = number;
        this.name = name;
        if (price >= 0) {
            this.price = price;
        }
        if (amount >= 0) {
            this.amount = amount;
        }
    }

    public Product() {

    }

    public int getAmount() {
        return amount;
    }

    public int getNumberProduct() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        if (amount > 0) {
            this.amount = amount;
        }
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void readMenu() {
        System.out.println("1. List all products in shop with product number, name, price, and amount in stock\n"
                + "2. Add new product to the list\n3.Remove product from list by index\n"
                + "4.Update product in list\n5.Exit program");
        System.out.print("Enter your choice:");
    }

    public void addProductToStock() {
        System.out.println("Add new product to list"); 
        System.out.print("product's name:");
        if (number>120) {
            sc.nextLine();
        }
        name = sc.nextLine();
        System.out.print("Input product's price,amount by space/Enter:");
       
        price = sc.nextDouble();
        amount = sc.nextInt();
        Product product = new Product(number, name, price, amount);
        products.add(product);
        System.out.println("Successful added product's name: " + product.getName());
        number += 1;
    }

    public void removeProductByIndex() {
        listAllProduct();
        System.out.print("Remove product by index:");
        int index = sc.nextInt();
        int i = 0;
        int check = 0;
        Iterator<Product> itr = products.iterator();
        while (itr.hasNext()) {
            Product product = itr.next();
            if (i == index) {
                itr.remove();
                System.out.println(product.getName() + " has been removed");
                check = 1;
            }
            i++;
        }
        if (check == 0) {
            System.out.println("there is no " + index + " in product list");
        }
    }

    public void updateProductInListByNumberProduct() {
        listAllProduct();
        int check = 0;
        System.out.print("Input product'number to check:");
        int numberId = sc.nextInt();
        Iterator<Product> itr = products.iterator();

        while (itr.hasNext()) {
            Product product = itr.next();
            if (product.getNumberProduct() == numberId) {
                System.out.print("Enter product's name:");
                String nameProduct;
                sc.nextLine();
                nameProduct = sc.nextLine();
                System.out.print("Enter product's price and amount by space/enter:");
                double priceProduct = sc.nextDouble();
                int amountProduct = sc.nextInt();
                product.setName(nameProduct);
                product.setAmount(amountProduct);
                product.setPrice(priceProduct);
                check = 1;
                System.out.println("Update product'name to " + nameProduct + " product is successfully");
            }
        }
        if (check == 0) {
            System.out.println("there is no number:" + numberId + " in productList");
        }
    }

    public void listAllProduct() {
        System.out.println("\nindex\tnumber\tname\tprice\tamount\n");
        int i = 0;
        for (Product product : products) {
            System.out.println(i + "\t" + product.getNumberProduct() + "\t" + product.getName() + "\t"
                    + product.getPrice() + "\t" + product.getAmount());
            i += 1;
        }
        if (products.isEmpty()) {
            System.out.println("There is no product in stock\n");
        }
    }
}

class ProductInStock {
    public static void main(String[] args) {
        Product products = new Product();
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            products.readMenu();
            choice = Integer.parseInt(sc.nextLine());
            if (choice == 1)
                products.listAllProduct();
            else if (choice == 2)
                products.addProductToStock();
            else if (choice == 3)
                products.removeProductByIndex();
            else if (choice == 4)
                products.updateProductInListByNumberProduct();
            else if (choice == 5) {
                System.out.println("Bye! Bye!");
                break;
            }
        }
    }
}