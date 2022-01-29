package first;

import java.util.*;

public class Hello {
    public static void main(String[] args) {
        ArrayList<Products> products = new ArrayList<>();
        ArrayList<Products> basket = new ArrayList<>();
        ArrayList<Products> newBasket = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        double amount = 0;

        listProducts(products);

        outputProducts(products);

        addProductInBasket(products, chooseProducts(in, basket));

        outputInfo(products, basket);

        remove(basket, chooseProducts(in, newBasket), products);

        outputInfo(products, basket);
    }

    public static void listProducts(ArrayList<Products> products) {
        products.add(new Products("banana", 100, 15));
        products.add(new Products("apple", 50, 10));
        products.add(new Products("pear", 50, 10));
        products.add(new Products("lemon", 50, 10));
        products.add(new Products("melon", 50, 10));
        products.add(new Products("peach", 50, 10));
        products.add(new Products("misha", 1, 1_000_000));
    }

    public static void outputInfo(ArrayList<Products> products, ArrayList<Products> basket) {
        double amount = 0;

        System.out.println("\n" + "Products:");

        outputProducts(products);

        System.out.println("\n" + "Your basket:");

        outputProducts(basket);

        amount = outputAmount(basket);

        System.out.println("Total amount = " + amount);
    }

    public static ArrayList<Products> chooseProducts(Scanner in, ArrayList<Products> basket) {
        boolean work = true;
        String choise;
        String product;
        int count;
        double price = 0;
        while(work){
            System.out.println("Do you want to choose a product?");
            System.out.println("Yes - Y, No - N");
            choise = in.next();
            if (choise.toUpperCase().equals("Y")) {
                System.out.println("What do you want to choose?");
                product = in.next();
                System.out.println("How much?");
                count = in.nextInt();
                basket.add(new Products(product, count, price));
            }
            else {
                work = false;
            }
        }
        return basket;
    }

    public static void addProductInBasket(ArrayList<Products> products, ArrayList<Products> basket) {
        for (Products b : basket) {
            for (Products p : products) {
                if (p.getProduct().equals(b.getProduct().toLowerCase()) && (p.getCount() - b.getCount() >= 0)) {
                    p.setCount(p.getCount() - b.getCount());
                    b.setPrice(p.getPrice());
                    break;
                }
            }
        }
    }

    public static void remove(ArrayList<Products> basket, ArrayList<Products> newBasket, ArrayList<Products> products) {
        for(Products nb : newBasket) {
            for (Products b : basket) {
                if (nb.getProduct().equals(b.getProduct()) && nb.getCount() <= b.getCount()) {
                    for (Products p : products) {
                        if (nb.getProduct().equals(p.getProduct())) {
                            b.setCount(b.getCount() - nb.getCount());
                            p.setCount(p.getCount() + nb.getCount());
                            nb.setPrice(p.getPrice());
                        }
                    }
                }
            }
        }
    }

    public static void outputProducts(ArrayList<Products> product) {
        for(Products p: product) {
            System.out.println(p);
        }
    }

    public static double outputAmount(ArrayList<Products> product) {
        double amount = 0;
        for(Products p: product) {
            amount += (p.getPrice() * p.getCount());
        }
        return amount;
    }
}
