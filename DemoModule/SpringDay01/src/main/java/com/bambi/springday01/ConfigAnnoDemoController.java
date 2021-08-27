package com.bambi.springday01;

import com.bambi.springday01.domain.dao.DisConf;
import com.bambi.springday01.domain.dao.Reindeer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述：测试 ConfigurationProperties注解
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/8/27 13:52    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */
@RestController()
@RequestMapping("/config")
public class ConfigAnnoDemoController {
    private static Logger logger = LoggerFactory.getLogger(ConfigAnnoDemoController.class);
    @Resource
    private Reindeer reindeer;

    @Resource
    private DisConf disConf;


    @GetMapping("/reindeer")
    @ResponseBody
    public String reindeer() {
        logger.info("被执行");
        return reindeer.getDataTime();
    }

    @GetMapping("/user")
    @ResponseBody
    public String user() {
        return disConf.getName();
    }
}
