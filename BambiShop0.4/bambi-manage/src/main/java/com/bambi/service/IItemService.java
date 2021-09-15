package com.bambi.service;

import com.bambi.domain.dao.ItemDao;
import com.bambi.domain.dao.ItemDesc;
import com.bambi.domain.param.EasyUITable;
import org.springframework.stereotype.Service;

/**
 * 描述：商品表相关业务逻辑层代码
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/9/2 0:53    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */
public interface IItemService {

    EasyUITable findUserByPage(Integer page, Integer rows);

    void saveItem(ItemDao itemDao, ItemDesc itemDesc);

    ItemDesc findItemDescById(Long itemId);

    void updateItem(ItemDao itemDao, ItemDesc itemDesc);

    void deleteItems(Long[] ids);

    void updateStatus(Long[] ids, int status);
}
