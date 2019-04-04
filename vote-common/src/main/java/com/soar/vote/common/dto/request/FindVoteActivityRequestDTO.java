package com.soar.vote.common.dto.request;

import com.soar.vote.common.dto.base.PageRequestDTO;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <strong>查询投票活动</strong>
 * date: 5/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
@ToString
public class FindVoteActivityRequestDTO extends PageRequestDTO implements Serializable {
    private static final long serialVersionUID = -6510958441816540110L;

    /** 开始时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
