package com.xinrenxinshi.request;

import com.xinrenxinshi.common.MethodEnum;
import com.xinrenxinshi.exception.ParamNotValidException;
import com.xinrenxinshi.openapi.AbstractOpenapiRequest;
import com.xinrenxinshi.openapi.OpenapiResponse;
import com.xinrenxinshi.util.XRXSStrUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 员工手机号打卡request
 *
 * @author: jiazijie
 * @create: 2019-11-14 16:42
 **/
public class AttendanceClockByMobileRequest extends AbstractOpenapiRequest<OpenapiResponse> {
    /**
     * 员工手机号
     */
    private String mobile;

    /**
     * 打卡时间戳（精确到秒）
     */
    private Integer clockTime;


    public AttendanceClockByMobileRequest(String accessToken) {
        super(accessToken);
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getClockTime() {
        return clockTime;
    }

    public void setClockTime(Integer clockTime) {
        this.clockTime = clockTime;
    }


    @Override
    protected Map<String, Object> getParamMap0() {
        Map<String, Object> map = new HashMap<>();
        map.put("mobile", mobile);
        map.put("clockTime", clockTime);
        return map;
    }

    @Override
    public MethodEnum getMethod() {
        return MethodEnum.METHOD_POST;
    }

    @Override
    public Class<OpenapiResponse> getResponseClass() {
        return OpenapiResponse.class;
    }

    @Override
    public void check() throws ParamNotValidException {
        if(XRXSStrUtils.isEmpty(mobile)) {
            throw new ParamNotValidException("员工mobile为空");
        }
        if (clockTime == null) {
            throw new ParamNotValidException("打卡时间戳（精确到秒）");
        }
    }

    @Override
    public String getBizUrl() {
        return "/v2/attendance/clockByMobile";
    }
}
