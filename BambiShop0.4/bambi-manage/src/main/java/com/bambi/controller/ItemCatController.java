package com.bambi.controller;

import com.bambi.domain.param.EasyUITree;
import com.bambi.service.impl.ItemCatServiceImpl;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 描述：ItemCat控制器层
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/9/2 17:21    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */
@ApiModel("itemCat控制器层代码")
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
    private static Logger logger = LoggerFactory.getLogger(ItemCatController.class);

    @Autowired
    private ItemCatServiceImpl itemCatService;

    /**
     * 根据id查询分类名称，如果不输入id则不查询
     */
    @ApiOperation("根据id查询分类名称")
    @RequestMapping("/queryItemName")
    public String queryCatById(Long itemCatId){
        logger.info("QueryCatById start!!!");
        if(itemCatId==null){
            logger.error("没有接收到对应的ItemCatId");
            return "redirect:/item/cat/queryAll";
        }
        return itemCatService.queryCatById(itemCatId);
    }

    @ApiOperation("查询全部分类名称")
    @RequestMapping("/queryAll")
    @ResponseBody
    public List<String> queryAll(){
        logger.info("正在查询全部信息");
        List<String> stringList = itemCatService.queryAll();
        return stringList;
    }

    /**
     * 如果不传入id值则默认为0 即默认为一级目录
     * @param parentId
     * @return
     */
    @ApiOperation("提供easyUI进行列表展示所需的分类")
    @RequestMapping("/list")
    public List<EasyUITree> findItemCatByParentId(@RequestParam(defaultValue = "0",name = "id") Long parentId){
        logger.info("findCatByParentId starting");
        return itemCatService.findItemCatByParentId(parentId);
    }
}
