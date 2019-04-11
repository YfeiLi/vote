package com.soar.vote.manager.controller;

import com.soar.vote.manager.service.BaseConfigService;
import com.soar.vote.persistence.entity.BaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping
    ResponseEntity<List<BaseConfig>> find(){

        List<BaseConfig> list = baseConfigService.find();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{configId}")
    ResponseEntity<BaseConfig> find(@PathVariable String configId){

        BaseConfig config = baseConfigService.find(configId);
        if(StringUtils.isEmpty(config)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(config);
    }
}
