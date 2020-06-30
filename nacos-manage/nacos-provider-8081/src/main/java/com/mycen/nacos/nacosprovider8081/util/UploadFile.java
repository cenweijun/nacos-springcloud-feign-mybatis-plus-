package com.mycen.nacos.nacosprovider8081.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RequestMapping("/upload")
@RestController
public class UploadFile {


    @PostMapping("/banner")
    public String GGupload(MultipartFile file) {
        if (file.isEmpty()) {
            System.out.println("文件为空");
        }
//        String fileName = file.getOriginalFilename();  // 文件名
//        assert fileName != null;
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
//        fileName = System.currentTimeMillis() + suffixName;
        String filePath="F:\\Demo_Goods_File\\image\\";
//        String filePath = null;
//        try {
//            filePath = ResourceUtils.getURL("classpath:").getPath() + "static/files/";
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        // 上传后的路径
        File dest = new File(filePath + file);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件路径："+filePath+file);
        return filePath+file;
//        String relativePath = null;
//        if (!StringUtils.isBlank(filePath)) {
//            relativePath = filePath.substring(filePath.lastIndexOf("/files"));
//        }
//        return relativePath + fileName;
    }

    @PostMapping("/video")
    public String videoUpload(MultipartFile file) {
        if (file.isEmpty()) {
            System.out.println("文件为空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        assert fileName != null;
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        fileName = System.currentTimeMillis() + suffixName;
        String filePath = null;
        try {
            filePath = ResourceUtils.getURL("classpath:").getPath() + "static/information/";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 上传后的路径
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String relativePath = null;
        if (!StringUtils.isBlank(filePath)) {
            relativePath = filePath.substring(filePath.lastIndexOf("/information"));
        }
        return relativePath + fileName;
    }
}
