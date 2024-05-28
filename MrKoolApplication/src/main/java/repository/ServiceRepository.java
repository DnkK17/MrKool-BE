package repository;

import entity.Service;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository {

    public List<Service> findAll();

}
