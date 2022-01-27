package first;

public class Products {
    private String product;
    private int count;
    private double price;

    public Products(String product, int count, double price) {
        this.setProduct(product);
        this.setCount(count);
        this.setPrice(price);
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

    public String getInfoProducts() {
        return this.getProduct() + " " + this.getCount() + " " + this.getPrice();
    }
}
