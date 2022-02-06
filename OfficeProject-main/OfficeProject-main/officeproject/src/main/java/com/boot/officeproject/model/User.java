package com.boot.officeproject.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;




@Entity
@Table(name = "user_create_info")
public class User {

    @Id
    @Column(nullable = false)
    private String employeeCode;
    @Column(nullable = false)
    private String companyCode;
    @Column(nullable = false)
    private String employeeName;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String userRole;
    @Column(nullable = false)
    private String password;

    @Transient
    private String oldPassword;

    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private LocalDate createDate;
    @Column(nullable = true)
    private LocalDate updateDate;
    @Column(nullable = false)
    private long mobile;
    @Column(name = "reset_password_token")
    private String resetPasswordToken;

    public User() {
    }

    public User(String employeeCode, String companyCode, String employeeName, String username, String userRole,
            String password, String oldPassword, String email, LocalDate createDate, LocalDate updateDate, long mobile,
            String resetPasswordToken) {
        this.employeeCode = employeeCode;
        this.companyCode = companyCode;
        this.employeeName = employeeName;
        this.username = username;
        this.userRole = userRole;
        this.password = password;
        this.oldPassword = oldPassword;
        this.email = email;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.mobile = mobile;
        this.resetPasswordToken = resetPasswordToken;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    @Override
    public String toString() {
        return "User [companyCode=" + companyCode + ", createDate=" + createDate + ", email=" + email
                + ", employeeCode=" + employeeCode + ", employeeName=" + employeeName + ", mobile=" + mobile
                + ", oldPassword=" + oldPassword + ", password=" + password + ", resetPasswordToken="
                + resetPasswordToken + ", updateDate=" + updateDate + ", userRole=" + userRole + ", username="
                + username + "]";
    }
    
}
