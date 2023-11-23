package com.my.fim.service.impl;

import com.my.fim.utils.ConstantUtils;
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
        origin.setAuthorFirstname(originDto.getAuthorFirstname());
        origin.setAuthorLastname(originDto.getAuthorLastname());


        Origin newOrigin = originRepository.save(origin);

        OriginDto originResponse = new OriginDto();
        originResponse.setId(newOrigin.getId());
        originResponse.setType(newOrigin.getType());
        originResponse.setLocation(newOrigin.getLocation());
        originResponse.setAuthorFirstname(newOrigin.getAuthorFirstname());
        originResponse.setAuthorLastname(newOrigin.getAuthorLastname());
        return originResponse;
    }

    @Override
    public List<OriginDto> getAllOrigin() {
        List<Origin> origin = originRepository.findAll();
        return origin.stream().map(element -> mapToDto(element)).collect(Collectors.toList());
    }

    @Override
    public OriginDto getOriginById(Long id) {
        Origin origin = originRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.ORIGIN_NOT_FOUND));
        return mapToDto(origin);
    }

    @Override
    public OriginDto updateOriginById(OriginDto originDto, Long id) {
        Origin origin = originRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.ORIGIN_NOT_UPDATED));

        origin.setType(originDto.getType());
        origin.setLocation(originDto.getLocation());
        origin.setAuthorFirstname(originDto.getAuthorFirstname());
        origin.setAuthorLastname(originDto.getAuthorLastname());

        Origin updateOrigin = originRepository.save(origin);
        return mapToDto(updateOrigin);
    }

    @Override
    public void deleteOriginById(Long id) {
        Origin origin = originRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.ORIGIN_NOT_DELETED));
        originRepository.delete(origin);
    }

    private OriginDto mapToDto(Origin origin) {
        OriginDto originDto = new OriginDto();
        originDto.setId(origin.getId());
        originDto.setType(origin.getType());
        originDto.setLocation(origin.getLocation());
        originDto.setAuthorFirstname(origin.getAuthorFirstname());
        originDto.setAuthorLastname(origin.getAuthorLastname());
        return originDto;
    }

    private Origin mapToEntity(OriginDto originDto) {
        Origin origin = new Origin();
        origin.setId(originDto.getId());
        origin.setType(originDto.getType());
        origin.setLocation(originDto.getLocation());
        origin.setAuthorFirstname(originDto.getAuthorFirstname());
        origin.setAuthorLastname(originDto.getAuthorLastname());
        return origin;
    }
}
