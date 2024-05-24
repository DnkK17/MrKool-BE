package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import entity.Area;

public interface AreaRepository extends JpaRepository<Area, Integer>,JpaSpecificationExecutor<Area>{
	
	public Area findByAreaID(int areaID);
	
	public List<Area> findAll();
	
	public List<Area> findByAreaNameContainingIgnoreCase(String name);
}
