package com.soar.vote.front.service;

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
     * @param name 配置名
     * @return 配置
     */
    String find(String name);
}
