package ir.mosi.sandbox.model.repository;

import ir.mosi.sandbox.model.entity.City;

import java.util.List;
import java.util.Map;

public interface CityRedisRepository {
    void save(City city);
    Map<String, City> findAll();
}
