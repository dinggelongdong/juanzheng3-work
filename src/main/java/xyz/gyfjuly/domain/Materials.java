package xyz.gyfjuly.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

public class Materials {
    /**
     * 唯一标识
     */
    private String mId;

    /**
     * 用户唯一标识
     */
    private String uId;

    /**
     * 物资名称
     */
    private String mMaterialName;

    /**
     * 捐赠人
     */
    private String mDonator;

    /**
     * 物资类型
     */
    private String mMaterialType;

    /**
     * 审核日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date mCheckdate;


    /**
     * 生产日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date mFactdate;


    /**
     * 捐赠日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date mDate;

    /**
     * 物资审核：0-未审核；1-审核通过；2-审核失败；3-捐赠成功
     */
    private Integer mCheck;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getmMaterialName() {
        return mMaterialName;
    }

    public void setmMaterialName(String mMaterialName) {
        this.mMaterialName = mMaterialName;
    }

    public String getmDonator() {
        return mDonator;
    }

    public void setmDonator(String mDonator) {
        this.mDonator = mDonator;
    }

    public String getmMaterialType() {
        return mMaterialType;
    }

    public void setmMaterialType(String mMaterialType) {
        this.mMaterialType = mMaterialType;
    }

    public Date getmCheckdate() {
        return mCheckdate;
    }

    public void setmCheckdate(Date mCheckdate) {
        this.mCheckdate = mCheckdate;
    }

    public Date getmFactdate() {
        return mFactdate;
    }

    public void setmFactdate(Date mFactdate) {
        this.mFactdate = mFactdate;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public Integer getmCheck() {
        return mCheck;
    }

    public void setmCheck(Integer mCheck) {
        this.mCheck = mCheck;
    }

    @Override
    public String toString() {
        return "Materials{" +
                "mId='" + mId + '\'' +
                ", uId='" + uId + '\'' +
                ", mMaterialName='" + mMaterialName + '\'' +
                ", mDonator='" + mDonator + '\'' +
                ", mMaterialType='" + mMaterialType + '\'' +
                ", mCheckdate=" + mCheckdate +
                ", mFactdate=" + mFactdate +
                ", mDate=" + mDate +
                ", mCheck=" + mCheck +
                '}';
    }
}

