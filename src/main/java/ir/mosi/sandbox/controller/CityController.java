package ir.mosi.sandbox.controller;

import ir.mosi.sandbox.model.entity.City;
import ir.mosi.sandbox.model.repository.CityRedisRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/city")
public class CityController {

    @Autowired
    private CityRedisRepositoryImpl cityRedisRepository;

    public CityController(CityRedisRepositoryImpl cityRedisRepository) {
        this.cityRedisRepository = cityRedisRepository;
    }

    @GetMapping("/findAll")
    public Map<String, City> findAll() {
        return cityRedisRepository.findAll();
    }

    @PostMapping
    public ResponseEntity save(@RequestBody City city) {
        cityRedisRepository.save(city);
        return ResponseEntity.ok().build();
    }


}
