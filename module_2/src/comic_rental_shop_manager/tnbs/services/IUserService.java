package comic_rental_shop_manager.tnbs.services;

import comic_rental_shop_manager.tnbs.model.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    User adminLogin(String username, String password);

    void add(User newUser);

    void update(User newUser);

    boolean existById(int id);


    boolean existsByPhone(String phone);

    boolean existsByUsername(String userName);
    boolean existsByFullName(String fullName);
    void removeById(int id);

    User findById(int id);

    List<User> sortNameUserByASC();
    List<User> sortNameUSerByDESC();
}
