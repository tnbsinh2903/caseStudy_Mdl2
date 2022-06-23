package comic_rental_shop_manager.tnbs.services;

import comic_rental_shop_manager.tnbs.model.OrderItem;

import java.util.List;

public interface IOrderItemService {

    List<OrderItem> findAll();
    void add(OrderItem newOrderItem);
    void update(OrderItem newOrderItem);

    OrderItem getOrderItemById(int id);
}
