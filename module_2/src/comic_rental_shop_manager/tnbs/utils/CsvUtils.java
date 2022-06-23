package comic_rental_shop_manager.tnbs.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

    public static <T> void write(String path, List<T> items) {
        try {
            PrintWriter printWriter = new PrintWriter(path);
            for (Object item : items) {
                printWriter.print(item.toString());
                printWriter.println();
            }
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException ex) {
            throw new IllegalArgumentException(path + " invalid");
        }
    }

    public static List<String> read(String path) {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null && !line.trim().isEmpty())
                lines.add(line);
        } catch (IOException e) {
            throw new IllegalArgumentException(path + " invalid");
        }
        return lines;
    }
//     try {
//        return Files.readAllLines(Paths.get(path));
//    } catch (IOException e) {
//        throw new IllegalArgumentException(path + "invalid");
//    }
}
