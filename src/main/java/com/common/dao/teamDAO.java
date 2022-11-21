package com.common.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.common.bean.teamVO;
import com.common.util.JDBCUtil;

public class teamDAO {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    private final String TEAM_INSERT = "insert into team (sname, grade, major, email,photo,detail) values (?,?,?,?,?,?)";
    private final String TEAM_UPDATE = "update team set sname=?, grade=?, major=?, email=?,photo=?,detail=?, where sid=?";
    private final String TEAM_DELETE = "delete from team  where sid=?";
    private final String TEAM_GET = "select * from team where sid=?";
    private final String TEAM_LIST = "select * from team order by sid desc";

    public int insertTEAM(teamVO vo) {
        System.out.println("===> JDBC로 insertTEAM() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(TEAM_INSERT);
            stmt.setString(1, vo.getName());
            stmt.setString(2, vo.getGrade());
            stmt.setString(3, vo.getMajor());
            stmt.setString(4, vo.getEmail());
            stmt.setString(5, vo.getPhoto());
            stmt.setString(6, vo.getDetail());
            stmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 글 삭제
    public void deleteTEAM(teamVO vo) {
        System.out.println("===> JDBC로 deleteTEAM() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(TEAM_DELETE);
            stmt.setInt(1, vo.getSid());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int updateTEAM(teamVO vo) {
        System.out.println("===> JDBC로 updateTEAM() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(TEAM_UPDATE);
            stmt.setString(1, vo.getName());
            stmt.setString(2, vo.getGrade());
            stmt.setString(3, vo.getMajor());
            stmt.setString(4, vo.getEmail());
            stmt.setString(5, vo.getPhoto());
            stmt.setString(6, vo.getDetail());


            System.out.println(vo.getName() + "-" + vo.getGrade() + "-" + vo.getMajor() + "-" + vo.getEmail()+ "-" + vo.getPhoto()+ "-" + vo.getDetail());
            stmt.executeUpdate();
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public teamVO getTEAM(int sid) {
        teamVO one = new teamVO();
        System.out.println("===> JDBC로 getTEAM() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(TEAM_GET);
            stmt.setInt(1, sid);
            rs = stmt.executeQuery();
            if(rs.next()) {
                one.setSid(rs.getInt("sid"));
                one.setName(rs.getString("name"));
                one.setGrade(rs.getString("grade"));
                one.setMajor(rs.getString("major"));
                one.setEmail(rs.getString("email"));
                one.setPhoto(rs.getString("photo"));
                one.setDetail(rs.getString("detail"));
                one.setRegdate(rs.getDate("regdate"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return one;
    }

    public List<teamVO> getTEAMList(){
        List<teamVO> list = new ArrayList<teamVO>();
        System.out.println("===> JDBC로 getTEAMList() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(TEAM_LIST);
            rs = stmt.executeQuery();
            while(rs.next()) {
                teamVO one = new teamVO();
                one.setSid(rs.getInt("sid"));
                one.setName(rs.getString("name"));
                one.setGrade(rs.getString("grade"));
                one.setMajor(rs.getString("major"));
                one.setEmail(rs.getString("email"));
                one.setPhoto(rs.getString("photo"));
                one.setDetail(rs.getString("detail"));
                one.setRegdate(rs.getDate("regdate"));
                list.add(one);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public String getPhotoFilename(int sid) {
        String filename=null;
        try{
            conn=JDBCUtil.getConnection();
            stmt=conn.prepareStatement(TEAM_GET);
            stmt.setInt(1,sid);
            rs=stmt.executeQuery();
            if(rs.next()){
                filename=rs.getString("photo");
            }
            rs.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("===> JDBC로 getPhotoFilename() 기능 처리");
        return filename;
    }
}
