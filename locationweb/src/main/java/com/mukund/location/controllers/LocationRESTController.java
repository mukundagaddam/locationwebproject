package com.mukund.location.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mukund.location.entities.Location;
import com.mukund.location.repos.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {

	@Autowired
	LocationRepository rep;

	@GetMapping
	public List<Location> getalllocations() {

		return rep.findAll();

	}

	@PostMapping
	public Location createLocation(@RequestBody Location location) {
		return rep.save(location);
	}

	@PutMapping
	public Location updateLocation(@RequestBody Location location) {
		return rep.save(location);
	}

	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") int id) {
		rep.deleteById(id);
	}

	@GetMapping("/{id}")
	public Location getLocationById(@PathVariable("id") int id) {
		try {
			return rep.findById(id).get();
		} catch (NoSuchElementException e) {
			return new Location();
		}	
		
	}
}
