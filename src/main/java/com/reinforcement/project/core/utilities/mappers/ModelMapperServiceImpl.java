package com.reinforcement.project.core.utilities.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
//@NoArgsConstructor
public class ModelMapperServiceImpl implements ModelMapperService{
    private ModelMapper modelMapper;

    @Override
    public ModelMapper forResponse() {
        // LOOSE: Olanı maple demek
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        // STANDART: Her şeyi maple. Eşlenmeyen değerler varsa hata ver!
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);

        return this.modelMapper;
    }
}
