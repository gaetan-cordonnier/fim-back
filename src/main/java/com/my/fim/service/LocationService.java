package com.my.fim.service;

import com.my.fim.dto.LocationDto;

import java.util.List;

public interface LocationService {

    LocationDto createLocation(LocationDto locationDto);

    List<LocationDto> getAllLocation();

    LocationDto getLocationById(Long id);

    LocationDto updateLocationById(LocationDto locationDto, Long id);

    void deleteLocationById(Long id);
}
