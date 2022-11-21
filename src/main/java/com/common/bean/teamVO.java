package com.common.bean;
import java.util.Date;

public class teamVO {
    private int sid; //데이터 고유 번호
    private String sname; //이름
    private String grade; //학년
    private String major; //전공
    private String email; //이메일
    private String photo; //사진
    private String detail; //상세사항
    private Date regdate; //등록일자

    public Date getRegdate() {
        return regdate;
    }
    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getPhoto() {
        return photo;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


    public String getName() {
        return sname;
    }

    public void setName(String name) {
        this.sname = name;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

}
