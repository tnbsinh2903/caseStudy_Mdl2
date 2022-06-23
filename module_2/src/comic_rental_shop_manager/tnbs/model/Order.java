package comic_rental_shop_manager.tnbs.model;

import java.time.Instant;

public class Order {
    private Long id;

    private String fullName;
    private String phoneNumber;
    private String address;
    private Double priceTotal;
    private Instant dateTime;

    public Order(){};

    public Long getId() {
        return id;
    }

    public Order(Long id, String fullName, String phoneNumber, String address) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;

    }

    public static Order parse(String record) {
        Order order = new Order();
        String[] field = record.split(",");
        order.id = Long.parseLong(field[0]);
        order.fullName = field[1];
        order.phoneNumber = field[2];
        order.address = field[3];
        return order;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public Instant getDateTime() {
        return dateTime;
    }

    public void setDateTime(Instant dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return id + "," + fullName + "," + phoneNumber + "," + address;
    }
}

