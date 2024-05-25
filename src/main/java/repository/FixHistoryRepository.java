package repository;

import entity.FixHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FixHistoryRepository {
    public List<FixHistory> findAll();

    public List<FixHistory> findByStatus(String status);

    public List<FixHistory> findByTechnicianID(int technicianId);

}
