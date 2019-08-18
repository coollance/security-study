package com.coolance.web.controller;

import com.coolance.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @ClassName FileController
 * @Description 文件上传与下载
 * @Author Coolance
 * @Version
 * @Date 2019/8/18 7:32
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private String folder = "D:\\coollance\\coolance-security\\coolance-security-demo";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws Exception {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        File localFile = new File(folder, System.currentTimeMillis() + ".txt");
        System.out.println(localFile.getAbsolutePath());
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable("id") String id, HttpServletResponse response) throws Exception {
        try(InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
            OutputStream outputStream = response.getOutputStream()) {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=test.txt");
            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        }

    }
}
