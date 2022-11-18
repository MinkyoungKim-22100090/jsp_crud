package com.example.dao;
import com.example.bean.BoardVO;
import com.example.bean.MemberVO;
import com.example.util.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    private final String M_GET = "select * from Member where sid=?";
    private final String M_INSERT = "insert into MemberD (userid, username, password, email, photo, pr) values (?,?,shal(?),?,?,?)";
    private final String M_SELECT="select * from Member where sid=?";
    private final String M_LIST = "select * from Member order by regdate desc";
    private final String M_UPDATE = "update Member set userid=?, username=?, password=?,email=?,photo=?,pr=? where sid=?";
    private final String M_DELETE = "delete from Member where sid=?";
    public MemberVO getMember(int seq) {
        MemberVO one = new MemberVO();
        System.out.println("===> JDBC로 getMember() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(M_GET);
            stmt.setInt(1, seq);
            rs = stmt.executeQuery();
            if(rs.next()) {
                one.setSid(rs.getInt("sid"));
                one.setUsername(rs.getString("username"));
                one.setUserid(rs.getString("userid"));
                one.setPassword(rs.getString("password"));
                one.setPhoto(rs.getString("photo"));
                one.setEmail(rs.getString("email"));
                one.setPr(rs.getString("pr"));
                one.setCnt(rs.getInt("cnt"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return one;
    }
    public int insertMember(MemberVO data) {
        System.out.println("===> JDBC로 insertMember() 기능 처리");
        int result=0;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(M_INSERT);
            stmt.setString(1, data.getUserid());
            stmt.setString(2, data.getUsername());
            stmt.setString(3, data.getPassword());
            stmt.setString(4, data.getPhoto());
            stmt.setString(5, data.getEmail());
            stmt.setString(6, data.getPr());
            result= stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public MemberVO getOne(int sid){
        MemberVO one=null;
        conn=JDBCUtil.getConnection();
        try{
            stmt = conn.prepareStatement(M_SELECT);
            stmt.setInt(1,sid);
            rs=stmt.executeQuery();
            if(rs.next()){
                one=new MemberVO();
                one.setSid(rs.getInt("sid"));
                one.setUserid(rs.getString("userid"));
                one.setUsername(rs.getString("username"));
                one.setPassword(rs.getString("password"));
                one.setEmail(rs.getString("email"));
                one.setPhoto(rs.getString("photo"));
                one.setPr(rs.getString("pr"));
                one.setRegdate(rs.getDate("regdate"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return one;
    }
    public ArrayList<MemberVO> getList(){
        ArrayList<MemberVO> list=null;
        conn=JDBCUtil.getConnection();
        try{
            stmt = conn.prepareStatement(M_LIST);
            rs=stmt.executeQuery();
            list=new ArrayList<MemberVO>();
            MemberVO one=new MemberVO();
            while(rs.next()){
                one=new MemberVO();
                one.setSid(rs.getInt("sid"));
                one.setUserid(rs.getString("userid"));
                one.setUsername(rs.getString("username"));
                one.setPassword(rs.getString("password"));
                one.setEmail(rs.getString("email"));
                one.setPhoto(rs.getString("photo"));
                one.setPr(rs.getString("pr"));
                one.setRegdate(rs.getDate("regdate"));
                list.add(one);
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public void deleteMember(MemberVO vo) {
        System.out.println("===> JDBC로 deleteMember() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(M_DELETE);
            stmt.setInt(1, vo.getSid());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int updateMember(MemberVO data) {
        System.out.println("===> JDBC로 updateMemberd() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(M_UPDATE);
            stmt.setString(1, data.getUserid());
            stmt.setString(2, data.getUsername());
            stmt.setString(3, data.getPassword());
            stmt.setString(4, data.getPhoto());
            stmt.setString(5, data.getEmail());
            stmt.setString(6, data.getPr());
            System.out.println(data.getUserid() + "-" + data.getUsername() + "-" + data.getPassword() + "-" + data.getPhoto()+ "-" + data.getEmail()+ "-" + data.getPr());
            stmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
//int sid, String userid, String username, String password,String email,String photo,String pr,Date regdate, int cnt