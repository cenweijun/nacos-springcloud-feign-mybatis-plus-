package com.mycen.nacos.nacosprovider8081.controller;

import com.mycen.nacos.nacosprovider8081.util.FileUploadUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file/")
@CrossOrigin

public class FileController {
    @PostMapping(value = "upload")
    // 此处的@RequestParam中的file名应与前端upload组件中的name的值保持一致
    public String upload(@RequestParam("file") MultipartFile multipartFile) {
        // replaceAll 用来替换windows中的\\ 为 /
        return FileUploadUtil.upload(multipartFile).replaceAll("\\\\", "/");
    }
}
