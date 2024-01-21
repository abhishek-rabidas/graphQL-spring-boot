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

    /*
    query {

    getUsers {
        name,
        records {
            id,
            details,
            savedOn
        }
    }

    getRecords {
        details,
        createdBy {
            name
        }
    }
}

Response:
{
    "data": {
        "getUsers": [
            {
                "name": "Abhishek",
                "records": [
                    {
                        "id": "2",
                        "details": "This is a post",
                        "savedOn": "2024-01-21"
                    },
                    {
                        "id": "3",
                        "details": "This is a post",
                        "savedOn": "2024-01-21"
                    }
                ]
            },
            {
                "name": "Abhishek",
                "records": [
                    {
                        "id": "5",
                        "details": "New post",
                        "savedOn": "2024-01-21"
                    }
                ]
            },
            {
                "name": "Abhishek",
                "records": [
                    {
                        "id": "1",
                        "details": "This is a post",
                        "savedOn": "2024-01-21"
                    },
                    {
                        "id": "4",
                        "details": "This is a post",
                        "savedOn": "2024-01-21"
                    }
                ]
            }
        ],
        "getRecords": [
            {
                "details": "This is a post",
                "createdBy": {
                    "name": "Abhishek"
                }
            },
            {
                "details": "This is a post",
                "createdBy": {
                    "name": "Abhishek"
                }
            },
            {
                "details": "This is a post",
                "createdBy": {
                    "name": "Abhishek"
                }
            },
            {
                "details": "This is a post",
                "createdBy": {
                    "name": "Abhishek"
                }
            },
            {
                "details": "New post",
                "createdBy": {
                    "name": "Abhishek"
                }
            }
        ]
    }
}
     */

    @MutationMapping
    public Record saveRecord(@Argument String details, @Argument Integer userId) {
        return service.saveRecord(details, userId);
    }

    @MutationMapping
    public User addUser(@Argument String name, @Argument String address) {
        return service.saveUser(name, address);
    }

    /*
    mutation {
    addUser(name : "Raj", address : "Delhi, India") {
        id
    }
}

Response :
{
    "data": {
        "addUser": {
            "id": "4"
        }
    }
}

mutation {
    saveRecord (details : "Secret information", userId: 4) {
        createdBy {
            id,
            name
        }
    }
}

Response:
{
    "data": {
        "saveRecord": {
            "createdBy": {
                "id": "4",
                "name": "Raj"
            }
        }
    }
}


     */
}
