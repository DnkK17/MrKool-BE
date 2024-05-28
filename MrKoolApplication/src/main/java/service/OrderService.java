//package service;
//
//
//
//import entity.Order;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import repository.OrderRepository;
//
//import java.util.List;
//
//@Service
//public class OrderService {
//
//    @Autowired
//    private OrderRepository orderRepo;
//
//    public List<Order> findAll(){
//        return orderRepo.findAll();
//    }
//
//    public Order findById(int id) {
//        Order order = orderRepo.findByAreaID(id);
//        return order;
//    }
//}
