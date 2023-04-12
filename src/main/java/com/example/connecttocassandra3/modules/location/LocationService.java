package com.example.connecttocassandra3.modules.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    LocationService(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    public List<Location> getAllLocations(){
        return this.locationRepository.getAllLocations();
    }

}
