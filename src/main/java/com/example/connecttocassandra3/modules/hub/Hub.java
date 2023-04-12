package com.example.connecttocassandra3.modules.hub;

import java.time.Instant;
import java.util.List;
import java.util.Map;



public class Hub {
    public String hubCode;

    public Map<Instant, String> hubName;


    public Map<Instant, String> leaderCountry;


    public Map<Instant, List<String>> includedCountries;


    public Map<Instant, List<String>> managementOrganizations;

}
