package com.slice_file.demo.controller;

import lombok.Cleanup;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @ClassName FileController
 * @Description 文件上传的接口入口
 * @Author lcz
 * @Date 2020/01/15 09:28
 */
@RestController
@RequestMapping("/file")
public class FileController {

    /**
     * 上传分块文件操作
     *
     * @throws IOException
     */
    @PostMapping(value = "/uploadSingle")
    public ResponseEntity uploadSingle(HttpServletRequest request, MultipartFile file, String index) throws IOException {
        File localFile = new File(index);
        FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(localFile));
        return ResponseEntity.ok("success");
    }

    /**
     * 合并文件
     */
    @PostMapping(value = "/mergeFile")
    public ResponseEntity mergeFile(HttpServletRequest request, String fileName) {
        File[] file = new File[10];

        /*获取上传的文件，更具自己的业务实际修改这段代码*/
        for (int i = 0; i < 10; i++) {
            file[i] = new File(String.valueOf(i));
        }


        try {
            @Cleanup
            FileChannel channel = new FileOutputStream(fileName, true).getChannel();
            for (int i = 0; i < 10; i++) {
                @Cleanup
                FileChannel fileChannel = new FileInputStream(file[i]).getChannel();
                channel.transferFrom(fileChannel, channel.size(), fileChannel.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("success");
    }
}
