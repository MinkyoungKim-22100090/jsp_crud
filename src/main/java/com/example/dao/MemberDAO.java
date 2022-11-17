package com.example.dao;
import com.example.bean.BoardVO;
import com.example.bean.MemberVO;
import com.example.util.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    private final String M_INSERT = "insert into Member (userid, password,username,email,photo,pr) values (?,shal(?),?,?,?,?)";
    private final String M_UPDATE = "update Member set username=?, email=?, photo=?,pr=? where sid=?";
    private final String M_DELETE = "delete from Member where sid=?";
    private final String MEMBER_GET = "select * from Member where sid=?";

    public MemberVO getMember(int seq) {
        MemberVO one = new MemberVO();
        System.out.println("===> JDBC로 getMember() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MEMBER_GET);
            stmt.setInt(1, seq);
            rs = stmt.executeQuery();
            if(rs.next()) {
                one.setSid(rs.getInt("sid"));
                one.setuserid(rs.getString("userid"));

            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return one;
    }

}
