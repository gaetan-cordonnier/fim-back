package com.my.fim.controller;

import com.my.fim.dto.LocationDto;
import com.my.fim.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/location")
@AllArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<LocationDto> createLocation(@RequestBody LocationDto locationDto) {
        return new ResponseEntity<>(locationService.createLocation(locationDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/get/")
    public ResponseEntity<List<LocationDto>> getAllLocation() {
        return new ResponseEntity<>(locationService.getAllLocation(), HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<LocationDto> getLocationById(@PathVariable Long id) {
        return ResponseEntity.ok(locationService.getLocationById(id));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<LocationDto> updateLocationById(@RequestBody LocationDto locationDto, @PathVariable("id") Long locationId) {
        LocationDto response = locationService.updateLocationById(locationDto, locationId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/delete")
    public ResponseEntity<String> deleteLocationById(@PathVariable("id") Long locationId) {
        locationService.deleteLocationById(locationId);
        return new ResponseEntity<>("Lieu de stockage supprimé", HttpStatus.OK);
    }
}
