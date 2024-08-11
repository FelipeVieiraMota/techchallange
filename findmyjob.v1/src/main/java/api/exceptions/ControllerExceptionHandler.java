package api.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerExceptionHandler {

    public static final String ARGUMENTO_DE_METODO_INVALIDO = "Argumento de Método Inválido";
    public static final String VIOLACAO_DE_INTEGRIDADE_DE_DADOS = "Violação de Integridade de Dados";
    public static final String REGISTRO_NAO_ENCONTRADO = "Registro não encontrado";
    private final MessageExceptions err = new MessageExceptions();


    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<MessageExceptions> handleDataIntegrityViolation(DataIntegrityViolationException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;

        err.setStatus(status.value());
        err.setError(VIOLACAO_DE_INTEGRIDADE_DE_DADOS);
        err.setMessage(e.getMostSpecificCause().getMessage());

        return ResponseEntity.status(status).body(this.err);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageExceptions> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        err.setStatus(status.value());
        err.setError(ARGUMENTO_DE_METODO_INVALIDO);
        err.setMessage(e.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", ")));

        return ResponseEntity.status(status).body(this.err);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HttpNotFoundException.class)
    public ResponseEntity<MessageExceptions> handleHttpNotFoundException(HttpNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        err.setStatus(status.value());
        err.setError(REGISTRO_NAO_ENCONTRADO);
        err.setMessage(e.getReason());

        return ResponseEntity.status(status).body(this.err);
    }
}
