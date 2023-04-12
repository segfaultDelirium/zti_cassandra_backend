package com.example.connecttocassandra3.helper_functions;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.function.Function;


public class HelperFunctions<T extends Enum<T>>{

    private static HelperFunctions instance;

    private HelperFunctions() {
        // Private constructor to prevent instantiation from outside the class
    }

    public static <T extends Enum<T>> HelperFunctions getInstance() {
        if (instance == null) {
            instance = new HelperFunctions<T>();
        }
        return instance;
    }

    public Function<Row, Function<T, Map<Instant, ?>>> getTimestampMapFromRow =
            row -> columnNameEnum -> (Map<Instant, ?>) row.getObject(columnNameEnum.name());



    public static <T> List<T> executeQuery(String query, Function<Row, T> mapRowToT){
        List<T> listOfMappedObjects = new java.util.ArrayList<>(List.of());
        try (CqlSession session = CqlSession.builder()
                .withKeyspace("rinseexhaust")
                .build()
        ) {
            System.out.println("connected to cassandra database");
            ResultSet results = session.execute(query);
            for (Row row : results) {
                T mappedObject = mapRowToT.apply(row);
                listOfMappedObjects.add(mappedObject);
            }

        } catch (Exception e) {
            System.out.println("connection to cassandra database failed ");
            throw e;
        }
        return listOfMappedObjects;
    }

}