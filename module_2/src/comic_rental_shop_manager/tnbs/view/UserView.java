package comic_rental_shop_manager.tnbs.view;

import comic_rental_shop_manager.tnbs.model.Role;
import comic_rental_shop_manager.tnbs.model.User;
import comic_rental_shop_manager.tnbs.services.UserService;
import comic_rental_shop_manager.tnbs.utils.AppUtils;
import comic_rental_shop_manager.tnbs.utils.InstantUtils;
import comic_rental_shop_manager.tnbs.utils.ValidateUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserView {
//    private final IUserService userService;//Dependency Inversion Principle (SOLID)

    public final static UserService userService = new UserService();
    public static final UserLaunch userLaunch = new UserLaunch();

    private static final Scanner sc = new Scanner(System.in);


    public void addUser() {
        try {
            long id = System.currentTimeMillis() % 1000;
            System.out.println(" ID User: ");
            System.out.println(" ➤ " + id);
            System.out.println("❥ Enter UserName: ('Not Space, Not Special Characters !' Ex: sinhhanhsome )");
            System.out.print("✈✈ :");
            String username = sc.nextLine();
            while (!ValidateUtils.isUserNameValid(username)) {
                if (username.isEmpty()) {
                    System.out.println("� Not Empty ! Please Enter User Name  !");
                    System.out.println("❥ Enter Name Manga: (Ex: sinhdz123 )");
                    System.out.print("✈✈ :");
                    username = sc.nextLine();
                } else {
                    System.out.println("� userName " + "'" + username + "'" + " Illegal!!");
                    System.out.println("❥ Enter userName: (Ex: sinh123");
                    System.out.print("✈✈ :");
                    username = sc.nextLine();
                }
            }
                while (userService.existsByUsername(username)) {
                    System.out.println("� UserName : " + username + " is Exist ! Please Enter userName!");
                    System.out.println("❥ Enter Name : (Ex: sinh123)");
                    System.out.print("✈✈ :");
                    username = sc.nextLine();
                }
            System.out.println("Enter Password: ( Password > 8 character~)");
            System.out.print("✈✈ :");
            String password = sc.nextLine().trim();
            while (!ValidateUtils.isPasswordValid(password)) {
                System.out.println("Weak Password! Please Retype. ");
                System.out.print("✈✈ :");
                password = sc.nextLine().trim();
            }
            System.out.println("❥ Enter FullName User: (Ex: Xinh Dep Trai)");
            System.out.print("✈✈ :");
            String fullName = sc.nextLine().trim();
            while (!ValidateUtils.isNameValidate(fullName)) {
                if (fullName.isEmpty()) {
                    System.out.println("� Not Empty ! Please Enter Name !");
                    System.out.println("❥ Enter FullName: (Ex: Tran Bao Xinh Dep )");
                    System.out.print("✈✈ :");
                    fullName = sc.nextLine();
                } else {
                    System.out.println("� Name " + "'" + fullName + "'" + " Illegal!!! " + " First Letter Must Be Uppercase and Not dấu !");
                    System.out.println("❥ Enter Name : (Ex: Tran Bao Xinh Dep");
                    System.out.print("✈✈ :");
                    fullName = sc.nextLine();
                }
            }
            while (userService.existsByFullName(fullName)) {
                System.out.println("� Name : " + fullName + " is Exist ! Please Enter userName!");
                System.out.println("❥ Enter Name : (Ex: sinh123)");
                System.out.print("✈✈ :");
                fullName = sc.nextLine();
            }
            System.out.println("Enter UserPhone: (Ex: 0763708115)");
            System.out.print("✈✈ :");
            String phone = sc.nextLine();
            while (!ValidateUtils.isPhoneValid(phone)) {
                System.out.println("Phone not incorrect! Start with number 0 !");
                phone = sc.nextLine();
                if (userService.existsByPhone(phone)) {
                    System.out.println("Phone is Exist ! Please Retype.");
                    System.out.print("✈✈ :");
                    phone = sc.nextLine();
                }
            }
            System.out.println("Enter Address (Ex: Hue)");
            System.out.print("✈✈ :");
            String address = sc.nextLine();
            while (!ValidateUtils.isNameValidate(address)) {
                if (address.isEmpty()) {
                    System.out.println("� Not Empty ! Please Enter Address !");
                    System.out.println("❥ Enter Name Manga: (Ex: Hue)");
                    System.out.print("✈✈ :");
                    address = sc.nextLine();
                } else {
                    System.out.println("� Address " + "'" + address + "'" + " Illegal!!! " + " First letter must be uppercase!");
                    System.out.println("❥ Enter Name Manga: (Ex: Hue");
                    System.out.print("✈✈ :");
                    address = sc.nextLine();
                }
            }
            User user = new User(id, username, password, fullName, phone, address, Role.USER);
            setRole(user);
            userService.add(user);
            System.out.println("Plus Successful !");
            String choice;
            do {
                System.out.println("☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘");
                System.out.println("++         Press 's' To Thêm Tiếp         ++");
                System.out.println("++         Press 'c' To Combeck          ++");
                System.out.println("+-----------------------------------------+");
                choice = sc.nextLine();
                switch (choice) {
                    case "s":
                        addUser();
                        break;
                    case "c":
                        userLaunch.launchUser();
                        break;
                    default:
                        System.out.println("Choice Wrong. Please Retype.");
                }

            } while (choice.equals("o"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setRole(User user) {
        System.out.println("✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚");
        System.out.println("✚✚             \uD835\uDC12\uD835\uDC04\uD835\uDC13 \uD835\uDC11\uD835\uDC0E\uD835\uDC0B\uD835\uDC04             ✚✚");
        System.out.println("✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚");
        System.out.println("✚                                   ✚✚");
        System.out.println("✚✚        1. ADMIN                   ✚");
        System.out.println("✚✚        2. USER                   ✚✚");
        System.out.println("✚                                     ✚");
        System.out.println("✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚✚");
        System.out.print("✈✈ :");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                user.setRole(Role.ADMIN);
                break;
            case 2:
                user.setRole(Role.USER);
                break;
            default:

                System.out.println("Incorrect! Please Retype.");
                setRole(user);
        }

    }

    public void updateUser() {
        try {
            System.out.println("Enter Id Want Replace");
            System.out.print("✈✈ :");
            int id = Integer.parseInt(sc.nextLine());
            while (!userService.existById(id)) {
                System.out.println("ID Not Exist! Please Retry !");
                id = Integer.parseInt(sc.nextLine());
            }
            for (User user : userService.findAll()) {
                if (user.getId() == id) {
                    int choice;
                    do {
                        System.out.println("Ⓢ Ⓢ Ⓢ Ⓢ Menu Replace MangaⓈ  Ⓢ Ⓢ Ⓢ Ⓢ");
                        System.out.println("Ⓢ Ⓢ                                Ⓢ Ⓢ");
                        System.out.println("Ⓢ Ⓢ    1. Edit name user           Ⓢ Ⓢ");
                        System.out.println("Ⓢ Ⓢ    2. Edit phoneNumber user    Ⓢ Ⓢ");
                        System.out.println("Ⓢ Ⓢ    3. Edit address user        Ⓢ Ⓢ");
                        System.out.println("Ⓢ Ⓢ    4. Comback                  Ⓢ Ⓢ");
                        System.out.println("Ⓢ Ⓢ    0. Exit                     Ⓢ Ⓢ");
                        System.out.println("Ⓢ Ⓢ                                Ⓢ Ⓢ");
                        System.out.println("Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ");
                        System.out.println("Choose Function: ");
                        System.out.print("✈✈ ");
                        choice = Integer.parseInt(sc.nextLine());
                        if (choice == 1) {
                            System.out.println("Enter Name User New: ");
                            System.out.print("✈✈ ");
                            String name = sc.nextLine();
                            while (!ValidateUtils.isNameValidate(name)) {
                                if (name.isEmpty()) {
                                    System.out.println("� Not Empty ! Please Enter Name !");
                                    System.out.println("❥ Enter FullName: (Ex: Tran Bao Xinh Dep )");
                                    System.out.print("✈✈ :");
                                    name = sc.nextLine();
                                } else {
                                    System.out.println("� Name " + "'" + name + "'" + " Illegal!!! " + " First Letter Must Be Uppercase and Not dấu !");
                                    System.out.println("❥ Enter Name : (Ex: Tran Bao Xinh Dep");
                                    System.out.print("✈✈ :");
                                    name = sc.nextLine();
                                }
                            }
                            user.setFullName(name);
                            userService.update(user);
                            System.out.println("Change Username Successful!");
                        }
                        if (choice == 2) {
                            System.out.println("Enter UserPhone: (Ex: 0763708115)");
                            System.out.print("✈✈ :");
                            String phone = sc.nextLine();
                            while (!ValidateUtils.isPhoneValid(phone)) {
                                if (userService.existsByPhone(phone)) {
                                    System.out.println("Phone is Exist ! Please Retype.");
                                } else {
                                    System.out.println("Phone not incorrect! Start with number 0 !");
                                }
                                System.out.print("✈✈ :");
                                phone = sc.nextLine();
                            }
                            user.setPhoneNumber(phone);
                            userService.update(user);
                            System.out.println("Change PhoneNumber Successful!");
                        }
                        if (choice == 3) {
                            System.out.println("Enter Address (Ex: Hue)");
                            System.out.print("✈✈ :");
                            String address = sc.nextLine();
                            while (!ValidateUtils.isNameValidate(address)) {
                                if (address.isEmpty()) {
                                    System.out.println("� Not Empty ! Please Enter Address !");
                                    System.out.println("❥ Enter Address: (Ex: Hue)");
                                    System.out.print("✈✈ :");
                                    address = sc.nextLine();
                                } else {
                                    System.out.println("� Address " + "'" + address + "'" + " Illegal!!! " + " First letter must be uppercase!");
                                    System.out.println("❥ Enter Name Manga: (Ex: Hue");
                                    System.out.print("✈✈ :");
                                    address = sc.nextLine();
                                }
                            }
                            user.setAddress(address);
                            userService.update(user);
                            System.out.println("Change Address Successful!");
                        }
                        if (choice == 4) {
                            userLaunch.launchUser();
                            break;
                        }
                        if (choice == 0) {
                            AppUtils.exit();
                        }
                    } while (choice != -1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void removeUser() {
        showUser();
        try {
            System.out.println("Enter Id You Want Remove: ");
            System.out.print("✈✈: ");
            int id = Integer.parseInt(sc.nextLine());
            while (!userService.existById(id)) {
                System.out.println("ID Not Exist! Please Retry !");
                id = Integer.parseInt(sc.nextLine());
            }
            userService.removeById(id);
            System.out.println("Delete ID: " + id + " Successful !");
            String choice;
            do {
                System.out.println("☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘");
                System.out.println("++         Press 's' To Xóa Tiếp         ++");
                System.out.println("++         Press 'c' To Combeck          ++");
                System.out.println("+-----------------------------------------+");
                System.out.print("✈✈ ");
                choice = sc.nextLine();
                switch (choice) {
                    case "s":
                        removeUser();
                        break;
                    case "c":
                        userLaunch.launchUser();
                        break;
                    default:
                        System.out.println("Choice Wrong. Please Retype.");
                }

            } while (choice.equals("o"));
        } catch (Exception e) {
            System.out.println("ID Not Incorrect!");
        }
    }

    public void searchNameUser() {
        List<User> userSearch = new ArrayList<>();
        System.out.println("Enter Name User Want Find !");
        System.out.print("✈✈: ");
        String name = sc.nextLine();
        while (!userService.existsByFullName(name)) {
            System.out.println("name not exisst");
            System.out.println("Enter Name User Want Find !");
            System.out.print("✈✈: ");
            name = sc.nextLine();
        }
        for (User user : userService.findAll()) {
            if (user.getFullName().equalsIgnoreCase(name)) {
                userSearch.add(user);
            }
        }
        showUserSearch(userSearch);
    }

    public void showUserSearch(List<User> userList) {
        System.out.println("\t▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
        System.out.println("\t▮►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►► LIST USER ◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄▮");
        System.out.println("\t▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
        System.out.printf("\t▮%-155s▮\n", "");
        System.out.printf("\t▮  %-16s %-15s %-15s%-15s%-15s%-15s%-15s%-20s%-23s  ▮\n", "ID", "USER NAME", "PASSWORD", "FULLNAME", "PHONE", "ADDRESS", "ROLE", "DATECAREAT", "DATEUPDATE");
        System.out.println("\t▮▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▮");
        System.out.printf("\t▮%-155s▮\n", "");
        for (User user : userList) {
            System.out.printf("\t▮  %-16s %-15s %-15s%-15s%-15s%-15s%-15s%-20s%-23s  ▮\n",
                    user.getId(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getFullName(),
                    user.getPhoneNumber(),
                    user.getAddress(),
                    user.getRole(),
                    InstantUtils.instanToString(user.getCreatedAt()),
                    user.getUpdatedAt() == null ? "" : InstantUtils.instanToString(user.getUpdatedAt()));
        }

        System.out.println("\t▮▰▰▰▰▰▰▰▰▰ \uD835\uDCE2 ▰▰▰▰▰▰▰▰▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰▰▰▰▰ \uD835\uDCD8 ▰▰▰▰▰▰▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰▰▰▰▰▰▰ \uD835\uDCDD ▰▰▰▰▰▰▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰▰▰▰ \uD835\uDCD7 ▰▰▰▰▰▰▰▮");
        System.out.println();
        String choice;
        do {
            System.out.println("☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘");
            System.out.println("++         Press 'e' To Exits            ++");
            System.out.println("++         Press 'c' To Comback          ++");
            System.out.println("+-----------------------------------------+");
            System.out.print("✈✈ ");
            choice = sc.nextLine();
            switch (choice) {
                case "s":
                    AppUtils.exit();
                    break;
                case "c":
                    userLaunch.launchUser();
                    break;
                default:
                    System.out.println("Choice Wrong. Please Retype.");
            }

        } while (choice.equals("o"));
    }

    public void sortNameByASC() {
        showUserSort(userService.sortNameUserByASC());
    }

    public void sortNameByDESC() {
        showUserSort(userService.sortNameUSerByDESC());
    }

    public void showUserSort(List<User> userList) {
        System.out.println("\t▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
        System.out.println("\t▮►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►► LIST USER ◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄▮");
        System.out.println("\t▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
        System.out.printf("\t▮%-155s▮\n", "");
        System.out.printf("\t▮  %-16s %-15s %-15s%-15s%-15s%-15s%-15s%-20s%-23s  ▮\n", "ID", "USER NAME", "PASSWORD", "FULLNAME", "PHONE", "ADDRESS", "ROLE", "DATECAREAT", "DATEUPDATE");
        System.out.println("\t▮▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▮");
        System.out.printf("\t▮%-155s▮\n", "");
        for (User user : userList) {
            System.out.printf("\t▮  %-16s %-15s %-15s%-15s%-15s%-15s%-15s%-20s%-23s  ▮\n",
                    user.getId(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getFullName(),
                    user.getPhoneNumber(),
                    user.getAddress(),
                    user.getRole(),
                    InstantUtils.instanToString(user.getCreatedAt()),
                    user.getUpdatedAt() == null ? "" : InstantUtils.instanToString(user.getUpdatedAt()));
        }
        System.out.println("\t▮▰▰▰▰▰▰▰▰▰ \uD835\uDCE2 ▰▰▰▰▰▰▰▰▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰▰▰▰▰ \uD835\uDCD8 ▰▰▰▰▰▰▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰▰▰▰▰▰▰ \uD835\uDCDD ▰▰▰▰▰▰▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰▰▰▰ \uD835\uDCD7 ▰▰▰▰▰▰▰▮");
        System.out.println();
        String choice;
        do {
            System.out.println("☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘");
            System.out.println("++         Press 'e' To Exits            ++");
            System.out.println("++         Press 'c' To Comback          ++");
            System.out.println("+-----------------------------------------+");
            System.out.print("✈✈ ");
            choice = sc.nextLine();
            switch (choice) {
                case "e":
                    AppUtils.exit();
                    break;
                case "c":
                    userLaunch.launchUser();
                    break;
                default:
                    System.out.println("Choice Wrong. Please Retype.");
            }
        } while (choice.equals("o"));
    }

    public void showUser() {
        System.out.println("\t▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
        System.out.println("\t▮►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►► LIST USER ◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄▮");
        System.out.println("\t▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
        System.out.printf("\t▮%-155s▮\n", "");
        System.out.printf("\t▮  %-16s %-15s %-15s%-15s%-15s%-15s%-15s%-20s%-23s  ▮\n", "ID", "USER NAME", "PASSWORD", "FULLNAME", "PHONE", "ADDRESS", "ROLE", "DATECAREAT", "DATEUPDATE");
        System.out.println("\t▮▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▮");
        System.out.printf("\t▮%-155s▮\n", "");
        for (User user : userService.findAll()) {
            System.out.printf("\t▮  %-16s %-15s %-15s%-15s%-15s%-15s%-15s%-20s%-23s  ▮\n",
                    user.getId(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getFullName(),
                    user.getPhoneNumber(),
                    user.getAddress(),
                    user.getRole(),
                    InstantUtils.instanToString(user.getCreatedAt()),
                    user.getUpdatedAt() == null ? "" : InstantUtils.instanToString(user.getUpdatedAt()));
        }

        System.out.println("\t▮▰▰▰▰▰▰▰▰▰ \uD835\uDCE2 ▰▰▰▰▰▰▰▰▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰▰▰▰▰ \uD835\uDCD8 ▰▰▰▰▰▰▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰▰▰▰▰▰▰ \uD835\uDCDD ▰▰▰▰▰▰▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰▰▰▰ \uD835\uDCD7 ▰▰▰▰▰▰▰▮");

    }


    //       System.out.println("☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘6
    public static void main(String[] args) {
        UserView userView = new UserView();
        userView.addUser();
//        System.out.println("----------------------------");
//        userView.updateUser();
//        userView.removeUser();
//        userView.showUser();
//        userView.sortNameByASC();
//        userView.sortNameByDESC();
//        userView.searchNameUser();
    }
}
