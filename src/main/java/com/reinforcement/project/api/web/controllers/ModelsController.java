package com.reinforcement.project.api.web.controllers;

import com.reinforcement.project.services.abstracts.ModelService;
import com.reinforcement.project.services.dtos.requests.CreateModelRequest;
import com.reinforcement.project.services.dtos.responses.GetAllModelsResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/models")
public class ModelsController {
    private ModelService modelService;

    @GetMapping()
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateModelRequest createModelRequest) {
        this.modelService.add(createModelRequest);
    }
}
