package com.example.connecttocassandra3.modules.domains_and_areas;

import com.example.connecttocassandra3.helper_functions.DatabaseTableNames;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DomainsAndAreasService {
    public List<DomainAndAreas> getDomainsAndAreas(){
        return List.of(
                new DomainAndAreas(
                        "Location",
                        Arrays.asList(
                                new Area("Location", DatabaseTableNames.location),
                                new Area("Hub of countries", DatabaseTableNames.hub_data)
                        )
                )
        );
    }
}
