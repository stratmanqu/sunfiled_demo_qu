package com.sunfield.demo.common.utils;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class ApiUtil {


    public static LoadingCache<String, AtomicLong> count = CacheBuilder.newBuilder()
            .expireAfterWrite(1, TimeUnit.SECONDS)
            .build(new CacheLoader<String, AtomicLong>() {
                @Override
                public AtomicLong load(String o) throws Exception {
                    return new AtomicLong(0L);
                }
            });


    /**
     *
     * @param methodName
     * @param limits
     * @return
     */
    public static boolean apiControl(String methodName, int limits){
        Long currentSeconds = System.currentTimeMillis() / 1000;
        System.out.println(currentSeconds);
        try {
            long andIncrement = count.get(methodName + currentSeconds).getAndIncrement();
            System.out.println(andIncrement);
            if (andIncrement > limits){
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

}
