package com.my.fim.service.impl;

import com.my.fim.dto.OriginDto;
import com.my.fim.exceptions.NotFoundExceptionMessage;
import com.my.fim.model.Origin;
import com.my.fim.repository.OriginRepository;
import com.my.fim.service.OriginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OriginServiceImpl implements OriginService {

    private final OriginRepository originRepository;
    @Override
    public OriginDto createOrigin(OriginDto originDto) {
        Origin origin = new Origin();
        origin.setType(originDto.getType());
        origin.setLocation(originDto.getLocation());
        origin.setAuthor(originDto.getAuthor());

        Origin newOrigin = originRepository.save(origin);

        OriginDto originResponse = new OriginDto();
        originResponse.setId(newOrigin.getId());
        originResponse.setType(newOrigin.getType());
        originResponse.setLocation(newOrigin.getLocation());
        originResponse.setAuthor(newOrigin.getAuthor());
        return  originResponse;
    }
    @Override
    public List<OriginDto> getAllOrigin() {
        List<Origin> origin = originRepository.findAll();
        return origin.stream().map(element -> mapToDto(element)).collect(Collectors.toList());
    }
    @Override
    public OriginDto getOriginById(Long id) {
        Origin origin = originRepository.findById(id).orElseThrow(()->new NotFoundExceptionMessage("Marque non trouvée"));
        return mapToDto(origin);
    }
    @Override
    public OriginDto updateOriginById(OriginDto originDto, Long id) {
        Origin origin = originRepository.findById(id).orElseThrow(()->new NotFoundExceptionMessage("Impossible de mettre à jour la marque"));

        origin.setType(originDto.getType());
        origin.setLocation(originDto.getLocation());
        origin.setAuthor(originDto.getAuthor());

        Origin updateOrigin = originRepository.save(origin);
        return mapToDto(updateOrigin);
    }
    @Override
    public void deleteOriginById(Long id) {
        Origin origin = originRepository.findById(id).orElseThrow(()->new NotFoundExceptionMessage("Impossible de supprimer la marque"));
        originRepository.delete(origin);
    }
    private OriginDto mapToDto(Origin origin) {
        OriginDto originDto = new OriginDto();
        originDto.setType(origin.getType());
        originDto.setLocation(origin.getLocation());
        originDto.setAuthor(origin.getAuthor());
        return originDto;
    }
    private Origin mapToEntity(OriginDto originDto) {
        Origin origin = new Origin();
        origin.setType(originDto.getType());
        origin.setLocation(originDto.getLocation());
        origin.setAuthor(originDto.getAuthor());
        return origin;
    }
}
