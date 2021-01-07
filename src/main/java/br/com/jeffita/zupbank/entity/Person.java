package br.com.jeffita.zupbank.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false, name = "birth_date")
    private LocalDate birthDate;

    public Person(String cpf, String name, String email, LocalDate birthDate) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }
}
