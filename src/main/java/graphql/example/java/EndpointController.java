package graphql.example.java;

import graphql.example.java.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
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

    @MutationMapping
    public ResponseEntity<Object> saveRecord(@Argument String details, @Argument Integer userId) {
        return ResponseEntity.ok(service.saveRecord(details, userId));
    }

    @MutationMapping
    public ResponseEntity<User> addUser(@Argument String name, @Argument String address) {
        return ResponseEntity.ok(service.saveUser(name, address));
    }
}
