package com.crud.comidas.exceptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.crud.comidas.dto.ApiResponse;

@RestControllerAdvice //Es global para todos los controllers, Devuelve JSON y Maneja excepciones y no endpoints
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)// si aparece una ResourceNotFound Exception, la maneja con este método 
    // spring detecta la excepción, le busca un handler, y si lo encuentra lo ejecuta
    public ResponseEntity<ApiResponse<Void>> handleNotFound(ResourceNotFoundException exception){
        ApiResponse<Void> response = new ApiResponse<>(
            HttpStatus.NOT_FOUND.value(), // para que no sea número mágico
            exception.getMessage(),
            null
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        // return ResponseEntity.notFound().body(response);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<Void>> handleBadRequest(BadRequestException exception){
        ApiResponse<Void> response = new ApiResponse<Void>(
            HttpStatus.BAD_REQUEST.value(),
            exception.getMessage(),
            null
        );

        return ResponseEntity.badRequest().body(response);

    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponse<Void>> handleTypeMismatch(MethodArgumentTypeMismatchException exception) {
        
        String mensaje;

        if (exception.getRequiredType().isEnum()) {
            mensaje = "Valor inválido. Valores permitidos: " +
                    Arrays.toString(exception.getRequiredType().getEnumConstants());
        } else {
            mensaje = "Parámetro inválido: " + exception.getName();
        }

        ApiResponse<Void> response = new ApiResponse<>(
            HttpStatus.BAD_REQUEST.value(),
            mensaje,
            null
        );


        return ResponseEntity.badRequest().body(response);
    }
                      
    @ExceptionHandler(MethodArgumentNotValidException.class) //Excepción que tira spring al validar con Bean
    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidation(MethodArgumentNotValidException exception){
        Map<String, String> errors = new HashMap<>();
        
        exception.getBindingResult().getFieldErrors()
                    .forEach(error -> {
                        errors.put(error.getField(),error.getDefaultMessage());
                    });

        return ResponseEntity.badRequest().body(new ApiResponse<Map<String, String>>(HttpStatus.BAD_REQUEST.value(),"datos inválidos:",errors));
        
    }


    @ExceptionHandler(Exception.class) // cualquiera sea la excepcion. Osea, si hay una excepción sin handler específico, entra acá
    public ResponseEntity<ApiResponse<Void>> handleGeneric (Exception exception){
        ApiResponse<Void> response = new ApiResponse<Void>(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Error interno del servidor",
            null
        );

        return ResponseEntity.internalServerError().body(response);

    }

}
