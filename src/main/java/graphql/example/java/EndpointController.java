package graphql.example.java;

import graphql.example.java.models.Record;
import graphql.example.java.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EndpointController {

    @Autowired
    private RequestResolverService service;

    @QueryMapping
    public List<Record> getRecords() {
        return service.getRecords();
    }

    @QueryMapping
    public List<User> getUsers() {
        return service.getUsers();
    }

    @MutationMapping
    public Record saveRecord(@Argument String details, @Argument Integer userId) {
        return service.saveRecord(details, userId);
    }

    @MutationMapping
    public User addUser(@Argument String name, @Argument String address) {
        return service.saveUser(name, address);
    }
}
