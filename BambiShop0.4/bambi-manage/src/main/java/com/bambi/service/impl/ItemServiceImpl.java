package com.bambi.service.impl;

import com.bambi.mapper.ItemMapper;
import com.bambi.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class ItemServiceImpl implements IItemService {

    @Autowired
    private ItemMapper mapper;

    public void findUserByPage(Integer page, Integer rows){
        //mapper.selectMapsPage();

    }
}
