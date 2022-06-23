package comic_rental_shop_manager.tnbs.view;

import comic_rental_shop_manager.tnbs.utils.AppUtils;

import java.util.Scanner;

public class UserLaunch {


    private   final Scanner sc = new Scanner(System.in);
    private   final  UserView userView = new UserView();
    private   final MainLauncher mainLauncher = new MainLauncher();

    public void launchUser(){
        userManager();
        System.out.println("Choice Function");
        System.out.print("✈✈: ");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice){
            case 1:
                userView.addUser();
                launchUser();
                break;
            case 2:
                userView.showUser();
                userView.updateUser();
                launchUser();
                break;
            case 3:
                userView.removeUser();
                launchUser();
                break;
            case 4:
                userView.searchNameUser();
                launchUser();
                break;
            case 5:
                userView.sortNameByASC();
                launchUser();
                break;
            case 6:
                userView.showUser();
                    do {
                        try {
                        System.out.println("☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘");
                        System.out.println("++         Press 'e' To Exits            ++");
                        System.out.println("++         Press 'c' To Comback          ++");
                        System.out.println("+-----------------------------------------+");
                        System.out.print("✈✈ ");
                        String option = sc.nextLine();
                        switch (option) {
                            case "e":
                                AppUtils.exit();
                                break;
                            case "c":
                                launchUser();
                                break;
                            default:
                                System.out.println("Choice Wrong. Please Retypee.");
                                break;
                        }
                } catch (Exception e) {
                    System.out.println("Choice Wrong. Please Retype.");
                }
                    } while (true);
            case 7:
                mainLauncher.menuOption();
                break;
            case 0:
                System.out.println("GoodBye ! See You Again!");
                System.exit(0);
                break;
            default:
                System.out.println("Choice Incorrect! Please Retype.");
        }

    }


    public void userManager(){
        System.out.println("\t▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
        System.out.println("\t▮►►►►►►►►►►►►►►►►►►►►►►►► \uD835\uDE50\uD835\uDE4E\uD835\uDE40\uD835\uDE4D \uD835\uDE48\uD835\uDE40\uD835\uDE49\uD835\uDE50 ◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄▮");
        System.out.println("\t▮▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▮");
        System.out.println("\t▮                                                           ▮");
        System.out.println("\t▮                1. Add User                                ▮");
        System.out.println("\t▮                2. Replace User                            ▮");
        System.out.println("\t▮                3. Remove User                             ▮");
        System.out.println("\t▮                4. Find User                               ▮");
        System.out.println("\t▮                5. Sort User                               ▮");
        System.out.println("\t▮                6. Show List User                          ▮");
        System.out.println("\t▮                7. Com Back                                ▮");
        System.out.println("\t▮                0. EXIT                                    ▮");
        System.out.println("\t▮                                                           ▮");
        System.out.println("\t▮▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▮");
    }
}
