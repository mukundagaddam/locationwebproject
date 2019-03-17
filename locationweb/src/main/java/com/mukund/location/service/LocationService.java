package com.mukund.location.service;

import java.util.List;

import com.mukund.location.entities.Location;

public interface LocationService {
	
	Location savelocation(Location location);
	Location updatelocation(Location location);
	void deletelocation(Location location);
	Location getLocationbyId(int Id);
	List <Location> getallLocation();
	

}
