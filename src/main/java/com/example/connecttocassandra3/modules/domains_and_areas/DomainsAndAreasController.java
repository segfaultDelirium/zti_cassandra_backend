package com.example.connecttocassandra3.modules.domains_and_areas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/domains-and-areas")
public class DomainsAndAreasController {



    private final DomainsAndAreasService domainsAndAreasService;

    @Autowired
    DomainsAndAreasController(DomainsAndAreasService domainsAndAreasService){
        this.domainsAndAreasService = domainsAndAreasService;
    }


    @GetMapping
    public List<DomainAndAreas> getAllDomainsAndAreas() {

        return domainsAndAreasService.getDomainsAndAreas();
    }



}
