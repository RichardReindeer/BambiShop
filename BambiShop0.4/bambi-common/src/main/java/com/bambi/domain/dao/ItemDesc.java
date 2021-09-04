package com.bambi.domain.dao;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 描述： 为了加快商品查询速度，准备两张表 tb_item 和tb_item_desc
 *  此为itemDesc的实体类
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/9/5 1:35    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */
@TableName("tb_item_desc")
public class ItemDesc extends BaseDao{
    //tb_item中的id与desc中的id一致
    @TableId
    private Long itemId;
    //详情信息
    private String itemDesc;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
}
