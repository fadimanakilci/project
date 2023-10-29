package com.reinforcement.project.services.concretes;

import com.reinforcement.project.core.utilities.mappers.ModelMapperService;
import com.reinforcement.project.dataAccess.abstracts.ModelRepository;
import com.reinforcement.project.entities.concretes.Model;
import com.reinforcement.project.services.abstracts.ModelService;
import com.reinforcement.project.services.dtos.requests.CreateModelRequest;
import com.reinforcement.project.services.dtos.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ModelServiceImpl implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelsResponse> modelsResponses = models.stream()
                .map(model -> this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class))
                .collect(Collectors.toList());
        return modelsResponses;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);
    }
}
