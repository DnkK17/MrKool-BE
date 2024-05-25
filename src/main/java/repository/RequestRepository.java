package repository;

import entity.Request;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository {

    public List<Request> findAll();

}
