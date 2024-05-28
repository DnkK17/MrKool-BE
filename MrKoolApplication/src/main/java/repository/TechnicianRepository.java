package repository;

import entity.Technician;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicianRepository {

    public List<Technician> findAll();

    public List<Technician> findByStationID(String StationID);

    public List<Technician> findByTechnicianID(String TechnicianID);
}
