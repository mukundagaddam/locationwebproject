package com.mukund.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mukund.location.entities.Location;
import com.mukund.location.repos.LocationRepository;

@Service
public class LocaitonServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepository locaitonrepository;

	@Override
	public Location savelocation(Location location) {
		// TODO Auto-generated method stub
		return locaitonrepository.save(location);
	}

	@Override
	public Location updatelocation(Location location) {
		return locaitonrepository.save(location);
	}

	@Override
	public void deletelocation(Location location) {
		locaitonrepository.delete(location);

	}

	@Override
	public Location getLocationbyId(int id) {
		// TODO Auto-generated method stub
		return locaitonrepository.findById(id).get();
	}

	public LocationRepository getLocaitonrepository() {
		return locaitonrepository;
	}

	public void setLocaitonrepository(LocationRepository locaitonrepository) {
		this.locaitonrepository = locaitonrepository;
	}

	@Override
	public List<Location> getallLocation() {
		// TODO Auto-generated method stub
		return locaitonrepository.findAll();
	}

}
