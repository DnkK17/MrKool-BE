package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import entity.Area;
import service.AreaService;

@RestController
public class AreaController {
	@Autowired
	private AreaService areaService;
	
	@GetMapping("/areas")
	public ResponseEntity<List<Area>> retrieveAllArea(){
		return ResponseEntity.ok(areaService.findAll());
	}
	
	@GetMapping("/area/{id}")
	public ResponseEntity<Area> retrieveArea(@PathVariable int id){
		Area area = areaService.findById(id);
		if (area!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(area);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/areas/{keyword}")
	public ResponseEntity<List<Area>> retrieveArea(@PathVariable String keyword){
		List<Area> areaList = areaService.findByName(keyword);
		return ResponseEntity.ok(areaList);
	}
}
