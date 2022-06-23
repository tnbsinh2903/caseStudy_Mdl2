package comic_rental_shop_manager.tnbs.model;

import java.time.Instant;

public class User {

    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;

    private String address;
    private Role role;
    private Instant createdAt;
    private Instant updatedAt;


    public User(){};

    public User(Long id, String username, String password, String fullName, String phoneNumber, String address, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.role = role;

    }


    public  static User parseUser(String raw) {
        User user = new User();
        String[] fields = raw.split(",");
        user.id = Long.parseLong(fields[0]);
        user.username = fields[1];
        user.password = fields[2];
        user.fullName = fields[3];
        user.phoneNumber = fields[4];
        user.address = fields[5];
        user.role = Role.parseRole(fields[6]);
        user.createdAt = Instant.parse(fields[7]);
        String temp = fields[8];
        if (temp != null && !temp.equals("null"))
            user.updatedAt = Instant.parse(temp);
        return user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
        return String.format("%d,%s,%s,%s,%s,%s,%s,%s,%s",
                id,
                username,
                password,
                fullName,
                phoneNumber,
                address,
                role,
                createdAt,
                updatedAt);
    }
}
