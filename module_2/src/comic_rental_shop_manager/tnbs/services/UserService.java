package comic_rental_shop_manager.tnbs.services;

import comic_rental_shop_manager.tnbs.model.Role;
import comic_rental_shop_manager.tnbs.model.User;
import comic_rental_shop_manager.tnbs.utils.CsvUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class UserService implements IUserService {

//    private final ArrayList<User> listUser = new ArrayList<>();

    public final   String PATH = "data/user.csv";

    private static UserService instance;


    public UserService() {
    }

    public static UserService getInstance() {
        if (instance == null)
            instance = new UserService();
        return instance;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        List<String> records = CsvUtils.read(PATH);
        for (String record : records) {
            users.add(User.parseUser(record));
        }
        return users;
    }

    @Override
    public User adminLogin(String username, String password) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)
                    && user.getRole().equals(Role.ADMIN)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void add(User newUser) {
        List<User> users = findAll();
        newUser.setCreatedAt(Instant.now());
        users.add(newUser);
        CsvUtils.write(PATH, users);
    }

    @Override
    public void update(User newUser) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getId().equals(newUser.getId())) {
                String fullName = newUser.getFullName();
                if (fullName != null && !fullName.isEmpty())
                    user.setFullName(fullName);
                String phone = newUser.getPhoneNumber();
                if (phone != null && !phone.isEmpty())
                    user.setPhoneNumber(newUser.getPhoneNumber());
                String address = newUser.getAddress();
                if (address != null && !address.isEmpty())
                    user.setAddress(newUser.getAddress());
                user.setUpdatedAt(Instant.now());
                CsvUtils.write(PATH, users);
                break;
            }
        }
    }

    @Override
    public boolean existById(int id) {
        return findById(id) != null;
    }

    @Override
    public boolean existsByPhone(String phone) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getPhoneNumber().equals(phone))
                return true;
        }
        return false;
    }

    @Override
    public boolean existsByUsername(String userName) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getUsername().equals(userName))
                return true;
        }
        return false;
    }

    @Override
    public boolean existsByFullName(String fullName) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getFullName().equals(fullName))
                return true;
        }
        return false;
    }

    @Override
    public void removeById(int id) {
        List<User> users = findAll();
        users.removeIf(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.getId() == id;
            }
        });
        CsvUtils.write(PATH, users);
    }

    @Override
    public User findById(int id) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    @Override
    public List<User> sortNameUserByASC() {
        List<User> sortName = new ArrayList<>(findAll());
        sortName.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                String a = o1.getFullName();
                String b = o2.getFullName();
                int c = a.compareTo(b);
                if (c > 0) {
                    return 1;
                } else if (c < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        return sortName;
    }

    @Override
    public List<User> sortNameUSerByDESC() {
        List<User> sortName = new ArrayList<>(findAll());
        sortName.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                String a = o1.getFullName();
                String b = o2.getFullName();
                int c = b.compareTo(a);
                if (c > 0) {
                    return 1;
                } else if (c < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        return sortName;
    }
}
