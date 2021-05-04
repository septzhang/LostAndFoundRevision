package com.test.pojo;

import java.util.Date;

public class Emailtable {
    private Integer emailId;

    private String emailSender;

    private String emailAddressee;

    private Byte emailStatus;

    private String emailInfo;

    private Date emailTime;

    public Integer getEmailId() {
        return emailId;
    }

    public void setEmailId(Integer emailId) {
        this.emailId = emailId;
    }

    public String getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(String emailSender) {
        this.emailSender = emailSender == null ? null : emailSender.trim();
    }

    public String getEmailAddressee() {
        return emailAddressee;
    }

    public void setEmailAddressee(String emailAddressee) {
        this.emailAddressee = emailAddressee == null ? null : emailAddressee.trim();
    }

    public Byte getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(Byte emailStatus) {
        this.emailStatus = emailStatus;
    }

    public String getEmailInfo() {
        return emailInfo;
    }

    public void setEmailInfo(String emailInfo) {
        this.emailInfo = emailInfo == null ? null : emailInfo.trim();
    }

    public Date getEmailTime() {
        return emailTime;
    }

    public void setEmailTime(Date emailTime) {
        this.emailTime = emailTime;
    }
}