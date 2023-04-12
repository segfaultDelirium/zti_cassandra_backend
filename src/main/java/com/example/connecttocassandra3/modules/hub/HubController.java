package com.example.connecttocassandra3.modules.hub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hub")

public class HubController {

    private final HubService hubService;

    @Autowired
    HubController(HubService hubService){
        this.hubService = hubService;
    }

    @GetMapping
    public List<Hub> getAllHubs() {
        return this.hubService.getAllHubs();
    }

}
