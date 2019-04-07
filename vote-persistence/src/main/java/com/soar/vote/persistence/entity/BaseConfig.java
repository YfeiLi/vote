package com.soar.vote.persistence.entity;

import javax.persistence.*;

@Table(name = "base_config")
public class BaseConfig {
    /**
     * 名称
     */
    @Id
    private String name;

    /**
     * 值
     */
    private String value;

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取值
     *
     * @return value - 值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置值
     *
     * @param value 值
     */
    public void setValue(String value) {
        this.value = value;
    }
}