package xyz.gyfjuly.domain;

public class User {
    /**
     *Ψһ��ʶ
     */
    private String uId;

    /**
     *��¼�˺�
     */
    private String uAccount;

    /**
     *�û���
     */
    private String uName;

    /**
     *����
     */
    private String uPwd;

    /**
     *�Ա�
     */
    private String uSex;

    /**
     *�ֻ���
     */
    private String uPhone;

    /**
     *����
     */
    private String uEmail;

    /**
     *��ɫ
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
                ", uSex='" + uSex + '\'' +
                ", uPhone='" + uPhone + '\'' +
                ", uEmail='" + uEmail + '\'' +
                ", uRole=" + uRole +
                '}';
    }
}

