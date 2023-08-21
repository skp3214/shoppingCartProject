package shoppingCartProject;

class Item {
    private Product product;
    private int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int getPrice() {
        return quantity * product.getPrice();
    }

    public String getItemInfo() {
        String formattedId = String.format("%-10s", product.getId()); // Adjust the width as per your requirement
        String formattedQuantity = String.format("%-10s", quantity); // Adjust the width as per your requirement
        String formattedName = String.format("%-20s", product.getName()); // Adjust the width as per your requirement
        String formattedTotalPrice = String.format("%-10s", (quantity * product.getPrice())); // Adjust the width as per
                                                                                              // your requirement

        return formattedId + "|" + formattedQuantity + "|" + formattedName + "|" + formattedTotalPrice + "|" + "\n";
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int i) {
        this.quantity = i;
    }
}