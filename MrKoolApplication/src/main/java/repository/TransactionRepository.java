package repository;

import entity.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository {

    public List<Transaction> findAll();

}
