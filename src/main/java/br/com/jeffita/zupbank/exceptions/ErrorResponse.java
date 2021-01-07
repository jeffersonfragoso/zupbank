package br.com.jeffita.zupbank.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private final String message;
    private final List<String> details;
}
