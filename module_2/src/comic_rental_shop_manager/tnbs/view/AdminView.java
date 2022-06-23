
package comic_rental_shop_manager.tnbs.view;

import comic_rental_shop_manager.tnbs.services.UserService;
import comic_rental_shop_manager.tnbs.utils.AppUtils;

import java.util.Scanner;

public class AdminView {
    private  final Scanner sc = new Scanner(System.in);
   public  final UserService userService = new UserService();

    public void adminLogin(){
        boolean isRetry;
        do {
            System.out.println("▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
            System.out.println("▮►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►► ＳＩＧＮ ＩＮ ◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄▮");
            System.out.println("▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
            System.out.println();
            System.out.println();
            System.out.println("Enter UserName: ");
            String username = AppUtils.retryString("UserName");
            System.out.println("Enter Password: ");
            String password = AppUtils.retryString("Password");
            if (userService.adminLogin(username, password) == null) {
                System.out.println("Account Not Incorrect!");
                isRetry = isRetry();
            } else {
                System.out.println();
                System.out.println("    \uD835\uDE4E\uD835\uDE50\uD835\uDE3E\uD835\uDE3E\uD835\uDE40\uD835\uDE4E\uD835\uDE4E\uD835\uDE41\uD835\uDE50\uD835\uDE47 \uD835\uDE47\uD835\uDE4A\uD835\uDE42\uD835\uDE44\uD835\uDE49!");
                isRetry = false;
            }
        }while (isRetry);

        }


    private boolean isRetry() {
        do {
            try {
                System.out.println("▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
                System.out.println("▮                                              ▰▮");
                System.out.println("▮         Press 's' To Sign in Lại           ▰▰▮");
                System.out.println("▮         Press 'e' To Exits                   ▰▮");
                System.out.println("▮                                            ▰▰▮");
                System.out.println("▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
                System.out.print("✈✈ ");
                String choice = sc.nextLine();
                switch (choice) {
                    case "s":
                        return true;
                    case "e":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("Choice Incorrect! Please Retype.");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Press Wrong! Please Retype.");
                ex.printStackTrace();
            }
        } while (true);
    }





    public static void main(String[] args) {
        AdminView adminView = new AdminView();
        adminView.adminLogin();
    }
}

