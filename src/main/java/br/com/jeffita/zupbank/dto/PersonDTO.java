package br.com.jeffita.zupbank.dto;

import br.com.jeffita.zupbank.entity.Person;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
public class PersonDTO {

    @NotBlank(message = "{cpf.not.blank}")
    private String cpf;
    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.not.valid}")
    private String email;
    @NotBlank(message = "{name.not.blank}")
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    public Person convertToObj(){
        return new Person(cpf, name, email, birthDate);
    }
}
