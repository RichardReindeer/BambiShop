package com.bambi.springday02jsp.mapper;

import com.bambi.springday02jsp.domain.dao.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 描述：
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/8/27 15:06    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
