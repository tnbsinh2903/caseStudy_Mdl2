package comic_rental_shop_manager.tnbs.view;

import java.util.Scanner;

public class OrderLauncher {
    public static final MainLauncher mainLauncher = new MainLauncher();

    private static final Scanner sc = new Scanner(System.in);

    OrderLauncher(){
    }

    public static void runOrder() {
        menuOrder();
        OrderView orderView = new OrderView();
        System.out.println("Choice Function: ");
        System.out.print("✈✈ :");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                orderView.addOrder();
                break;
            case 2:
                orderView.showAllOrder();
                break;
            case 3:
                mainLauncher.menuOption();
            default:
                System.out.println("Choice Wrong! Please Retype.");
                runOrder();
        }

    }

    public static void menuOrder() {
        System.out.println("\t▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
        System.out.println("\t▮►►►►►►►►►►►►►►►►►►►►►►► \uD835\uDE4A\uD835\uDE4D\uD835\uDE3F\uD835\uDE40\uD835\uDE4D \uD835\uDE48\uD835\uDE40\uD835\uDE49\uD835\uDE50 ◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄▮");
        System.out.println("\t▮▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▮");
        System.out.println("\t▮                                                           ▮");
        System.out.println("\t▮                1. Created Order                           ▮");
        System.out.println("\t▮                2. Show List Order                         ▮");
        System.out.println("\t▮                3. Com Back                                ▮");
        System.out.println("\t▮                                                           ▮");
        System.out.println("\t▮▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▮");
    }


}
