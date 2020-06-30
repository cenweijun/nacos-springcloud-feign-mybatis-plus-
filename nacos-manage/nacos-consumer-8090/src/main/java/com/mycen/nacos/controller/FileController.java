package com.mycen.nacos.controller;


import com.mycen.nacos.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file/")
@CrossOrigin
public class FileController {

    @Autowired
    private Client client;

    //文件上传
    @PostMapping (value = "upload")
    public String upload(@RequestParam("file") MultipartFile file){
        return  client.upload(file);
    }


}
