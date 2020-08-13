package com.xinrenxinshi.request;

import com.xinrenxinshi.common.MethodEnum;
import com.xinrenxinshi.exception.ParamNotValidException;
import com.xinrenxinshi.openapi.AbstractOpenapiAPIRequest;
import com.xinrenxinshi.openapi.OpenapiResponse;
import com.xinrenxinshi.util.XRXSStrUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 员工出差打卡request
 *
 * @author: jiazijie
 * @create: 2019-11-14 16:42
 **/
public class AttendanceTravelRequest extends AbstractOpenapiAPIRequest<OpenapiResponse> {
    /**
     * employeeId
     */
    private String employeeId;

    /**
     * 出差开始日期，日期格式：yyyy-MM-dd
     */
    private String startDate;

    /**
     * 出差开始时间，AM：上半天、PM：下半天
     */
    private String startTime;

    /**
     * 出差结束日期，日期格式：yyyy-MM-dd
     */
    private String endDate;

    /**
     * 出差结束时间，AM：上半天、PM：下半天
     */
    private String endTime;


    public AttendanceTravelRequest(String accessToken) {
        super(accessToken);
    }


    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    protected Map<String, Object> getParamMap0() {
        Map<String, Object> map = new HashMap<>();
        map.put("employeeId", employeeId);
        map.put("startDate", startDate);
        map.put("startTime", startTime);
        map.put("endDate", endDate);
        map.put("endTime", endTime);
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
        if(XRXSStrUtils.isEmpty(employeeId)) {
            throw new ParamNotValidException("员工employeeId为空");
        }
        if (startDate == null) {
            throw new ParamNotValidException("出差开始日期为空");
        }
        if (startTime == null) {
            throw new ParamNotValidException("出差开始时间为空");
        }
        if (endDate == null) {
            throw new ParamNotValidException("出差结束日期为空");
        }
        if (endTime == null) {
            throw new ParamNotValidException("出差结束时间为空");
        }
    }

    @Override
    public String getBizUrl() {
        return "/v4/attendance/travel";
    }
}
