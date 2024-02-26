package ru.javarush.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javarush.spring.aop.annotation.Authorized;
import ru.javarush.spring.data.dto.RestResponse;
import ru.javarush.spring.service.TaskService;
import ru.javarush.spring.util.mapper.TaskMapper;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
public class TaskController {

    private final TaskMapper taskMapper;
    private final TaskService taskService;

    @GetMapping("/find")
    @Authorized
    @ResponseStatus(HttpStatus.OK)
    public RestResponse findAll() {
        return new RestResponse(taskMapper.toDto(taskService.findAll()));
    }

    @GetMapping("/find/{id}")
    @Authorized
    @ResponseStatus(HttpStatus.OK)
    public RestResponse findById(@PathVariable String id) {
        return new RestResponse(taskMapper.toDto(taskService.findById(id)));
    }

    @PostMapping("/create")
    @Authorized
    @ResponseStatus(HttpStatus.OK)
    public RestResponse create() {
        return new RestResponse(null);
    }

    @PutMapping("/update/{id}")
    @Authorized
    @ResponseStatus(HttpStatus.OK)
    public RestResponse update() {
        return new RestResponse(null);
    }


    @DeleteMapping("/delete/{id}")
    @Authorized
    @ResponseStatus(HttpStatus.OK)
    public RestResponse delete() {
        return new RestResponse("Task delete");
    }

    /**Template*/

//    @GetMapping("/table")
//    public String showTable() {
//        return "task-table";
//    }

}
