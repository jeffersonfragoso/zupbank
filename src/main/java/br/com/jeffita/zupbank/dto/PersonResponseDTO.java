package br.com.jeffita.zupbank.dto;

import br.com.jeffita.zupbank.entity.Person;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PersonResponseDTO {

    private Long id;
    private String cpf;
    private String email;
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    public static PersonResponseDTO convertToDTO(Person person){
        return new PersonResponseDTO(
                person.getId(),
                person.getCpf(),
                person.getName(),
                person.getEmail(),
                person.getBirthDate()
        );
    }
}
