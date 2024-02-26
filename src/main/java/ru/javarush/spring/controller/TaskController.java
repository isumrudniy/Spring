package ru.javarush.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.javarush.spring.aop.annotation.Authorized;
import ru.javarush.spring.data.dto.RestResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
public class TaskController {

    @GetMapping
    @Authorized
    @ResponseStatus(HttpStatus.OK)
    public RestResponse findAll() {
        return new RestResponse(null);
    }

    @GetMapping("/{id}")
    @Authorized
    @ResponseStatus(HttpStatus.OK)
    public RestResponse findById() {
        return new RestResponse(null);
    }

    @PostMapping
    @Authorized
    @ResponseStatus(HttpStatus.OK)
    public RestResponse create() {
        return new RestResponse(null);
    }

    @PutMapping("/{id}")
    @Authorized
    @ResponseStatus(HttpStatus.OK)
    public RestResponse update() {
        return new RestResponse(null);
    }


    @DeleteMapping("/{id}")
    @Authorized
    @ResponseStatus(HttpStatus.OK)
    public RestResponse delete() {
        return new RestResponse("Task delete");
    }

}
