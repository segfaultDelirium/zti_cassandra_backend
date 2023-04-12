package com.example.connecttocassandra3.modules.domains_and_areas;

import com.example.connecttocassandra3.helper_functions.DatabaseTableNames;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Area {
    private final String displayedName;
    private final DatabaseTableNames databaseTableName;

    Area(String displayedName, DatabaseTableNames databaseTableName){
        this.displayedName = displayedName;
        this.databaseTableName = databaseTableName;
    }

    @JsonProperty("displayedName")
    public String getDisplayedName() {
        return displayedName;
    }

    @JsonProperty("databaseTableName")
    public String getDatabaseTableName() {
        return databaseTableName.name();
    }

}
