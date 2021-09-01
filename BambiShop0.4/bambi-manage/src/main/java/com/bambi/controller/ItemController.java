package com.bambi.controller;

import com.bambi.domain.param.EasyUITable;
import com.bambi.service.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述：商品类控制层
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/9/2 1:06    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */
@RequestMapping("/item")
@Controller
public class ItemController {

    @Autowired
    private ItemServiceImpl itemService;

    @GetMapping("/query")
    public EasyUITable findItemByPage(Integer page , Integer rows) {
        itemService.findUserByPage(page,rows);
        return null;
    }
}
