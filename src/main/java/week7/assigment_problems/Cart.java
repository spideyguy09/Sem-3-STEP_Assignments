package week7.assigment_problems;

public class Cart {
    private final String cartId;
    private int[] itemPrices;
    private int itemCount;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.itemPrices = new int[maxItems];
        this.itemCount = 0;
    }

    public void addItem(int price) {
        if (this.itemCount < this.itemPrices.length) {
            this.itemPrices[this.itemCount] = price;
            this.itemCount++;
        }
    }

    public int getTotal() {
        int total = 0;
        for (int i = 0; i < this.itemCount; i++) {
            total += this.itemPrices[i];
        }
        return total;
    }

    public int getItemCount() {
        return this.itemCount;
    }

    public String getCartId() {
        return this.cartId;
    }
}
