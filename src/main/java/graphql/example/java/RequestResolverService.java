package graphql.example.java;

import graphql.example.java.models.Record;
import graphql.example.java.models.RecordRepository;
import graphql.example.java.models.User;
import graphql.example.java.models.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestResolverService {

    private final UserRepository userRepository;
    private final RecordRepository recordRepository;


    public RequestResolverService(UserRepository userRepository, RecordRepository recordRepository) {
        this.userRepository = userRepository;
        this.recordRepository = recordRepository;
    }

    public List<Record> getRecords() {
        return recordRepository.findAll();
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
