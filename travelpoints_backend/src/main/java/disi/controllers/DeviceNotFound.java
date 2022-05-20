package disi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DeviceNotFound extends RuntimeException {
    public DeviceNotFound(Integer id) {
        super(String.format("Device with id '%d' does not exist.", id));
    }
}