package com.sunfield.demo.controller;

import com.sunfield.demo.Repository.ApiConfigRepository;
import com.sunfield.demo.common.dto.ResponseResult;
import com.sunfield.demo.common.utils.ApiUtil;
import com.sunfield.demo.domain.ApiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/demo")
public class maincontroller {

    @Autowired
    private ApiConfigRepository apiConfigRepository;


    @GetMapping(path="/api")
    public @ResponseBody ResponseResult getAllUsers() {
        ApiConfig config = apiConfigRepository.findById(1).orElse(null);
        int limits = config == null ? 100 : config.getNum();

        if (ApiUtil.apiControl("api", limits)) {
            return ResponseResult.success();
        }else {
            return ResponseResult.busy();
        }
    }

}
