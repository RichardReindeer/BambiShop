package com.bambi.controller;

import io.swagger.annotations.ApiModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("/file")
    public String file (MultipartFile fileImage){
        String fileDir = ""
    }
}
