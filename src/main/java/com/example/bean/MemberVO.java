package com.example.bean;
import java.util.Date;

public class MemberVO {
    private int seq;
    private String userid;
    private String username;
    private String password;
    private String email;
    private String photo;
    private String pr;
    private Date regdate;
    private int cnt;

    public int getSeq() {
        return seq;
    }
    public void setSeq(int seq) {
        this.seq = seq;
    }
    public String getT() {
        return userid;
    }
    public void setuserid(String userid) {
        this.userid = userid;
    }
    public String getusername() {
        return username;
    }
    public void setusername(String writer) {
        this.username = username;
    }
    public String getpassword() {
        return password;
    }
    public void setpassword(String password) {
        this.password = password;
    }
    public String getemail() {
        return email;
    }
    public void setemail(String email) {
        this.email = email;
    }
    public String getphoto() {
        return photo;
    }
    public void setphoto(String photo) {
        this.photo = photo;
    }
    public String getpr() {
        return pr;
    }
    public void setpr(String pr) {
        this.pr = pr;
    }
    public Date getRegdate() {
        return regdate;
    }
    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public int getCnt() {
        return cnt;
    }
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
