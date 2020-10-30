package com.lcms.modules.system.user.domain.dto;

public class PwdDto {
    /**
     * 原登陆密码
     */
    private String originalPwd;
    /**
     * 新登陆密码
     */
    private String newPwd;
    /**
     * 确认密码
     */
    private String confirmNewPwd;

    public String getOriginalPwd() {
        return originalPwd;
    }

    public void setOriginalPwd(String originalPwd) {
        this.originalPwd = originalPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getConfirmNewPwd() {
        return confirmNewPwd;
    }

    public void setConfirmNewPwd(String confirmNewPwd) {
        this.confirmNewPwd = confirmNewPwd;
    }

}
