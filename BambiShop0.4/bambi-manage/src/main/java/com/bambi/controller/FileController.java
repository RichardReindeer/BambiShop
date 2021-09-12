package com.bambi.controller;

import io.swagger.annotations.ApiModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 描述：文件上传控制器层
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/9/5 3:10    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */
@ApiModel("文件上传")
@RestController
public class FileController {
    private static Logger logger = LoggerFactory.getLogger(FileController.class);
    @PostMapping("/file")
    public String file (MultipartFile fileImage) throws IOException {
        String fileDir = "E:/TrueIDEA/BambiShop/images";
        File file = new File(fileDir);
        if(!file.exists()){
            logger.info("没有找到当前文件夹");
            file.mkdir();
        }
        String fileImageName = fileImage.getName();
        logger.info("这是传递过来的fileImage的名字：{}",fileImageName);
        String originalFilename = fileImage.getOriginalFilename();
        logger.info("这是传递过来的fileImage的名字：{}",originalFilename);
        String realPath = fileDir+"/"+originalFilename;
        fileImage.transferTo(new File(realPath));
        return "文件上传成功";
    }
}
