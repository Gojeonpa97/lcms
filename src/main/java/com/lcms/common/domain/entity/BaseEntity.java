package com.lcms.common.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.lcms.common.domain.enums.DelFlagEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 8151779591598104439L;

    /**
     * 主键SID
     */
    @TableId(value = "sid")
    private Integer sid;

    /**
     * 系统创建人
     */
    private String createUser;

    /**
     * 系统创建时间
     */
    private Date createTime;

    /**
     * 系统更新人
     */
    private String updateUser;

    /**
     * 系统更新时间
     */
    private Date updateTime;

    /**
     * 删除标记（0代表创建 1代表删除）
     */
    private DelFlagEnum delFlag;


    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getCreateUser() {
        return createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setDelFlag(DelFlagEnum delFlag) {
        this.delFlag = delFlag;
    }

    public DelFlagEnum getDelFlag() {
        return delFlag;
    }

    /**
     * 创建记录之前执行
     */
    public void preCreate(String userCode) {
        this.sid = sid;
        this.createUser = userCode;
        this.createTime = new Date();
        this.updateUser=userCode;
        this.updateTime=new Date();
        this.delFlag = DelFlagEnum.CREATE;
    }

    /**
     * 修改记录之前执行
     */
    public void preUpdate(String userCode) {
        this.updateUser = userCode;
        this.updateTime = new Date();
    }

    /**
     * 删除记录之前执行
     */
    public void preDelete(String userCode) {
        this.updateUser = userCode;
        this.updateTime = new Date();
        this.delFlag = DelFlagEnum.DELETE;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        BaseEntity that = (BaseEntity) obj;
        return null == this.getSid() ? false : this.getSid().equals(that.getSid());
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
