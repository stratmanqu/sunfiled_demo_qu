package com.sunfield.demo.controller;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.sunfield.demo.Repository.ApiConfigRepository;
import com.sunfield.demo.domain.ApiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping(path="/demo")
public class maincontroller {

    @Autowired
    private ApiConfigRepository apiConfigRepository;

    static LoadingCache<Long, AtomicLong> count = CacheBuilder.newBuilder()
            .expireAfterWrite(1, TimeUnit.SECONDS)
            .build(new CacheLoader<Long, AtomicLong>() {
                @Override
                public AtomicLong load(Long o) throws Exception {
                    System.out.println("Load call!");
                    return new AtomicLong(0L);
                }
    });


    @GetMapping(path="/api")
    public @ResponseBody String getAllUsers() {
        // This returns a JSON or XML with the users
        ApiConfig config = apiConfigRepository.findById(1).orElse(null);
        int limits = config == null ? 100 : config.getNum();
        Long currentSeconds = System.currentTimeMillis() / 1000;
        try {
            if (count.get(currentSeconds).getAndIncrement() > limits){
                return "Failure";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Success";
    }

}
