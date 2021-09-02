package com.bambi.service.impl;

import com.bambi.domain.dao.ItemCatDao;
import com.bambi.domain.param.EasyUITree;
import com.bambi.mapper.ItemCatMapper;
import com.bambi.service.IItemCatService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述： ItemCatService接口实现类
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/9/2 17:22    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */
@Service
public class ItemCatServiceImpl implements IItemCatService {
    private static Logger logger = LoggerFactory.getLogger(ItemCatServiceImpl.class);
    @Autowired
    private ItemCatMapper itemCatMapper;


    @Override
    public String queryCatById(Long itemCatId) {
        if(itemCatId==null){
            logger.info("没有获取到正确的itemCatId，正在全部查询");
            return "no right itemCatId";
        }
        ItemCatDao itemCatDao = itemCatMapper.selectById(itemCatId);
        return itemCatDao.getName();
    }

    @Override
    public List<String> queryAll() {
        logger.info("queryAll is starting!!!");
        List<ItemCatDao> itemCatDaos = itemCatMapper.selectList(null);
        List<String> itemCatNames  = new LinkedList<>();
        itemCatDaos.forEach(itemCatDao -> {
            itemCatNames.add(itemCatDao.getName());
        });
        return itemCatNames;
    }

    /**
     * 提供给页面的树形展示列表
     * 需要进行对象间转换，传递给前端的是EasyUITree , 查询的是ItemCat 字段间需要转换赋值
     *
     * 如果当前分类是父级别目录 ->即需要操作从而展开，所以默认是关闭的
     * 如果当前分类是子目录 ->则无法进行展开操作，即默认是展开的
     *
     * @param parentId
     * @return
     */
    @Override
    public List<EasyUITree> findItemCatByParentId(Long parentId) {
        return cover(parentId);
    }

    /**
     * 参数和dao对象间进行转换
     * @param parentId
     * @return
     */
    private List<EasyUITree> cover(Long parentId){
        logger.info("start to cover easyUItree and ItemCat");
        List<EasyUITree> easyUITrees = new LinkedList<>();
        List<ItemCatDao> itemCatDaos = selectByParentId(parentId);
        itemCatDaos.forEach(itemCatDao -> {
            Long id = itemCatDao.getId();
            String text = itemCatDao.getName();
            String state = itemCatDao.getParent()?"closed":"open";
            easyUITrees.add(new EasyUITree(id,text,state));
        });
        return easyUITrees;
    }

    /**
     * 使用MP 根据parentID查询对象
     * @param parentId
     * @return
     */
    private List<ItemCatDao> selectByParentId(Long parentId){
        QueryWrapper<ItemCatDao> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",parentId);
        return itemCatMapper.selectList(queryWrapper);
    }
}
