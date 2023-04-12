package com.example.connecttocassandra3.modules.location;

import com.datastax.oss.driver.api.core.cql.Row;
import com.example.connecttocassandra3.helper_functions.DatabaseKeyspaceNames;
import com.example.connecttocassandra3.helper_functions.DatabaseTableNames;
import com.example.connecttocassandra3.helper_functions.HelperFunctions;
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
public class LocationRepository {

    private final Function<Row, Function<LocationColumnNames, Map<Instant, String>>> getTimestampMapFromRow = HelperFunctions.getInstance().getTimestampMapFromRow;

    public List<Location> getAllLocations() {
        String query = "select * from " + DatabaseKeyspaceNames.rinseexhaust.name() + "." + DatabaseTableNames.location.name() + ";";

        return HelperFunctions.executeQuery(query, mapRowToLocation);
    }

    private final Function<Row, Location> mapRowToLocation = row -> {
        Location location = new Location();

        var getTimeStampMapFromEnum = getTimestampMapFromRow.apply(row);

        location.locationId = row.getString(LocationColumnNames.location_id.name());
        location.addressId = getTimeStampMapFromEnum.apply(LocationColumnNames.address_id);
        location.streetAddress = getTimeStampMapFromEnum.apply(LocationColumnNames.street_address);
        location.city = getTimeStampMapFromEnum.apply(LocationColumnNames.city);
        location.zipcode = getTimeStampMapFromEnum.apply(LocationColumnNames.zipcode);
        location.state = getTimeStampMapFromEnum.apply(LocationColumnNames.state);
        location.countryCode = getTimeStampMapFromEnum.apply(LocationColumnNames.country_code);
        location.activity = getTimeStampMapFromEnum.apply(LocationColumnNames.activity);
        location.companyName = getTimeStampMapFromEnum.apply(LocationColumnNames.company_name);
        location.productGroup = getTimeStampMapFromEnum.apply(LocationColumnNames.product_group);

        return location;
    };
}
