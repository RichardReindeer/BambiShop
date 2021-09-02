package com.bambi.service;

import com.bambi.domain.param.EasyUITree;

import java.util.List;

/**
 * 描述：ItemCat接口业务逻辑层
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
public interface IItemCatService {

    public String queryCatById(Long itemCatId);

    List<String> queryAll();

    List<EasyUITree> findItemCatByParentId(Long parentId);
}
