package comic_rental_shop_manager.tnbs.utils;

import comic_rental_shop_manager.tnbs.view.InputOption;

import java.text.DecimalFormat;
import java.util.Scanner;

public class AppUtils {
    public static final Scanner sc = new Scanner(System.in);
    public static String doubleToVND(double price){
        String patternVND = ",###đ";
        DecimalFormat decimalFormat = new DecimalFormat(patternVND);
        return decimalFormat.format(price);
    }

    public static String retryString (String filedName){
        String result;
        System.out.print("✈✈: ");
        while ((result = sc.nextLine()).isEmpty()){
            System.out.printf("%s Not Empty !\n", filedName);
            System.out.print("✈✈: ");

        }
       return result;
    }


    public static boolean isRetry(InputOption inputOption) {
        do {
            switch (inputOption) {

                case ADD:
                    System.out.println("Nhấn 'y' để thêm tiếp \t|\t 'q' để quay lại \t|\t 't' để thoát chương trình");
                    break;
                case UPDATE:
                    System.out.println("Nhấn 'y' để sửa tiếp \t|\t 'q' để quay lại\t|\t 't' để thoát chương trình");
                    break;
                case DELETE:
                    System.out.println("Nhấn 'q' để quay lại\t|\t 't' để thoát chương trình");
                    break;
                case SHOW:
                    System.out.println("Nhấn 'q' để trở lại \t|\t 't' để thoát chương trình");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + inputOption);
            }

            System.out.print(" ⭆ ");
            String option = sc.nextLine();
            switch (option) {
                case "y":
                    return true;
                case "q":
                    return false;
                case "t":
                    System.out.println("\tTạm biệt. Hẹn gặp lại!");
                    System.exit(5);
                    break;
                default:
                    System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                    break;
            }
        } while (true);
    }

    public static void exit() {
        System.out.println("\tGoodBye! See You Again.");
        System.exit(0);
    }
}
