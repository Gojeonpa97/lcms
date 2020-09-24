package com.lcms.modules.system.log.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_log
 * @author 
 */
@Getter
@Setter
public class SysLog implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 登录账号
     */
    private String userName;

    /**
     * 内容
     */
    private String content;

    /**
     * 日志类型(0登录日志  1操作日志  2异常日志)
     */
    private String logType;

    /**
     * 登录IP地址
     */
    private String ip;

    /**
     * 模块
     */
    private String module;

    /**
     * 登录地点
     */
    private String loginLocation;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 登录状态（0成功 1失败）
     */
    private String status;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 备注说明
     */
    private String description;

    private static final long serialVersionUID = 1L;

}