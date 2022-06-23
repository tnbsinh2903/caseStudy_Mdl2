package comic_rental_shop_manager.tnbs.view;

import comic_rental_shop_manager.tnbs.utils.AppUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MangaLauncher {

    public final Scanner sc = new Scanner(System.in);
    private final MangaView mangaView = new MangaView();
    private final MainLauncher mainLauncher = new MainLauncher();

    public void launchManga() {

        do {
            try {
                mangaManager();
                System.out.println("Choice Function: ");
                System.out.print("✈✈ :");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        mangaView.addProduct();
                        break;
                    case 2:
                        mangaView.update();
                        break;
                    case 3:
                        mangaView.removeManga();
                        break;
                    case 4:
                        mangaView.searchManga();
                        break;
                    case 5:
                        mangaView.sortPriceMangaByASC();
                        break;
                    case 6:
                        mangaView.sortPriceMangaByDESC();
                        break;
                    case 7:
                        mangaView.showManga();
                        String option;
                        do {
                            System.out.println("☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘");
                            System.out.println("++         Press 's' ETo EXITS           ++");
                            System.out.println("++         Press 'c' To Combeck          ++");
                            System.out.println("+-----------------------------------------+");
                            System.out.print("✈✈ : ");
                            option = sc.nextLine();
                            switch (option) {
                                case "s":
                                    AppUtils.exit();
                                    break;
                                case "c":
                                    launchManga();
                                    break;
                                default:
                                    System.out.println("Choice Wrong. Please Retype.");
                            }
                        } while (option.equals("o"));
                        break;
                    case 8:
                        mainLauncher.menuOption();
                        break;
                    case 0:
                        System.out.println("GoodBye ! See You Again!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Choice Wrong! Please Retry .");
                        break;
                }
            } catch (InputMismatchException io) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        } while (true);
    }

    public void mangaManager() {
        System.out.println("\t▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
        System.out.println("\t▮►►►►►►►►►►►►►►►►►►►►►►►► Menu Manga ◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄▮");
        System.out.println("\t▮▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▮");
        System.out.println("\t▮                                                           ▮");
        System.out.println("\t▮                1. Add Manga                               ▮");
        System.out.println("\t▮                2. Replace Information Manga               ▮");
        System.out.println("\t▮                3. Remove Manga                            ▮");
        System.out.println("\t▮                4. Find Manga                              ▮");
        System.out.println("\t▮                5. SortACS Manga                           ▮");
        System.out.println("\t▮                6. SortDESC Manga                          ▮");
        System.out.println("\t▮                7. Show List Manga                         ▮");
        System.out.println("\t▮                8. Com Back                                ▮");
        System.out.println("\t▮                0. EXIT                                    ▮");
        System.out.println("\t▮                                                           ▮");
        System.out.println("\t▮▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▱▮");
    }
}
