package repository;

import entity.Station;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository {

    public List<Station> findAll();

    public List<Station> findByAddress(String Address);

    public List<Station> findByStationID(String StationID);

}
