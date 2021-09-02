package com.bambi.service.impl;

import com.bambi.domain.dao.ItemDao;
import com.bambi.domain.param.EasyUITable;
import com.bambi.mapper.ItemMapper;
import com.bambi.service.IItemService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：业务逻辑层实现类
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/9/2 0:54    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */
@ApiModel("item表业务逻辑层实现类")
@Service
public class ItemServiceImpl implements IItemService {
    private static Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemMapper mapper;

    /**
     * 返回给前端前端想查看的数据
     *
     * @param page
     * @param rows
     * @return
     */
    @ApiOperation("根据页数和行数进行手动分页")
    public EasyUITable findUserByPage(Integer page, Integer rows) {
        //return findByPage(page, rows);
        return findByMybatisPlusPage(page,rows);
    }

    private EasyUITable findByMybatisPlusPage(Integer page,Integer rows){
        logger.info("使用mybatisPlus分页操作");

        try {
            //创建分页，传入参数为分页的条数和页数
            Page<ItemDao> itemDaoPage = new Page<>(page,rows);
            QueryWrapper<ItemDao> queryWrapper = new QueryWrapper<>();
            queryWrapper.orderByDesc("updated");
            Page<ItemDao> itemDaoIPage = mapper.selectPage(itemDaoPage, queryWrapper);
            int total =(int) itemDaoIPage.getTotal();
            List<ItemDao> records = itemDaoIPage.getRecords();
            return new EasyUITable(total,records);
        }catch (Exception e){
            logger.error("has some error in mybatisPlusPage()");
            return null;
        }finally {
            logger.info("mybatisPlus分页操作执行完毕");
        }

    }

    private EasyUITable findByPage(Integer page, Integer rows) {
        logger.info("使用手动分页");
        Integer selectCount = mapper.selectCount(null);
        int start = (page - 1) * rows;
        List<ItemDao> itemByPage = mapper.findItemByPage(start, rows);
        return new EasyUITable(selectCount, itemByPage);
    }
}
