package com.example.connecttocassandra3.modules.domains_and_areas;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DomainAndAreas {
    private final String domain;
    private final List<Area> areas;

    DomainAndAreas(String domain, List<Area> areas){
        this.domain = domain;
        this.areas = areas;
    }


    @JsonProperty("domain")
    public String getDomain() {
        return domain;
    }

    @JsonProperty("areas")
    public List<Area> getAreas() {
        return areas;
    }

}
