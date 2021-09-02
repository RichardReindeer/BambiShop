package com.bambi.controller;

import com.bambi.domain.SystemResult;
import com.bambi.domain.dao.ItemDao;
import com.bambi.domain.exception.NoParamFromWebException;
import com.bambi.domain.param.EasyUITable;
import com.bambi.service.impl.ItemServiceImpl;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@ApiModel("Item控制器层")
@RequestMapping("/item")
@RestController
public class ItemController {
    private static Logger logger = LoggerFactory.getLogger(ItemController.class);
    @Autowired
    private ItemServiceImpl itemService;

    @ApiOperation("根据传递过来的参数进行分页操作")
    @GetMapping("/query")
    public EasyUITable findItemByPage(Integer page, Integer rows) {

        try{
            if (page == null || rows == null) {
                logger.error("请求没有传递过来参数");
                throw new NoParamFromWebException("没有传递过来参数");
            }
            logger.info("go to sql ");
            return itemService.findUserByPage(page, rows);
        }catch (NoParamFromWebException e){
            logger.error("no param");
            return null;
        }
    }

    @ApiOperation("商品新增")
    @GetMapping("/save")
    public SystemResult saveItem(ItemDao itemDao){
        if(itemDao==null){
            logger.error("新增物品为空");
            return SystemResult.fail();
        }
        logger.info("save Item is starting !!!");
        try{
            itemService.saveItem(itemDao);
            return SystemResult.success();
        }
        catch (Exception e){
            logger.error("have some error in save Item = =");
            return SystemResult.fail();
        }

    }

}
