package com.soar.vote.front.controller;

import com.soar.vote.front.service.BaseConfigService;
import com.soar.vote.persistence.entity.BaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <strong>基础配置</strong>
 * date: 7/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@RequestMapping("baseConfig")
@RestController
public class BaseConfigControler {

    @Autowired
    private BaseConfigService baseConfigService;

    @GetMapping("/{name}")
    ResponseEntity<String> find(@PathVariable("name") String name){

        String config = baseConfigService.find(name);
        if(StringUtils.isEmpty(config)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(config);
    }
}
