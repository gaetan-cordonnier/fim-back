package com.my.fim.service.impl;

import com.my.fim.utils.ConstantUtils;
import com.my.fim.dto.LocationDto;
import com.my.fim.exceptions.NotFoundExceptionMessage;
import com.my.fim.model.Location;
import com.my.fim.repository.LocationRepository;
import com.my.fim.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Override
    public LocationDto createLocation(LocationDto locationDto) {
        Location location = new Location();
        location.setName(locationDto.getName());

        Location newLocation = locationRepository.save(location);

        LocationDto locationResponse = new LocationDto();
        locationResponse.setId(newLocation.getId());
        locationResponse.setName(newLocation.getName());
        return locationResponse;
    }

    @Override
    public List<LocationDto> getAllLocation() {
        List<Location> location = locationRepository.findAll();
        return location.stream().map(element -> mapToDto(element)).collect(Collectors.toList());
    }

    @Override
    public LocationDto getLocationById(Long id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.LOCATION_NOT_FOUND));
        return mapToDto(location);
    }

    @Override
    public LocationDto updateLocationById(LocationDto locationDto, Long id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.LOCATION_NOT_UPDATED));

        location.setName(locationDto.getName());

        Location updateLocation = locationRepository.save(location);
        return mapToDto(updateLocation);
    }

    @Override
    public void deleteLocationById(Long id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new NotFoundExceptionMessage(ConstantUtils.LOCATION_NOT_DELETED));
        locationRepository.delete(location);
    }

    private LocationDto mapToDto(Location location) {
        LocationDto locationDto = new LocationDto();
        locationDto.setId(location.getId());
        locationDto.setName(location.getName());
        return locationDto;
    }

    private Location mapToEntity(LocationDto locationDto) {
        Location location = new Location();
        location.setId(locationDto.getId());
        location.setName(locationDto.getName());
        return location;
    }
}
