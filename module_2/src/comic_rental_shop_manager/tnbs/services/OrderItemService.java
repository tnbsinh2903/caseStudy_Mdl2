package comic_rental_shop_manager.tnbs.services;

import comic_rental_shop_manager.tnbs.model.OrderItem;
import comic_rental_shop_manager.tnbs.utils.CsvUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderItemService implements IOrderItemService {

//    private static final ArrayList<OrderItem> orderItemsList = new ArrayList<>();
    public static final String PATH = "data/orderItem.csv";
    @Override
    public List<OrderItem> findAll() {
        List<OrderItem> orderItems = new ArrayList<>();
        List<String> records = CsvUtils.read(PATH);
        for (String record : records){
            orderItems.add(OrderItem.parse(record));
        }
        return orderItems;
    }
    @Override
    public void add(OrderItem newOrderItem) {
        List<OrderItem> orderItems= findAll();
        orderItems.add(newOrderItem);
        CsvUtils.write(PATH,orderItems);
    }

    @Override
    public void update(OrderItem newOrderItem) {
        List<OrderItem> orderItems = findAll();
        CsvUtils.write(PATH,orderItems);
    }

    @Override
    public OrderItem getOrderItemById(int id) {
        List<OrderItem> orderItems = findAll();
        for (OrderItem orderItem : orderItems){
            if (id ==orderItem.getId())
                return orderItem;
        }
        return null;
    }
}
