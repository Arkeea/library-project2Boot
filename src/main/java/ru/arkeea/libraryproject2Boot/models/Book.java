package ru.arkeea.libraryproject2Boot.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.NonNull;

import java.util.Date;

@Entity
@Table(name = "Book")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "The book title must not be empty")
    @Size(min = 2, max = 100, message = "The book title should be between 2 and 100 characters in length")
    @Column(name = "title")
    @NonNull
    private String title;

    @NotEmpty(message = "The author must not be empty")
    @Size(min = 2, max = 100, message = "The author's name must be between 2 and 100 characters in length")
    @Column(name = "author")
    @NonNull
    private String author;

    @Min(value = 1500, message = "The year must be greater than 1500")
    @Column(name = "year")
    @NonNull
    private int year;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    @Column(name = "taken_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date takenAt;

    @Transient
    private boolean expired;
}
