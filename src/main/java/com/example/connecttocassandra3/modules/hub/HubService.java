package com.example.connecttocassandra3.modules.hub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HubService {

    private final HubRepository hubRepository;

    @Autowired
    HubService(HubRepository hubRepository){
        this.hubRepository = hubRepository;
    }

    public List<Hub> getAllHubs() {
        return this.hubRepository.getAllHubs();
    }



}
