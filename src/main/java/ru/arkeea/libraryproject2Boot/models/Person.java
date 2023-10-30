package ru.arkeea.libraryproject2Boot.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Person")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "The name must not be empty")
    @Size(min = 2, max = 100, message = "The name must be between 2 and 100 characters in length")
    @Column(name = "full_name")
    @NonNull
    private String fullName;

    @Min(value = 1900, message = "The year of birth must be greater than 1900")
    @Column(name = "year_of_birth")
    @NonNull
    private int yearOfBirth;

    @OneToMany(mappedBy = "owner")
    private List<Book> books;
}
