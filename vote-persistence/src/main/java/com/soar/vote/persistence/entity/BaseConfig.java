package com.soar.vote.persistence.entity;

import javax.persistence.*;

@Table(name = "base_config")
public class BaseConfig {
    /**
     * 配置编号
     */
    @Id
    @Column(name = "config_id")
    private String configId;

    /**
     * 配置名称
     */
    @Column(name = "config_name")
    private String configName;

    /**
     * 配置值
     */
    @Column(name = "config_value")
    private String configValue;

    /**
     * 获取配置编号
     *
     * @return config_id - 配置编号
     */
    public String getConfigId() {
        return configId;
    }

    /**
     * 设置配置编号
     *
     * @param configId 配置编号
     */
    public void setConfigId(String configId) {
        this.configId = configId;
    }

    /**
     * 获取配置名称
     *
     * @return config_name - 配置名称
     */
    public String getConfigName() {
        return configName;
    }

    /**
     * 设置配置名称
     *
     * @param configName 配置名称
     */
    public void setConfigName(String configName) {
        this.configName = configName;
    }

    /**
     * 获取配置值
     *
     * @return config_value - 配置值
     */
    public String getConfigValue() {
        return configValue;
    }

    /**
     * 设置配置值
     *
     * @param configValue 配置值
     */
    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }
}