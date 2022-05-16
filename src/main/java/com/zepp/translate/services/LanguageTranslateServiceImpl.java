package com.zepp.translate.services;

import com.zepp.translate.entities.LanguageTranslate;
import com.zepp.translate.entities.dtos.LanguageTranslateDto;
import com.zepp.translate.exceptions.NotFoundException;
import com.zepp.translate.repositories.LanguageTranslateRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LanguageTranslateServiceImpl implements LanguageTranslateService {

    private LanguageTranslateRepository languageTranslateRepository;
    private ModelMapper modelMapper;

    @Autowired
    public LanguageTranslateServiceImpl(LanguageTranslateRepository languageTranslateRepository, ModelMapper modelMapper) {
        this.languageTranslateRepository = languageTranslateRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<LanguageTranslateDto> findAll() {
        List<LanguageTranslate> languageTranslateList = (List<LanguageTranslate>) languageTranslateRepository.findAll();
        return  languageTranslateList.stream().map(languageTranslate -> modelMapper.map(languageTranslate, LanguageTranslateDto.class)).collect(Collectors.toList());
    }

    @Override
    public LanguageTranslateDto saveEntity(LanguageTranslateDto dto) {
        LanguageTranslate languageTranslate = modelMapper.map(dto, LanguageTranslate.class);
        LanguageTranslate createdEntity = languageTranslateRepository.save(languageTranslate);
        LanguageTranslateDto savedEntity = modelMapper.map(createdEntity, LanguageTranslateDto.class);
        return savedEntity;
    }

    @Override
    public LanguageTranslateDto updateEntity(long id, LanguageTranslateDto dto) {
        Optional<LanguageTranslate> foundedEntityOptional = languageTranslateRepository.findById(id);
        if(!foundedEntityOptional.isPresent()) {
            log.error("LanguageTranslate sa id-jem: " + id + " nije pronađen!!!");
            throw new NotFoundException("Nije pronađen LanguageTranslate sa id-jem " + id);
        }
        LanguageTranslate foundEntity = foundedEntityOptional.get();
        foundEntity.setTarget(dto.getTarget());
        foundEntity.setTargetLangName(dto.getTargetLangName());
        LanguageTranslate updatedEntity = languageTranslateRepository.save(foundEntity);
        LanguageTranslateDto updatedDto = modelMapper.map(updatedEntity, LanguageTranslateDto.class);
        return updatedDto;
    }

    @Override
    public LanguageTranslateDto findById(long id) {
        Optional<LanguageTranslate> foundedEntityOptional = languageTranslateRepository.findById(id);
        if(!foundedEntityOptional.isPresent()) {
            log.error("LanguageTranslate sa id-jem: " + id + " nije pronađen!!!");
            throw new NotFoundException("Nije pronađen LanguageTranslate sa id-jem " + id);
        }
        LanguageTranslate foundEntity = foundedEntityOptional.get();
        LanguageTranslateDto foundedDto = modelMapper.map(foundEntity, LanguageTranslateDto.class);
        return foundedDto;
    }

    @Override
    public void delete(long id) {
        log.info("LanguageTranslate sa id-jem: " + id + " je obrisan!!!");
        languageTranslateRepository.deleteById(id);
    }
}
