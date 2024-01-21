package graphql.example.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class EndpointController {

    @Autowired
    private RequestResolverService service;

    @QueryMapping
    public ResponseEntity<Object> getRecords() {
        return ResponseEntity.ok(service.getRecords());
    }

    @QueryMapping
    public ResponseEntity<Object> getUsers() {
        return ResponseEntity.ok(service.getUsers());
    }
}
