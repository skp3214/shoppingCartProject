package shoppingCartProject;

import java.util.HashMap;
import java.util.Map;

class Cart {
    private Map<Integer, Item> items;

    public Cart() {
        items = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (!items.containsKey(product.getId())) {
            Item newItem = new Item(product, 1);
            items.put(product.getId(), newItem);
        } else {
            Item item = items.get(product.getId());
            item.setQuantity(item.getQuantity() + 1);
        }
    }

    public void removeProduct(Product product) {
        if (items.containsKey(product.getId())) {
            Item item = items.get(product.getId());
            int currentQuantity = item.getQuantity();
            if (currentQuantity == 1) {
                items.remove(product.getId());
            } else {
                item.setQuantity(currentQuantity - 1);
            }
            System.out.println("                       -------------------------------------------");
            System.out.println("                       ID        |Item                |Rs        |");
            System.out.println("                       -------------------------------------------");
            System.out.println("Removed from the Cart: " + product.getDisplayName());
        } else {
            System.out.println("Product not found in the Cart");
        }
    }

    public int getTotal() {
        int total = 0;
        for (Item item : items.values()) {
            total += item.getPrice();
        }
        return total;
    }

    public String viewCart() {
        if (items.isEmpty()) {
            return "Cart is empty";
        }

        StringBuilder itemizedList = new StringBuilder();
        int cartTotal = getTotal();
        for (Item item : items.values()) {
            itemizedList.append(item.getItemInfo());
        }

        return itemizedList.toString() + "\nTotal Amount: Rs. " + cartTotal + "\n";
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
