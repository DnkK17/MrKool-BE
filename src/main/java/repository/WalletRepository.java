package repository;

import entity.Wallet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository {

    public List<Wallet> findAll();

}
