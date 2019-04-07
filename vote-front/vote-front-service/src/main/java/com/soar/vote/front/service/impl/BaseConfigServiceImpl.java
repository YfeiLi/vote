package com.soar.vote.front.service.impl;

import com.soar.vote.front.service.BaseConfigService;
import com.soar.vote.persistence.entity.BaseConfig;
import com.soar.vote.persistence.mapper.BaseConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <strong>基础配置</strong>
 * date: 7/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@Service
public class BaseConfigServiceImpl implements BaseConfigService {

    @Autowired
    private BaseConfigMapper baseConfigMapper;

    @Override
    public String find(String name) {

        BaseConfig selectResult = baseConfigMapper.selectByPrimaryKey(name);
        if(selectResult == null){
            return null;
        }
        return selectResult.getValue();
    }
}
