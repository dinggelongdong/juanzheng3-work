package xyz.gyfjuly.domain;

public class User {
    /**
     *唯一标识
     */
    private String uId;

    /**
     *登录账号
     */
    private String uAccount;

    /**
     *用户名
     */
    private String uName;

    /**
     *密码
     */
    private String uPwd;

    /**
     *班级
     */
    private String uClass;

    /**
     *性别
     */
    private String uSex;

    /**
     *手机号
     */
    private String uPhone;

    /**
     *邮箱
     */
    private String uEmail;

    /**
     *角色
     */
    private Integer uRole;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuAccount() {
        return uAccount;
    }

    public void setuAccount(String uAccount) {
        this.uAccount = uAccount;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public String getuClass() {
        return uClass;
    }

    public void setuClass(String uClass) {
        this.uClass = uClass;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public Integer getuRole() {
        return uRole;
    }

    public void setuRole(Integer uRole) {
        this.uRole = uRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uAccount='" + uAccount + '\'' +
                ", uName='" + uName + '\'' +
                ", uPwd='" + uPwd + '\'' +
                ", uClass='" + uClass + '\'' +
                ", uSex='" + uSex + '\'' +
                ", uPhone='" + uPhone + '\'' +
                ", uEmail='" + uEmail + '\'' +
                ", uRole=" + uRole +
                '}';
    }
}

