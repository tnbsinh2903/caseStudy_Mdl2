package comic_rental_shop_manager.tnbs.services;

import comic_rental_shop_manager.tnbs.model.Order;
import comic_rental_shop_manager.tnbs.utils.CsvUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;



public class OrderService implements IOrderService{


    public static final String PATH = "data/order.csv";


    @Override
    public List<Order> findAll() {
        List<Order> orderItems = new ArrayList<>();
        List<String> records = CsvUtils.read(PATH);
        for (String record : records){
            orderItems.add(Order.parse(record));
        }
        return orderItems;
    }

    @Override
    public void add(Order newOrder) {
        List<Order> orders = findAll();
        newOrder.setDateTime(Instant.now());
        orders.add(newOrder);
        CsvUtils.write(PATH,orders);
    }

    @Override
    public void update() {
   List<Order> orders = findAll();
   CsvUtils.write(PATH,orders);
    }

    @Override
    public Order findById(long id) {
        List<Order> orders =findAll();
        for (Order order: orders){
            if (order.getId() == id)
                return order;
        }
        return null;
    }

    @Override
    public List<Order> findByUserId(long id) {
        List<Order> newOrders = new ArrayList<>();
        for (Order order : findAll()){
            if (order.getId()==id)
                newOrders.add(order);
        }
        return newOrders;
    }

    @Override
    public boolean existById(long id) {
        return findById(id)!=null;
    }
}
