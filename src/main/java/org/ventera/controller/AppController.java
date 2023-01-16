package org.ventera.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.ventera.TemperatureUnit;
import org.ventera.VolumeUnit;
import org.ventera.service.UnitConverterService;

@CrossOrigin(maxAge = 3600)
@RestController
public class AppController {

    public AppController(UnitConverterService unitConverterService) {
        this.unitConverterService = unitConverterService;
    }

    private final UnitConverterService unitConverterService;

    @CrossOrigin()
    @GetMapping("/volume/{inputUnit}/{value}/{targetUnit}")
    public ResponseEntity<String> convertVolume(@PathVariable VolumeUnit inputUnit,
                                          @PathVariable VolumeUnit targetUnit,
                                          @PathVariable double value) {
        try {
            double ret = unitConverterService.convertVolume(inputUnit, targetUnit, value);
            return new ResponseEntity<>(String.valueOf(ret), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping("/temperature/{inputUnit}/{value}/{targetUnit}")
    public ResponseEntity<String> convertTemperature(@PathVariable TemperatureUnit inputUnit,
                                          @PathVariable TemperatureUnit targetUnit,
                                          @PathVariable double value) {
        try {
            double ret = unitConverterService.convertTemperature(inputUnit, targetUnit, value);
            return new ResponseEntity<>(String.valueOf(ret), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
