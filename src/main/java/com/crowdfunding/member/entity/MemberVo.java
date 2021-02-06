package com.crowdfunding.member.entity;

import java.util.Date;

public class MemberVo {

    private int id;
    private String userName;
    private String userId;
    private String userPassword;
    private String userBirth;
    private String userPhone;
    private String userEmail;
    private String userPostcode;
    private String userAddress;
    private String userDetailAddress;
    private String userExtraAddress;
    private Date regDate;


    public MemberVo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPostcode() {
        return userPostcode;
    }

    public void setUserPostcode(String userPostcode) {
        this.userPostcode = userPostcode;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserDetailAddress() {
        return userDetailAddress;
    }

    public void setUserDetailAddress(String userDetailAddress) {
        this.userDetailAddress = userDetailAddress;
    }

    public String getUserExtraAddress() {
        return userExtraAddress;
    }

    public void setUserExtraAddress(String userExtraAddress) {
        this.userExtraAddress = userExtraAddress;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "MemberVo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userBirth='" + userBirth + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPostcode='" + userPostcode + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userDetailAddress='" + userDetailAddress + '\'' +
                ", userExtraAddress='" + userExtraAddress + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
