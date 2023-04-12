package com.example.connecttocassandra3.modules.hub;

import com.datastax.oss.driver.api.core.cql.Row;
import com.example.connecttocassandra3.helper_functions.DatabaseKeyspaceNames;
import com.example.connecttocassandra3.helper_functions.HelperFunctions;
import com.example.connecttocassandra3.helper_functions.DatabaseTableNames;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Repository
@ComponentScan(
        basePackages = {
                "com.example.connecttocassandra3.helper_functions",
        }
)
public class HubRepository {
    private final Function<Row, Function<HubColumnNames, Map<Instant, String>>> getTimestampStringMapFromRow = HelperFunctions.getInstance().getTimestampMapFromRow;
    private final Function<Row, Function<HubColumnNames, Map<Instant, List<String>>>> getTimestampStringListMapFromRow = HelperFunctions.getInstance().getTimestampMapFromRow;

    public List<Hub> getAllHubs() {
        String query = "select * from " + DatabaseKeyspaceNames.rinseexhaust.name() + "." + DatabaseTableNames.hub_data.name() + ";";

        return HelperFunctions.executeQuery(query, mapRowToHub);
    }

    private final Function<Row, Hub> mapRowToHub = row -> {
        Hub hub = new Hub();

        var getTimeStampMapFromEnum = getTimestampStringMapFromRow.apply(row);
        var getTimeStampStringListMapFromEnum = getTimestampStringListMapFromRow.apply(row);

        hub.hubCode = row.getString(HubColumnNames.hub_code.name());
        hub.hubName = getTimeStampMapFromEnum.apply(HubColumnNames.hub_name);
        hub.leaderCountry = getTimeStampMapFromEnum.apply(HubColumnNames.leader_country);
        hub.includedCountries = getTimeStampStringListMapFromEnum.apply(HubColumnNames.included_countries);
        hub.managementOrganizations = getTimeStampStringListMapFromEnum.apply(HubColumnNames.management_organizations);

        return hub;
    };

}
