package com.reinforcement.project.services.abstracts;

import com.reinforcement.project.services.dtos.requests.CreateModelRequest;
import com.reinforcement.project.services.dtos.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}
