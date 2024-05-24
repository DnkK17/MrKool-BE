package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Area;
import repository.AreaRepository;

@Service
public class AreaService {
	@Autowired
	private AreaRepository areaRepo;
	
	public List<Area> findAll(){
		return areaRepo.findAll();
	}
	
	public Area findById(int ID) {
		Area area = areaRepo.findByAreaID(ID);
		return area;
	}
	
	public List<Area> findByName(String name){
		return areaRepo.findByAreaNameContainingIgnoreCase(name);
	}
		
}
