package comic_rental_shop_manager.tnbs.view;

import comic_rental_shop_manager.tnbs.utils.AppUtils;

import java.util.Scanner;
public class MainLauncher {

    private static final MangaLauncher mangaLauncher = new MangaLauncher();
    private static final  UserLaunch userLaunch = new UserLaunch();

    public final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MainLauncher mainLauncher = new MainLauncher();
        mainLauncher.launch();
        OrderLauncher.runOrder();
    }

    public  void launch(){
//        AdminView adminView = new AdminView();
//        adminView.adminLogin();
//        System.out.println("\n");
        System.out.println("                             ꧁༺༒༻꧂");
        System.out.println();
        System.out.println("\t                   WELLCOM TO COMIC SINH SHOP ");
        menuOption();
    }

    public  void menuOption() {
        int choice = 0;
        mainMenu();
        do {
            try {
                System.out.println("❥ Choose Function: ");
                System.out.print("✈✈ ");
                choice = Integer.parseInt(sc.nextLine());
                switch (choice){
                    case 1:
                        userLaunch.launchUser();
                        break;
                    case 2:
                        mangaLauncher.launchManga();
                        break;
                    case 3:
                        OrderLauncher.runOrder();
                        break;
                    case 0:
                        AppUtils.exit();
                        break;
                }
            }catch (Exception e){
                System.out.println("Choice Wrong!");
            }
        }while (choice != 0);

    }


    public void mainMenu() {
        System.out.println("\t▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
        System.out.println("\t▮►►►►►►►►►►►►►►►►►►►►►►►► \uD835\uDC0C\uD835\uDC1A\uD835\uDC22\uD835\uDC27 \uD835\uDC0C\uD835\uDC1E\uD835\uDC27\uD835\uDC2E ◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄▮");
        System.out.println("\t▮▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▮");
        System.out.println("\t▮                                                           ▮");
        System.out.println("\t▮                1. User Manager                            ▮");
        System.out.println("\t▮                2. Manga Manager                           ▮");
        System.out.println("\t▮                3. Order Manager                           ▮");
        System.out.println("\t▮                0. Exit                                    ▮");
        System.out.println("\t▮                                                           ▮");
        System.out.println("\t▮▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▮");

    }


}
