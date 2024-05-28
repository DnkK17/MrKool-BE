//package controller;
//
//import entity.Area;
//import entity.Order;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//import service.OrderService;
//
//import java.util.List;
//
//
//@RestController
//
//public class OrderController {
//    @Autowired
//    private OrderService OrderService;
//
//    @GetMapping("/order")
//    public ResponseEntity<List<Order>> retrieveAllOrder(){
//        return ResponseEntity.ok(OrderService.findAll());
//    }
//
//    @GetMapping("/order/{id}")
//    public ResponseEntity<Order> retrieveArea(@PathVariable int id){
//        Order order = OrderService.findById(id);
//        if (order!=null) {
//            return ResponseEntity.status(HttpStatus.OK).body(order);
//        }else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//}
