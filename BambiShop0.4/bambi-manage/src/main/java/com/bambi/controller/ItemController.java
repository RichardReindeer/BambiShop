package com.bambi.controller;

import com.bambi.domain.SystemResult;
import com.bambi.domain.dao.ItemDao;
import com.bambi.domain.dao.ItemDesc;
import com.bambi.domain.exception.NoParamFromWebException;
import com.bambi.domain.param.EasyUITable;
import com.bambi.service.IItemService;
import com.bambi.service.impl.ItemServiceImpl;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private IItemService itemService;

    @ApiOperation("根据传递过来的参数进行分页操作")
    @RequestMapping("/query")
    public EasyUITable findItemByPage(Integer page, Integer rows) {
        logger.info("go to sql ");
        return itemService.findUserByPage(page, rows);
    }

    /**
     * 为了保证接口的健壮性，要对异常进行预先处理
     *
     * @param itemDao
     * @param itemDesc
     * @return
     */
    @ApiOperation("商品新增")
    @RequestMapping("/save")
    public SystemResult saveItem(ItemDao itemDao, ItemDesc itemDesc) {
        if (itemDao == null || itemDesc == null) {
            logger.error("新增物品为空");
            return SystemResult.fail();
        }
        logger.info("save Item is starting !!!");
        itemService.saveItem(itemDao, itemDesc);
        return SystemResult.success();

    }

    @ApiOperation("查询商品详情信息")
    @RequestMapping("/query/item/desc/{itemId}")
    public SystemResult findItemDescById(@PathVariable Long itemId) {
        logger.info("selectItemDescById STARTING ");
        try {
            ItemDesc itemDesc = itemService.findItemDescById(itemId);
            return SystemResult.success(itemDesc);
        } catch (Exception e) {
            logger.error("has some error in findItemDescById");
            return SystemResult.fail();
        }
    }

    @ApiOperation("对商品进行修改操作")
    @RequestMapping("/update")
    public SystemResult updateItem(ItemDesc itemDesc, ItemDao itemDao) {
        itemService.updateItem(itemDao, itemDesc);
        return SystemResult.success();
    }

    @ApiOperation("商品删除")
    @RequestMapping("/delete")
    public SystemResult deleteItems(Long[] ids) {
        logger.info("接收到请求，开始执行删除操作");
        itemService.deleteItems(ids);
        return SystemResult.success();
    }

    @ApiOperation("商品下架")
    @RequestMapping("/instock")
    public SystemResult instockItems(Long[] ids) {
        int status = 2;
        itemService.updateStatus(ids, status);
        return SystemResult.success();
    }

    @ApiOperation("商品上架")
    @RequestMapping("/reshelf")
    public SystemResult reshIfItems(Long[] ids) {
        int status = 1;
        itemService.updateStatus(ids, status);
        return SystemResult.success();
    }

}
