package com.igogo.api.controller.common;

import com.igogo.api.ResponseModel.base.FileMV;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.beans.SimpleBeanInfo;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Lee on 2017/5/8.
 */
@Controller
@RequestMapping("api/upload")
public class UploadController  {

    @RequestMapping("uploadPic")
    @ResponseBody
    public FileMV uploadPic(String fileName, HttpServletRequest request, Writer out) throws IOException {
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;

        MultipartFile file = req.getFile(fileName);
        byte[] bytes = file.getBytes();

        //获取文件名
        String originalFilename = file.getOriginalFilename();

        //截取扩展名
        String sufstr = originalFilename.substring(originalFilename.indexOf("."));
        //生成文件名
        String nFileName = new SimpleDateFormat("yyyyMMddssSSS").format(new Date());
        Random random = new Random();
        for(int i=0; i< 2; i++){
            nFileName = nFileName + random.nextInt(10);
        }

        //文件绝对路径和相对路径
        String absPath = "localhost:8083"+"/image/"+nFileName+"."+sufstr;
        String relPath = "/image/"+nFileName+"."+sufstr;
        //文件上传
        Client client = new Client();
        //指定上传路径
        WebResource resource = client.resource(absPath);
        //文件回显示和相对路径回传

        FileMV mv = new FileMV();
        mv.setAbsFilePath(absPath);
        mv.setRelFilePath(relPath);
        return mv;
    }
}
