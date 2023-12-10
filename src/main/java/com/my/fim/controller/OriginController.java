package com.my.fim.controller;

import com.my.fim.dto.OriginDto;
import com.my.fim.service.OriginService;
import com.my.fim.utils.ConstantUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user/origin-recipe")
@AllArgsConstructor
public class OriginController {

    private OriginService originService;

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OriginDto> createOrigin(@RequestBody OriginDto originDto) {
        return new ResponseEntity<>(originService.createOrigin(originDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/get/")
    public ResponseEntity<List<OriginDto>> getAllOrigin() {
        return new ResponseEntity<>(originService.getAllOrigin(), HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<OriginDto> getOriginById(@PathVariable Long id) {
        return ResponseEntity.ok(originService.getOriginById(id));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<OriginDto> updateOriginById(@RequestBody OriginDto originDto, @PathVariable("id") Long originId) {
        OriginDto response = originService.updateOriginById(originDto, originId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/delete")
    public ResponseEntity<String> deleteOriginById(@PathVariable("id") Long originId) {
        originService.deleteOriginById(originId);
        return new ResponseEntity<>(ConstantUtils.ORIGIN_DELETED, HttpStatus.OK);
    }

}
