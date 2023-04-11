package com.example.connecttocassandra3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

@SpringBootApplication
@RestController
public class ConnectToCassandra3Application {

    public static void main(String[] args) {
        SpringApplication.run(ConnectToCassandra3Application.class, args);

    }

    @GetMapping("/")
    public List<String> getLocations(){

        try(CqlSession session = CqlSession.builder()
                .withKeyspace("rinseexhaust")
                .build()
        ){
            System.out.println("connected to cassandra database");
                ResultSet results = session.execute("select * from rinseexhaust.location;");
            for (Row row : results){
                System.out.println(row.getString("location_id"));
            }

        }catch (Exception e){
            System.out.println("connection to cassandra database failed ");
            throw e;
        }
//        return this.locationRepository.findAll();
        return List.of();
    }

}
