package com.roc.sale.leave.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.roc.common.annotation.Excel;
import com.roc.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 请假管理对象 SALE_LEAVE
 * 
 * @author roc
 * @date 2023-01-03
 */
public class SaleLeave extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 请假主键 */
    private String leaveId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String leaveName;

    /** 工号 */
    @Excel(name = "工号")
    private String leaveStaff;

    /** 类型 */
    @Excel(name = "类型")
    private String leaveType;

    /** 请假开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "请假开始时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date leaveStartTime;

    /** 请假结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "请假结束时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date leaveEndTime;

    /** 请假说明 */
    @Excel(name = "请假说明")
    private String leaveDesc;

    /** 请假时长 */
    @Excel(name = "请假时长")
    private String leaveDuration;

    /** 状态 */
    @Excel(name = "状态")
    private String statusCd;

    /** 状态时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "状态时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date statusTime;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createStaff;

    /** 更新人 */
    @Excel(name = "更新人")
    private String updateStaff;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;

    public void setLeaveId(String leaveId) 
    {
        this.leaveId = leaveId;
    }

    public String getLeaveId() 
    {
        return leaveId;
    }
    public void setLeaveName(String leaveName) 
    {
        this.leaveName = leaveName;
    }

    public String getLeaveName() 
    {
        return leaveName;
    }
    public void setLeaveStaff(String leaveStaff) 
    {
        this.leaveStaff = leaveStaff;
    }

    public String getLeaveStaff() 
    {
        return leaveStaff;
    }
    public void setLeaveType(String leaveType) 
    {
        this.leaveType = leaveType;
    }

    public String getLeaveType() 
    {
        return leaveType;
    }
    public void setLeaveStartTime(Date leaveStartTime) 
    {
        this.leaveStartTime = leaveStartTime;
    }
    
    public Date getLeaveStartTime() 
    {
        return leaveStartTime;
    }
    public void setLeaveEndTime(Date leaveEndTime) 
    {
        this.leaveEndTime = leaveEndTime;
    }

    public Date getLeaveEndTime() 
    {
        return leaveEndTime;
    }
    public void setLeaveDesc(String leaveDesc) 
    {
        this.leaveDesc = leaveDesc;
    }

    public String getLeaveDesc() 
    {
        return leaveDesc;
    }
    public void setLeaveDuration(String leaveDuration) 
    {
        this.leaveDuration = leaveDuration;
    }

    public String getLeaveDuration() 
    {
        return leaveDuration;
    }
    public void setStatusCd(String statusCd) 
    {
        this.statusCd = statusCd;
    }

    public String getStatusCd() 
    {
        return statusCd;
    }
    public void setStatusTime(Date statusTime) 
    {
        this.statusTime = statusTime;
    }

    public Date getStatusTime() 
    {
        return statusTime;
    }
    public void setCreateStaff(String createStaff) 
    {
        this.createStaff = createStaff;
    }

    public String getCreateStaff() 
    {
        return createStaff;
    }
    public void setUpdateStaff(String updateStaff) 
    {
        this.updateStaff = updateStaff;
    }

    public String getUpdateStaff() 
    {
        return updateStaff;
    }
    public void setUpdatedTime(Date updatedTime) 
    {
        this.updatedTime = updatedTime;
    }

    public Date getUpdatedTime() 
    {
        return updatedTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("leaveId", getLeaveId())
            .append("leaveName", getLeaveName())
            .append("leaveStaff", getLeaveStaff())
            .append("leaveType", getLeaveType())
            .append("leaveStartTime", getLeaveStartTime())
            .append("leaveEndTime", getLeaveEndTime())
            .append("leaveDesc", getLeaveDesc())
            .append("leaveDuration", getLeaveDuration())
            .append("statusCd", getStatusCd())
            .append("statusTime", getStatusTime())
            .append("createStaff", getCreateStaff())
            .append("createTime", getCreateTime())
            .append("updateStaff", getUpdateStaff())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
