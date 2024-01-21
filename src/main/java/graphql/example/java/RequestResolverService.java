package graphql.example.java;

import graphql.example.java.models.Record;
import graphql.example.java.models.RecordRepository;
import graphql.example.java.models.User;
import graphql.example.java.models.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public Record saveRecord(String details, Integer userId) {
        User user = userRepository.findById(userId).get();

        if (user == null)  {
            throw new RuntimeException("Record can't be saved, because user not found");
        }

        Record record = new Record();
        record.setDetails(details);
        record.setSavedOn(LocalDate.now());
        record.setCreatedBy(user);
        recordRepository.save(record);

        user.getRecords().add(record);
        userRepository.save(user);

        return record;
    }

    public User saveUser(String name, String address) {
        User user = new User();
        user.setName(name);
        user.setAddress(address);
        return userRepository.save(user);
    }
}
