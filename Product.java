package shoppingCartProject;

class Product {
    private int id;
    private String name;
    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getDisplayName() {
        String formattedId = String.format("%-10s", id); // Adjust the width as per your requirement
        String formattedName = String.format("%-20s", name); // Adjust the width as per your requirement
        String formattedPrice = String.format("%-10s", price); // Adjust the width as per your requirement

        return formattedId + "|" + formattedName + "|" + formattedPrice + "|\n";
    }


    public int getPrice() {
        return price;

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
