package com.example.connecttocassandra3.modules.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/location")

public class LocationController {

    private final LocationService locationService;

    @Autowired
    LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> getAllLocations() {
        return this.locationService.getAllLocations();
    }

}
