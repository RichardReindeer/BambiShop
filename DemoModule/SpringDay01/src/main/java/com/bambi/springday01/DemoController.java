package com.bambi.springday01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/8/27 13:42    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */
@RestController
public class DemoController {

    /**
     * 测试使用@Value注解给元素动态赋值
     */

    @Value("${bambi.username}")
    private String username;

    @GetMapping("/")
    public String demo(){
        return username;
    }
}
