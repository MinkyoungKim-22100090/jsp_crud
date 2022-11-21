package com.common.file;

import com.common.bean.teamVO;
import com.common.dao.teamDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class FileUpload {
    public teamVO uploadPhoto(HttpServletRequest request){
        String filename="";
        int sizeLimit=15*1024*1024;

        String realPath=request.getServletContext().getRealPath("upload");

        File dir=new File(realPath);
        if(!dir.exists()) dir.mkdirs();

        teamVO one=null;
        MultipartRequest multipartRequest=null;
        try{
            multipartRequest=new MultipartRequest(request,realPath,sizeLimit,"utf-8", new DefaultFileRenamePolicy());
            filename=multipartRequest.getFilesystemName("photo");
            one =new teamVO();
            String sid=multipartRequest.getParameter("sid");
            if(sid!=null&&!sid.equals("")) one.setSid(Integer.parseInt(sid));
            one.setName(multipartRequest.getParameter("name"));
            one.setGrade(multipartRequest.getParameter("grade"));
            one.setMajor(multipartRequest.getParameter("major"));
            one.setEmail(multipartRequest.getParameter("email"));
            one.setPhoto(multipartRequest.getParameter("photo"));
            one.setDetail(multipartRequest.getParameter("detail"));

            if(sid!=null&&!sid.equals("")){
                teamDAO dao= new teamDAO();
                String oldfilename=dao.getPhotoFilename(Integer.parseInt(sid));
                if(filename!=null&&oldfilename!=null)
                    FileUpload.deleteFile(request,oldfilename);
                else if(filename==null&&oldfilename!=null)
                    filename=oldfilename;
            }

            one.setPhoto(filename);


        }catch(IOException e){
            e.printStackTrace();
        }
        return one;
    }
    public static void deleteFile(HttpServletRequest request, String filename) {
        String filePath=request.getServletContext().getRealPath("upload");
        File f=new File(filePath+"/"+filename);
        if(f.exists()) f.delete();
    }
}
