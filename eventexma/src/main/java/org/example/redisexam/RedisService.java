package org.example.redisexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    //TTL(Time tod Live) - 특정 시간 동안만 데이터를 유지하고, 이후에는 자동 삭제됨.
    public void saveJsonWithTTL(String key, String json, long ttlInseconds){
        redisTemplate.opsForValue().set(key,json, Duration.ofSeconds(ttlInseconds));
    }

    public String getJson(String key){
        return (String)redisTemplate.opsForValue().get(key);
    }
}
