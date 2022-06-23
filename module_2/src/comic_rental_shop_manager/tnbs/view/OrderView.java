package comic_rental_shop_manager.tnbs.view;

import comic_rental_shop_manager.tnbs.model.Manga;
import comic_rental_shop_manager.tnbs.model.Order;
import comic_rental_shop_manager.tnbs.model.OrderItem;
import comic_rental_shop_manager.tnbs.services.MangaService;
import comic_rental_shop_manager.tnbs.services.OrderItemService;
import comic_rental_shop_manager.tnbs.services.OrderService;
import comic_rental_shop_manager.tnbs.utils.AppUtils;
import comic_rental_shop_manager.tnbs.utils.ValidateUtils;

import java.util.List;
import java.util.Scanner;

public class OrderView {
    private   final MangaService mangaService = new MangaService();
    private   final OrderService oderService = new OrderService();
    private   final OrderItemService oderItemService = new OrderItemService();
    private   final Scanner sc = new Scanner(System.in);

    public OrderItem addOrderItems(long orderId) {
        do {
            try {
                oderItemService.findAll();
                MangaView mangaView = new MangaView();
                mangaView.showManga();
                long id = System.currentTimeMillis() / 1000;
                System.out.println("Enter Id Manga: ");
                System.out.print("✈✈: ");
                int mangaId = Integer.parseInt(sc.nextLine());
                while (!mangaService.existById(mangaId)) {
                    System.out.println("IdManga Not Exist! Please Retype.");
                    System.out.print("✈✈: ");
                    mangaId = Integer.parseInt(sc.nextLine());
                }
                Manga manga = mangaService.findById(mangaId);
                double price = manga.getPrice();
                int oldQuantity = manga.getQuantity();
                System.out.println("Enter Quantity: ");
                System.out.print("✈✈: ");
                int quantity = Integer.parseInt(sc.nextLine());
                while (!checkQuantityManga(manga, quantity)) {
                    System.out.println("Too Amount! Please Retype.");
                    System.out.print("✈✈: ");
                    quantity = Integer.parseInt(sc.nextLine());
                }
                String nameManga = manga.getTitle();
                double total = quantity * price;
                int currentQuantity = oldQuantity - quantity;
                manga.setQuantity(currentQuantity);
                OrderItem orderItem = new OrderItem(id,price,quantity,orderId,mangaId,nameManga,total);
                mangaService.update(manga);
                return orderItem;
            } catch (Exception ex) {
                System.out.println("Choice Wrong! Please Retype.");
            }
        } while (true);
    }

    public boolean checkQuantityManga(Manga manga, int quantity) {
        if (quantity <= manga.getQuantity())
            return true;
        else
            return false;
    }

    public void addOrder() {
        try {
            oderService.findAll();
            long orderId = System.currentTimeMillis() % 1000;
            System.out.println("❥ Enter UserName: ('Not Space, Not Special Characters !' Ex: sinhhanhsome )");
            System.out.print("✈✈ :");
            String fullName = sc.nextLine();
            while (!ValidateUtils.isNameValidate(fullName)) {
                if (fullName.isEmpty()) {
                    System.out.println("� Not Empty ! Please Enter User Name  !");
                    System.out.println("❥ Enter Name Manga: (Ex: sinhdz123 )");
                    System.out.print("✈✈ :");
                    fullName = sc.nextLine();
                } else {
                    System.out.println("� userName " + "'" + fullName + "'" + " Illegal!!");
                    System.out.println("❥ Enter userName: (Ex: sinh123");
                    System.out.print("✈✈ :");
                    fullName = sc.nextLine();
                }
            }
            System.out.println("Enter UserPhone: (Ex: 0763708115)");
            System.out.print("✈✈ :");
            String phoneNumber = sc.nextLine();
            while (!ValidateUtils.isPhoneValid(phoneNumber)) {
                System.out.println("Phone not incorrect! Start with number 0 !");
                System.out.println("Enter UserPhone: (Ex: 0763708115)");
                phoneNumber = sc.nextLine();
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
            OrderItem orderItem = addOrderItems(orderId);
            oderItemService.add(orderItem);
            Order order = new Order(orderId, fullName, phoneNumber, address);
            oderService.add(order);
            System.out.println("tao don thanh cong");
            do {
                System.out.println("Ⓢ Ⓢ Ⓢ Ⓢ Menu Replace MangaⓈ  Ⓢ Ⓢ Ⓢ Ⓢ");
                System.out.println("Ⓢ Ⓢ                                Ⓢ Ⓢ");
                System.out.println("Ⓢ Ⓢ    1. Continue Created Order   Ⓢ Ⓢ");
                System.out.println("Ⓢ Ⓢ    2. Print Bill               Ⓢ Ⓢ");
                System.out.println("Ⓢ Ⓢ    3. Comback                  Ⓢ Ⓢ");
                System.out.println("Ⓢ Ⓢ    0. Exit                     Ⓢ Ⓢ");
                System.out.println("Ⓢ Ⓢ                                Ⓢ Ⓢ");
                System.out.println("Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ Ⓢ");
                System.out.println("Choose Function: ");
                System.out.print("✈✈ ");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice){
                    case 1:
                        addOrder();
                        break;
                    case 2:
                        printBillOrder(orderItem,order);
                        break;
                    case 3:
                        OrderLauncher.runOrder();
                        break;
                    case 0:
                        System.out.println("GoodBye ! See You Again!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Choice Incorrect! Please Retype.");
                }
            }while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printBillOrder(OrderItem orderItem, Order order) {
        System.out.println("\t▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
        System.out.println("\t▮►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►► LIST USER ◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄▮");
        System.out.println("\t▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
        System.out.printf("\t▮%-125s▮\n", "");
        System.out.printf("\t▮  %-16s %-15s %-15s%-15s%-15s%-15s%-15s%-15s▮\n", "ID", "NAME", "PHONE", "ADDRESS", "nameMANGA", "QUANTITY", "PRICE","TOTALprice");
        System.out.println("\t▮▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▮");
        System.out.printf("\t▮%-125s▮\n", "");
        System.out.printf("\t▮  %-16s %-15s %-15s%-15s%-15s%-15s%-15s%-15s▮\n",
                order.getId(),
                order.getFullName(),
                order.getPhoneNumber(),
                order.getAddress(),
                orderItem.getNameManga(),
                orderItem.getQuantity(),
                AppUtils.doubleToVND(orderItem.getPrice()),
                AppUtils.doubleToVND(orderItem.getPriceTotal())
        );
        System.out.println("\t▮▰▰▰▰▰▰ \uD835\uDCE2 ▰▰▰▰▰▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰▰▰▰▰ \uD835\uDCD8 ▰▰▰▰▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰▰▰▰ \uD835\uDCDD ▰▰▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰▰ \uD835\uDCD7 ▰▰▰▰▰▰▮");
    }

    public void showAllOrder() {
        List<Order> orders = oderService.findAll();
        List<OrderItem> orderItems = oderItemService.findAll();
        OrderItem newOrderItem = new OrderItem();
        try{
            double sum =0;
            System.out.println("\t▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
            System.out.println("\t▮►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►► LIST USER ◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄◄▮");
            System.out.println("\t▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
            System.out.printf("\t▮%-125s▮\n", "");
            System.out.printf("\t▮  %-16s %-15s %-15s%-15s%-15s%-15s%-15s%-15s▮\n", "ID", "NAME", "PHONE", "ADDRESS", "nameMANGA", "QUANTITY", "PRICE","TOTALprice");
            System.out.println("\t▮▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▮");
            System.out.printf("\t▮%-125s▮\n", "");
            for (Order order : orders){
                for (OrderItem orderItem:orderItems){
                    if(orderItem.getOrderId() == order.getId()){
                        newOrderItem = orderItem;
                        break;
                    }
                }
                sum += newOrderItem.getPrice()* newOrderItem.getQuantity();
                System.out.printf("\t▮  %-16s %-15s %-15s%-15s%-15s%-15s%-15s%-15s▮\n",
                        order.getId(),
                        order.getFullName(),
                        order.getPhoneNumber(),
                        order.getAddress(),
                        newOrderItem.getNameManga(),
                        newOrderItem.getQuantity(),
                        AppUtils.doubleToVND(newOrderItem.getPrice()),
                        AppUtils.doubleToVND(newOrderItem.getPrice()* newOrderItem.getQuantity())
                );
            }
            System.out.println("\t▮▰▰▰▰▰▰ \uD835\uDCE2 ▰▰▰▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰▰▰ \uD835\uDCD8 ▰▰▰▰▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰▰▰ \uD835\uDCDD ▰▰▰▰▰▰▰▰▰ \uD83D\uDC94 ▰▰▰▰▰▰▰▰▰ \uD835\uDCD7 ▰▰▰▰▰▰▮");
            System.out.println("\n");
            System.out.println("\t▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
            System.out.println("\t▮►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►Total : " + AppUtils.doubleToVND(sum));
            System.out.println("\t▮▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▰▮");
            String choice;
            do {
                System.out.println("Pres 'c' To Comback \t||\t  Press 'e' To Exit" );
                System.out.print("✈✈ :");
                choice = sc.nextLine();
                switch (choice){
                    case "c":
                        OrderLauncher.runOrder();
                        break;
                    case "e" :
                         AppUtils.exit();
                         break;
                    default:
                        System.out.println("Pres Incorrect! Please Press Retype.");
                }

            }while (!choice.equals("e"));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        OrderView orderView = new OrderView();
//        orderView.addOrder();
        orderView.showAllOrder();

    }
}

