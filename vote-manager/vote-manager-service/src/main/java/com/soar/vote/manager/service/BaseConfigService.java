package com.soar.vote.manager.service;

import com.soar.vote.persistence.entity.BaseConfig;

import java.util.List;

/**
 * <strong>基础配置</strong>
 * date: 7/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
public interface BaseConfigService {

    /**
     * 查询基础配置
     * @author liyifei
     * @date 7/4/2019
     * @return 配置
     */
    List<BaseConfig> find();

    /**
     * 查询基础配置
     * @author liyifei
     * @date 7/4/2019
     * @param configId 配置编号
     * @return 配置
     */
    BaseConfig find(String configId);
}
