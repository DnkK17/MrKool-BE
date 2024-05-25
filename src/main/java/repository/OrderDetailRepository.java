package repository;

import entity.OrderDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository {

    public List<OrderDetail> findAll();

}
