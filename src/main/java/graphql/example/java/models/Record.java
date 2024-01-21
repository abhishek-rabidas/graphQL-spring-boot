package graphql.example.java.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Record {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "details")
    private String details;

    @Column(name = "savedOn")
    private LocalDate savedOn;

    @ManyToOne
    private User createdBy;
}
