package com.bambi.mapper;

import com.bambi.domain.dao.ItemDao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 描述：MP查询代码
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
@Mapper
public interface ItemMapper extends BaseMapper<ItemDao> {

    @Select("SELECT * FROM tb_item ORDER BY updated desc limit #{start},#{rows}")
    List<ItemDao> findItemByPage(int start , int rows);
}
