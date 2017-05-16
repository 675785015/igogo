package com.igogo.api.controller.common;

import com.igogo.api.ResponseModel.base.FileMV;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.beans.SimpleBeanInfo;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Lee on 2017/5/8.
 */
@Controller
@RequestMapping("api/upload")
public class UploadController  {

//    @RequestMapping("uploadPic")
//    @ResponseBody
//    public FileMV uploadPic(String fileName, HttpServletRequest request, Writer out) throws IOException {
//        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
//
//        MultipartFile file = req.getFile(fileName);
//        byte[] bytes = file.getBytes();
//
//        //获取文件名
//        String originalFilename = file.getOriginalFilename();
//
//        //截取扩展名
//        String sufstr = originalFilename.substring(originalFilename.indexOf("."));
//        //生成文件名
//        String nFileName = new SimpleDateFormat("yyyyMMddssSSS").format(new Date());
//        Random random = new Random();
//        for(int i=0; i< 2; i++){
//            nFileName = nFileName + random.nextInt(10);
//        }
//
//        //文件绝对路径和相对路径
//        String absPath = "http://localhost:8083"+"/image/"+nFileName+sufstr;
//        String relPath = "/image/"+nFileName+"."+sufstr;
//        //文件上传
//        Client client = new Client();
//        //指定上传路径
//        WebResource resource = client.resource(absPath);
//        resource.put(bytes);
//        //文件回显示和相对路径回传
//
//        FileMV mv = new FileMV();
//        mv.setAbsFilePath(absPath);
//        mv.setRelFilePath(relPath);
//        return mv;
//    }



    @RequestMapping(value = "uploadPic")
    public FileMV upload(String file, HttpServletRequest request, ModelMap model) {

        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;

        MultipartFile mf = req.getFile(file);
        System.out.println("开始");
//        String path = request.getSession().getServletContext().getRealPath("upload");
        String path = "E:\\upload\\openwin";
        String fileName = mf.getOriginalFilename();
        System.out.println(path);
        File targetFile = new File(path);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        //保存
        try {
            //获取输出流
            OutputStream os=new FileOutputStream(path+"\\"+new Date().getTime()+fileName);
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is=mf.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while((temp=is.read())!=(-1))
            {
                os.write(temp);
            }
            os.flush();
            os.close();
            is.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        //文件回显示和相对路径回传

        FileMV mv = new FileMV();

        return mv;


    }

}
