package comic_rental_shop_manager.tnbs.view;

import comic_rental_shop_manager.tnbs.model.Manga;
import comic_rental_shop_manager.tnbs.services.MangaService;
import comic_rental_shop_manager.tnbs.utils.AppUtils;
import comic_rental_shop_manager.tnbs.utils.InstantUtils;
import comic_rental_shop_manager.tnbs.utils.ValidateUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MangaView {
    private static final Scanner sc = new Scanner(System.in);
    private static final MangaService mangaService = new MangaService();
    private static final MangaLauncher mangaLauncher = new MangaLauncher();

    public void addProduct() {
        long id = System.currentTimeMillis() % 1000;
        System.out.println(" ID Manga: ");
        System.out.println(" ➤ " + id);
        System.out.println("❥ Enter Name Manga: (Ex: Trần Xinh Đẹp )");
        System.out.print("✈✈ : ");
        String title = sc.nextLine().trim();
        while (!ValidateUtils.isNameValidate(title)) {
            if (title.isEmpty()) {
                System.out.println("� Not Empty ! Please Enter Name Manga !");
                System.out.println("❥ Enter Name Manga: (Ex: Trần Bảo Xinh Đẹp )");
                System.out.print("✈✈ :");
                title = sc.nextLine();
            } else {
                System.out.println("� Name Manga " + "'" + title + "'" + " Illegal!!! " + " First letter must be uppercase!");
                System.out.println("❥ Enter Name Manga: (Ex: Trần Bảo Xinh Đẹp");
                System.out.print("✈✈ :");
                title = sc.nextLine();
            }
        }
        ;
        System.out.println("❥ Enter Category Manga: ");
        System.out.print("✈✈: ");
        String category = sc.nextLine();
        while (!ValidateUtils.isNameValidate(category)) {
            if (category.isEmpty()) {
                System.out.println("� Not Empty ! Please Enter Name Category !");
                System.out.println("❥ Enter Name Category: (Ex: Adventure )");
                System.out.print("✈✈ :");
                category = sc.nextLine();
            } else {
                System.out.println("� Name Category " + "'" + category + "'" + " Illegal!!! " + " First letter must be uppercase!");
                System.out.println("❥ Enter Name Category: (Ex: Adventure");
                System.out.print("✈✈ :");
                category = sc.nextLine();
            }
        }
        ;
        double price = 0;
        do {
            try {
                System.out.println("❥ Enter Price Manga: ");
                System.out.print("✈✈: ");
                price = Double.parseDouble(sc.nextLine());
                while (price <= 0) {
                    System.out.println("Price must be greater than 0 (price > 0)");
                    price = Double.parseDouble(sc.nextLine());
                }
            } catch (Exception e) {
                System.out.println("Wrong price! Retype. ");
            }
        } while (price <= 0);

        int quantity = 0;
        do {
            try {
                System.out.println("❥ Enter Quantity Manga: ");
                System.out.print("✈✈ : ");
                quantity = Integer.parseInt(sc.nextLine());
                while (quantity <= 0) {
                    System.out.println("Quantity must be greater than 0 (quantity > 0)");
                    quantity = Integer.parseInt(sc.nextLine());
                }
            } catch (Exception e) {
                System.out.println("Wrong quantity! Retype. ");
            }
        } while (quantity < 0);
        Manga manga = new Manga(id, title, category, price, quantity);
        mangaService.add(manga);
        System.out.println("ლ Manga Added Successfully !");
        String choice;
        do {
            try {
                System.out.println("☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘");
                System.out.println("++         Press 's' To Thêm Tiếp         ++");
                System.out.println("++         Press 'c' To Combeck          ++");
                System.out.println("+-----------------------------------------+");
                System.out.print("✈✈ : ");
                choice = sc.nextLine();
                switch (choice) {
                    case "s":
                        addProduct();
                        break;
                    case "c":
                        mangaLauncher.launchManga();
                        break;
                    default:
                        System.out.println("Choice Wrong. Please Retype.");
                }
            } catch (Exception e) {
                System.out.println("Choice Wrong. Please Retype.");
            }
        } while (true);
    }

    public void update() {
        showManga();
        System.out.println("Enter IdManga Want Replace !");
        System.out.print("✈✈ :");
        int id = Integer.parseInt(sc.nextLine());
        while (!mangaService.existById(id)) {
            System.out.println("ID Not Exist! Please Retry !");
            id = Integer.parseInt(sc.nextLine());
        }
        for (Manga manga : mangaService.findAll()) {
            if (manga.getId() == id) {
                int choice;
                do {
                    System.out.println("Ⓢ Ⓢ Ⓢ Ⓢ Menu Replace MangaⓈ  Ⓢ Ⓢ Ⓢ Ⓢ");
                    System.out.println("Ⓢ Ⓢ                                Ⓢ Ⓢ");
                    System.out.println("Ⓢ Ⓢ    1. Edit name manga          Ⓢ Ⓢ");
                    System.out.println("Ⓢ Ⓢ    2. Edit category manga      Ⓢ Ⓢ");
                    System.out.println("Ⓢ Ⓢ    3. Edit price manga         Ⓢ Ⓢ");
                    System.out.println("Ⓢ Ⓢ    4. Edit quantity            Ⓢ Ⓢ");
                    System.out.println("Ⓢ Ⓢ    5. Comback Home             Ⓢ Ⓢ");
                    System.out.println("Ⓢ Ⓢ                                Ⓢ Ⓢ");
                    System.out.println("Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ");
                    System.out.println("Choose Function: ");
                    System.out.print("✈✈: ");
                    choice = Integer.parseInt(sc.nextLine());
                    if (choice == 1) {
                        System.out.println("Enter Name Manga New: ");
                        System.out.print("✈✈ : ");
                        String title = sc.nextLine();
                        while (!ValidateUtils.isNameValidate(title)) {
                            if (title.isEmpty()) {
                                System.out.println("� Not Empty ! Please Enter NameNew Manga !");
                                System.out.println("❥ Enter Name Manga: (Ex: Trần Bảo Xinh Đẹp )");
                            } else {
                                System.out.println("� Name Manga " + "'" + title + "'" + " Illegal!!! " + " First letter must be uppercase!");
                                System.out.println("❥ Enter Name Manga: (Ex: Trần Bảo Xinh Đẹp");
                            }
                            System.out.print("✈✈ :");
                            title = sc.nextLine();
                        }
                        manga.setTitle(title);
                        mangaService.update(manga);
                        System.out.println("Chang Title Successful!");
                    }
                    if (choice == 2) {
                        System.out.println("❥ Enter Category New: ");
                        System.out.println("✈✈: ");
                        String category = sc.nextLine();
                        while (!ValidateUtils.isNameValidate(category)) {
                            if (category.isEmpty()) {
                                System.out.println("� Not Empty ! Please Enter Name Category !");
                                System.out.println("❥ Enter Name Category: (Ex: Adventure )");
                                System.out.print("✈✈ :");
                                category = sc.nextLine();
                            } else {
                                System.out.println("� Name Category " + "'" + category + "'" + " Illegal!!! " + " First letter must be uppercase!");
                                System.out.println("❥ Enter Name Category: (Ex: Adventure");
                                System.out.print("✈✈ :");
                                category = sc.nextLine();
                            }
                        }
                        manga.setCategory(category);
                        mangaService.update(manga);
                        System.out.println("Change Category Successful!");
                    }
                    if (choice == 3) {
                        double price = 0;
                        do {
                            try {
                                System.out.println("❥ Enter Price Manga: ");
                                System.out.print("✈✈: ");
                                price = Double.parseDouble(sc.nextLine());
                                while (price <= 0) {
                                    System.out.println("Price must be greater than 0 (price > 0)");
                                    price = Double.parseDouble(sc.nextLine());
                                }
                            } catch (Exception e) {
                                System.out.println("Wrong price! Retype. ");
                            }
                            manga.setPrice(price);
                            mangaService.update(manga);
                            System.out.println("Change Price Successful!");
                        } while (price <= 0);

                    }
                    if (choice == 4) {
                        int quantity = 0;
                        do {
                            try {
                                System.out.println("❥ Enter Quantity Manga: ");
                                System.out.print("✈✈ : ");
                                quantity = Integer.parseInt(sc.nextLine());
                                while (quantity <= 0) {
                                    System.out.println("Quantity must be greater than 0 (quantity > 0)");
                                    quantity = Integer.parseInt(sc.nextLine());
                                }
                            } catch (Exception e) {
                                System.out.println("Wrong quantity! Retype. ");
                            }
                            manga.setQuantity(quantity);
                            mangaService.update(manga);
                            System.out.println("Change Quantity Successful!");
                        } while (quantity < 0);
                    }
                    if (choice == 5) {
                        mangaLauncher.launchManga();
                        break;
                    }
                } while (choice != -1);
            }
        }
    }


    public void removeManga() {
        showManga();
        try {
            System.out.println("Enter Id You Want Remove: ");
            System.out.print("✈✈: ");
            int id = Integer.parseInt(sc.nextLine());
            while (!mangaService.existById(id)) {
                System.out.println("ID Not Exist! Please Retry !");
                id = Integer.parseInt(sc.nextLine());
            }
            mangaService.removeById(id);
            System.out.println("Delete ID: " + id + " Successful !");
            System.out.println();
            String choice;
            do {
                System.out.println("☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘");
                System.out.println("++         Press 's' To Thêm Tiếp         ++");
                System.out.println("++         Press 'c' To Combeck          ++");
                System.out.println("+-----------------------------------------+");
                choice = sc.nextLine();
                switch (choice) {
                    case "s":
                        removeManga();
                        break;
                    case "c":
                        mangaLauncher.mangaManager();
                        break;
                    default:
                        System.out.println("Choice Wrong. Please Retype.");
                }
            } while (choice.equals("o"));
        } catch (Exception e) {
            System.out.println("ID Not Incorrect!");
        }
    }

    public void searchManga() {
        List<Manga> mangaSearch = new ArrayList<>();
        System.out.println("Enter Name Manga Want Find !");
        System.out.print("✈✈: ");
        String name = sc.nextLine();
        while (!mangaService.existByName(name)) {
            System.out.println("name not Exist");
            System.out.println("Enter Name Manga Want Find !");
            System.out.print("✈✈: ");
            name = sc.nextLine();
        }
        for (Manga manga : mangaService.findAll()) {
            if (manga.getTitle().equalsIgnoreCase(name)) {
                mangaSearch.add(manga);
            }
        }
        showMangaSearch(mangaSearch);
        String choice;
        do {
            System.out.println("☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘☘");
            System.out.println("++         Press 's' To Exits         ++");
            System.out.println("++         Press 'c' To Combeck          ++");
            System.out.println("+-----------------------------------------+");
            System.out.print("✈✈ : ");
            choice = sc.nextLine();
            switch (choice) {
                case "s":
                    AppUtils.exit();
                    break;
                case "c":
                    mangaLauncher.mangaManager();
                    break;
                default:
                    System.out.println("Choice Wrong. Please Retype.");
            }
        } while (choice.equals("o"));
    }

    public void showMangaSearch(List<Manga> userList) {
        System.out.println("\t▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
        System.out.println("\t▮►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►► LIST USER ◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄▮");
        System.out.println("\t▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
        System.out.printf("\t▮%-91s▮\n", "");
        System.out.printf("\t▮  %-16s %-15s %-15s%-15s%-15s           ▮\n", "ID", "NAME", "CATEGORY", "PRICE", "QUANTITY");
        System.out.println("\t▮▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▮");
        System.out.printf("\t▮%-91s▮\n", "");
        for (Manga manga : userList) {
            System.out.printf("\t▮  %-16s %-15s %-15s%-15s%-15s                          ▮\n", manga.getId(), manga.getTitle(), manga.getCategory(), AppUtils.doubleToVND(manga.getPrice()), manga.getQuantity());
        }
        System.out.println("\t▮▰▰▰▰ \uD835\uDCE2 ▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰ \uD835\uDCD8 ▰▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰ \uD835\uDCDD ▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰ \uD835\uDCD7 ▰▰▰▰▮");
    }

    public void sortPriceMangaByASC() {
        showMangaSort(mangaService.sortPriceMangaASC());
    }

    public void sortPriceMangaByDESC() {
        showMangaSort(mangaService.sortPriceMangaDESC());
    }

    public void showMangaSort(List<Manga> mangaList) {
        System.out.println("\t▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
        System.out.println("\t▮►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►► \uD835\uDE47\uD835\uDE44\uD835\uDE4E\uD835\uDE4F \uD835\uDE48\uD835\uDE3C\uD835\uDE49\uD835\uDE42\uD835\uDE3C ◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄▮");
        System.out.println("\t▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
        System.out.printf("\t▮%-150s▮\n", "");
        System.out.printf("\t▮  %-16s %-30s %-30s%-30s%-30s          ▮\n", "ID", "Name Manga", "CATEGORY", "PRICE", "QUANTITY");
        System.out.println("\t▮▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▮");
        for (Manga manga : mangaList) {
            System.out.printf("\t▮  %-16s %-30s %-30s%-30s%-30s          ▮\n", manga.getId(), manga.getTitle(), manga.getCategory(), AppUtils.doubleToVND(manga.getPrice()), manga.getQuantity());
//
            System.out.println("\t▮▰▰▰▰▰▰▰▰▰ \uD835\uDCE2 ▰▰▰▰▰▰▰▰▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰▰▰▰▰ \uD835\uDCD8 ▰▰▰▰▰▰▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰▰▰▰▰▰▰ \uD835\uDCDD ▰▰▰▰▰▰▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰▰▰▰ \uD835\uDCD7 ▰▰▰▰▰▰▰▮");

        }
    }

    public void showManga() {
        System.out.println("\t▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
        System.out.println("\t▮►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►► \uD835\uDE47\uD835\uDE44\uD835\uDE4E\uD835\uDE4F \uD835\uDE48\uD835\uDE3C\uD835\uDE49\uD835\uDE42\uD835\uDE3C ◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄▮");
        System.out.println("\t▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
        System.out.printf("\t▮%-150s          ▮\n", "");
        System.out.printf("\t▮  %-16s %-20s %-20s%-20s%-20s%-30s%-30s▮\n", "ID", "Name Manga", "CATEGORY", "PRICE", "QUANTITY", "CreatedAt", "update");
        System.out.println("\t▮▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▮");
//        System.out.printf("\t▮%-150s▮\n", "");
        for (Manga manga : mangaService.findAll()) {
            System.out.printf("\t▮  %-16s %-20s %-20s%-20s%-20s%-30s%-30s▮\n", manga.getId(), manga.getTitle(), manga.getCategory(), AppUtils.doubleToVND(manga.getPrice()), manga.getQuantity(), InstantUtils.instanToString(manga.getCreatedAt()), manga.getUpdatedAt() == null ? "" : InstantUtils.instanToString(manga.getUpdatedAt()));

        }
        System.out.println("\t▮▰▰▰▰▰▰▰▰▰ \uD835\uDCE2 ▰▰▰▰▰▰▰▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰▰▰▰▰ \uD835\uDCD8 ▰▰▰▰▰▰▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰▰▰▰▰▰▰ \uD835\uDCDD ▰▰▰▰▰▰▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰▰▰▰▰ \uD835\uDCD7 ▰▰▰▰▰▰▰▰▰▰▮");


    }

    public static void main(String[] args) {
        MangaView mangaView = new MangaView();
//        mangaView.addProduct();
//        mangaView.update();
//        mangaView.removeManga();
        mangaView.showManga();
//        mangaView.searchMangaById();
//        mangaView.sortPriceMangaByASC();
//        mangaView.sortPriceMangaByDESC();
//        mangaView.searchManga();

    }


//    public static void main(String[] args) {
//        MangaView mangaView = new MangaView();
//        mangaView.addProduct();
//
//    }
}

