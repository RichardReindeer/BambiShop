package com.bambi.domain.param;

import com.bambi.domain.dao.ItemDao;

import java.util.List;

/**
 * 描述：由于商品列表展现,需要使用 EasyUI 中的表格进行展现,所以展现的规则应该满足
 * EasyUI 的条件
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/9/2 1:11    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */
public class EasyUITable {

    //记录的总条数
    private Integer total;
    //记录的信息
    private List<ItemDao> rows;

    public EasyUITable(Integer total, List<ItemDao> rows) {
        this.total = total;
        this.rows = rows;
    }

    public EasyUITable() {
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<ItemDao> getRows() {
        return rows;
    }

    public void setRows(List<ItemDao> rows) {
        this.rows = rows;
    }
}
