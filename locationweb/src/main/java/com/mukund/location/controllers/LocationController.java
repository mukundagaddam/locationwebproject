package com.mukund.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mukund.location.entities.Location;
import com.mukund.location.repos.LocationRepository;
import com.mukund.location.service.LocationService;
import com.mukund.location.util.EmailUtil;
import com.mukund.location.util.ReportUtil;

@Controller
public class LocationController {
	@Autowired
	LocationService service;
	
	@Autowired
	LocationRepository locationrepository;
	
	@Autowired
	ReportUtil reportutil;
	
	@Autowired
	EmailUtil emailutil;
	
	@Autowired
	ServletContext sc;
	
	
	@RequestMapping("/showCreate")
	public String showcreate() {
		return "createLocation";
	}
	
	@RequestMapping("/saveloc")
	public String saveLocation(@ModelAttribute("location") Location location,ModelMap modelmap) {
		
		Location savelocation = service.savelocation(location);
		String msg = "location saved successfully with id : " + savelocation.getId();
		modelmap.addAttribute("msg",msg);
		emailutil.sendEmail("springgaddam@gmail.com", "New Locaton Loaded", "New location loaded");
		return "createLocation";
	}
	
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelmap) {
		List<Location> locations = service.getallLocation();
		modelmap.addAttribute("locations", locations);
		
		return "displayLocations";
	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id")int Id,ModelMap modelmap) {
	    service.deletelocation(service.getLocationbyId(Id));
		modelmap.addAttribute("msg", "location"+Id+"got deleted successfully");
		List<Location> getallLocation = service.getallLocation();
		modelmap.addAttribute("locations", getallLocation);
		
		return "displayLocations";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id")int Id,ModelMap modelmap) {
	    Location location = service.getLocationbyId(Id);
		//modelmap.addAttribute("msg", "location"+Id+"  got update successfully");
		modelmap.addAttribute("location", location);
		return "editLocation";
	}
	
	@RequestMapping("/updateloc")
	public String updateLocation(@ModelAttribute("location") Location location,ModelMap modelmap) {
		
		Location savelocation = service.updatelocation(location);
		String msg = "location updated successfully for id : " + savelocation.getId();
		modelmap.addAttribute("msg",msg);
		List<Location> getallLocation = service.getallLocation();
		modelmap.addAttribute("locations", getallLocation);
		return "displayLocations";
	}
	
	@RequestMapping("/generateReport")
	public String generateReport() {
		
		String path = sc.getRealPath("/");
		List<Object[]> findTypeAndTypeCount = locationrepository.findTypeAndTypeCount();
		reportutil.generatePieChart(path, findTypeAndTypeCount);
		return "report";
		
	}
	

}
