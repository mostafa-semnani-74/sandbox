package ir.mosi.sandbox.model.repository;

import ir.mosi.sandbox.model.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CityRedisRepositoryImpl implements CityRedisRepository {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    public CityRedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(City city) {
        hashOperations.put("City", city.getId(), city);
    }

    @Override
    public Map<String, City> findAll() {
        return hashOperations.entries("City");
    }
}
