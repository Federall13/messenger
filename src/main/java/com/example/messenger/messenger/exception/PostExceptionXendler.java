package com.example.messenger.messenger.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice //класс для обработки ошибок
public class PostExceptionXendler  {
  @ExceptionHandler(value = MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, Object> body = new HashMap<>();
       // body.put("timestamp", new Date());
       // body.put("status", ex.getMessage());

        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, null, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    protected ResponseEntity<Object> resourseNotFoundException(ResourceNotFoundException resourceNotFoundException) {
      return new ResponseEntity<>(resourceNotFoundException.getMessage(), null, HttpStatus.NOT_FOUND);
    }
}
