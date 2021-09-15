package com.bambi.service.impl;

import com.bambi.domain.dao.ItemDao;
import com.bambi.domain.dao.ItemDesc;
import com.bambi.domain.param.EasyUITable;
import com.bambi.mapper.ItemDescMapper;
import com.bambi.mapper.ItemMapper;
import com.bambi.service.IItemService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
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
    @Autowired
    private ItemDescMapper itemDescMapper;


    /**
     * 返回给前端前端想查看的数据
     *
     * @param page
     * @param rows
     * @return
     */
    @ApiOperation("根据页数和行数进行手动分页")
    @Override
    public EasyUITable findUserByPage(Integer page, Integer rows) {
        return findByPage(page, rows);
        //return findByMybatisPlusPage(page, rows);
    }

    @Transactional
    @ApiOperation("新增商品")
    @Override
    public void saveItem(ItemDao itemDao, ItemDesc itemDesc) {
        itemDao.setStatus(1);
        itemDao.setCreated(LocalDateTime.now());
        itemDao.setUpdated(itemDao.getCreated());
        mapper.insert(itemDao);

        itemDesc.setItemId(itemDao.getId());
        itemDesc.setUpdated(itemDao.getCreated());
        itemDesc.setCreated(itemDao.getCreated());
        itemDescMapper.insert(itemDesc);

    }

    @Override
    public ItemDesc findItemDescById(Long itemId) {
        return itemDescMapper.selectById(itemId);
    }

    @Override
    public void updateItem(ItemDao itemDao, ItemDesc itemDesc) {
        itemDao.setUpdated(LocalDateTime.now());
        mapper.updateById(itemDao);
        itemDesc.setItemId(itemDao.getId());
        itemDesc.setUpdated(itemDao.getUpdated());
        itemDescMapper.updateById(itemDesc);
    }

    @Override
    public void deleteItems(Long[] ids) {
        //需要转换成数组
        logger.info("开始批量删除");
        List<Long> longs = Arrays.asList(ids);
        mapper.deleteBatchIds(longs);
        itemDescMapper.deleteBatchIds(longs);
    }

    @Override
    public void updateStatus(Long[] ids, int status) {
        ItemDao itemDao = new ItemDao();
        itemDao.setStatus(status);
        itemDao.setUpdated(LocalDateTime.now());
        UpdateWrapper<ItemDao> updateWrapper = new UpdateWrapper<>();
        List<Long> longs = Arrays.asList(ids);
        updateWrapper.in("id", longs);
        mapper.update(itemDao, updateWrapper);

    }

    /**
     * 使用MybatisPlus进行分页操作
     * 声明Page对象，并赋予泛型
     * 设置每页展示的行数，默认是10
     * 设置当前页，默认是1
     * @param page 起始页页数
     * @param rows 展示数据的行数
     * @return
     */
    private EasyUITable findByMybatisPlusPage(Integer page, Integer rows) {
        logger.info("使用mybatisPlus分页操作");
        IPage<ItemDao> itemDaoIPage = new Page<>();
        itemDaoIPage.setSize(rows);
        itemDaoIPage.setCurrent(page); //设置当前页，当前页为传递过来的页数
        QueryWrapper<ItemDao> queryWrapper = new QueryWrapper<ItemDao>();
        queryWrapper.orderByDesc("updated");
        IPage<ItemDao> itemIPage = mapper.selectPage(itemDaoIPage, queryWrapper);
        int total = (int) itemIPage.getTotal();
        List<ItemDao> records = itemIPage.getRecords();
        return new EasyUITable(total, records);
    }

    @Deprecated
    private EasyUITable findByPage(Integer page, Integer rows) {
        logger.info("使用手动分页");
        Integer selectCount = mapper.selectCount(null);
        int start = (page - 1) * rows;
        List<ItemDao> itemByPage = mapper.findItemByPage(start, rows);
        return new EasyUITable(selectCount, itemByPage);
    }


}
