package first;

import java.util.*;

/**
 * Shop basket)))
 * @author kozulin Mikhail
 * @param products - список продуктов
 * @param basket - корзина
 * @param work - продолжение выбора товара в корзину
 * @param choise - продолжаем выбор или нет?
 * @param product - выбор товара
 * @param count - выбор кол-во товара
 */
public class Hello {
    public static void main(String[] args) {
        ArrayList<Products> products = new ArrayList<>();
        ArrayList<Products> basket = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        boolean work = true;
        String choise;
        String product;
        int count;
        double amount = 0;

        products.add(new Products("banana", 100, 15));
        products.add(new Products("apple", 50, 10));
        products.add(new Products("misha", 1, 1_000_000));

        System.out.println("Products:");

        outputProducts(products);

        while(work){
            System.out.println("Do you want take some vegetables?");
            System.out.println("Yes - Y, No - N");
            choise = in.next();
            if (choise.toUpperCase().equals("Y")) {
                System.out.println("What are you want take?");
                product = in.next();
                System.out.println("How much?");
                count = in.nextInt();
                addProductInBasket(products, basket, product, count);
            }
            else {
                work = false;
            }
        }

        System.out.println("\n" + "Products:");

        outputProducts(products);

        System.out.println("\n" + "Your basket:");

        outputProducts(basket);

        amount = outputAmount(basket, amount);

        System.out.println("Total amount = " + amount);

        work = true;

        while(work){
            System.out.println("Do you want to remove the product from the basket?");
            System.out.println("Yes - Y, No - N");
            choise = in.next();
            if (choise.toUpperCase().equals("Y")) {
                System.out.println("Which product do you want to remove?");
                product = in.next();
                System.out.println("All or how much?");
                System.out.println("All - -1, How much - some number");
                count = in.nextInt();
                if (count == -1)
                    removeAll(basket, product);
                else
                    remove(basket, product, count);
            }
            else {
                work = false;
            }
        }

        outputProducts(basket);

        amount = outputAmount(basket, amount);

        System.out.println("Total amount = " + amount);
    }

    public static void addProductInBasket(ArrayList<Products> products, ArrayList<Products> basket, String product, int count) {
        boolean exists = false;
        for(Products p : products) {
            if (p.getProduct().equals(product.toLowerCase()) && (p.getCount() - count > -1)) {
                p.setCount(p.getCount() - count);
                for(Products cp : basket){
                    if (cp.getProduct().contains(product)) {
                        cp.setCount(cp.getCount() + count);
                        exists = true;
                    }
                }
                if (!exists)
                    basket.add(new Products(p.getProduct(), count, p.getPrice()));
            }
        }
    }

    public static void removeAll(ArrayList<Products> basket, String product) {
        for(Products b: basket) {
            if(b.getProduct().equals(product.toLowerCase())){
                basket.remove(b);
            }
        }
    }

    public static void remove(ArrayList<Products> basket, String product, int count) {
        for(Products b: basket) {
            if(b.getProduct().equals(product.toLowerCase()) && count <= b.getCount()) {
                b.setCount(b.getCount() - count);
            }
        }
    }

    public static void outputProducts(ArrayList<Products> product) {
        for(Products p: product) {
            System.out.println(p.getInfoProducts());
        }
    }

    public static double outputAmount(ArrayList<Products> product, double amount) {
        amount = 0;
        for(Products p: product) {
            amount += (p.getPrice() * p.getCount());
        }
        return amount;
    }
}
