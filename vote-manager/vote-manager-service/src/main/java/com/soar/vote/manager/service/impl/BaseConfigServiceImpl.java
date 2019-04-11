package com.soar.vote.manager.service.impl;

import com.soar.vote.manager.service.BaseConfigService;
import com.soar.vote.persistence.entity.BaseConfig;
import com.soar.vote.persistence.mapper.BaseConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<BaseConfig> find() {

        return baseConfigMapper.selectAll();
    }

    @Override
    public BaseConfig find(String configId) {

        BaseConfig selectResult = baseConfigMapper.selectByPrimaryKey(configId);
        if(selectResult == null){
            return null;
        }
        return selectResult;
    }
}
