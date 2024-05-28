package repository;

import entity.Model;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository {

    public List<Model> findAll();

}
