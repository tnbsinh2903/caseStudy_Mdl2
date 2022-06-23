package comic_rental_shop_manager.tnbs.model;

import java.time.Instant;

public class Manga {
    private long id;
    private String title;
    private String category;
    private double price;
    private int quantity;
    private Instant createdAt;
    private Instant updatedAt;

    public Manga() {
    }

    ;

    public Manga(long id, String title, String category, double price, int quantity, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Manga(long id, String title, String category, double price, int quantity) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.quantity = quantity;

    }

    public static Manga parse(String record) {
        String[] files = record.split(",");
        long id = Long.parseLong(files[0]);
        String title = files[1];
        String category = files[2];
        double price = Double.parseDouble(files[3]);
        int quantity = Integer.parseInt(files[4]);

        Instant createdAt = Instant.parse(files[5]);
        String temp = files[6];
        Instant updatedAt = null;
        if (temp != null && !temp.equals("null"))
        updatedAt = Instant.parse(temp);
        return new Manga(id, title, category, price, quantity,createdAt,updatedAt  );
    }

//    public Manga(String record){
//        String[] files = record.split(",");
//        this.id = Long.parseLong(files[0]);
//        this.title = files[1];
//        this.category = files[2];
//        this.price = Double.parseDouble(files[3]);
//        this.quantity = Integer.parseInt(files[4]);
//    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                id,
                title,
                category,
                price,
                quantity,
                createdAt,
                updatedAt);
    }
}
