package repository;

import entity.Order;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository {

   public List<Order> findAll();

    Order findByOrderID(int id);

    public List<Order> findByStatus(String status);

    public List<Order> findByOrderDate(Date date);
}
