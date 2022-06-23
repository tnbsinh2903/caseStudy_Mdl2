package comic_rental_shop_manager.tnbs.model;

public class OrderItem {
    private long id;
    private double price;
    private int quantity;
    private long orderId;
    private long mangaId;
    private String nameManga;
   private double priceTotal;
    public OrderItem(){}

    public OrderItem(long id,  double price, int quantity, long orderId, long mangaId, String nameManga,double priceTotal) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.orderId = orderId;
        this.mangaId = mangaId;
        this.nameManga = nameManga;
    }

    public static OrderItem parse(String record) {
        OrderItem orderItem = new OrderItem();
        String[] fields = record.split(",");
        orderItem.id = Long.parseLong(fields[0]);
        orderItem.price = Double.parseDouble(fields[1]);
        orderItem.quantity = Integer.parseInt(fields[2]);
        orderItem.orderId = Long.parseLong(fields[3]);
        orderItem.mangaId = Integer.parseInt(fields[4]);
        orderItem.nameManga = fields[5];
        return orderItem;
    }

    public double getPriceTotal() {
        return priceTotal = this.price*this.quantity;
    }

    public void setPriceTotal(double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getMangaId() {
        return mangaId;
    }

    public void setMangaId(long mangaId) {
        this.mangaId = mangaId;
    }

    public String getNameManga() {
        return nameManga;
    }

    public void setNameManga(String nameManga) {
        this.nameManga = nameManga;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s",
                id,
                price,
                quantity,
                orderId,
                mangaId,
                nameManga);


    }
}
