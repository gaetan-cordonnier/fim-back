package com.my.fim.service;

import com.my.fim.dto.OriginDto;

import java.util.List;

public interface OriginService {

    OriginDto createOrigin(OriginDto originDto);

    List<OriginDto> getAllOrigin();

    OriginDto getOriginById(Long id);

    OriginDto updateOriginById(OriginDto originDto, Long id);

    void deleteOriginById(Long id);
}
