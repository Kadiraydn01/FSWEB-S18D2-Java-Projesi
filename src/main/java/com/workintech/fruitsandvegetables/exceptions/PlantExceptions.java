package com.workintech.fruitsandvegetables.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class PlantExceptions  extends RuntimeException{
    private HttpStatus status;

    public PlantExceptions(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
