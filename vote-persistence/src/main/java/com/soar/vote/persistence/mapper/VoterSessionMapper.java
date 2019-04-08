package com.soar.vote.persistence.mapper;

import com.soar.vote.persistence.entity.VoterSession;
import tk.mybatis.mapper.common.Mapper;

public interface VoterSessionMapper extends Mapper<VoterSession> {

    /**
     * 通过登录令牌获取会话信息
     * @date 7/4/2019
     * @author liyife
     * @param sessionContent 登录令牌
     * @return 会话信息
     */
    VoterSession selectByContent(String sessionContent);
}