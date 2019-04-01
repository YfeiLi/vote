package com.soar.vote.common.dto.request;

/**
 * <strong>修改投票区域</strong>
 * date: 31/3/2019
 *
 * @author liyifei
 * @version 1.0
 **/
public class UpdateVoteScopeRequestDTO {

    /** 区域名 */
    private String scopeName;

    /** 详细描述 */
    private String description;

    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
