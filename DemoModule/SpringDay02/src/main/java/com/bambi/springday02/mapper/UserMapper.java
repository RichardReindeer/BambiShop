package com.bambi.springday02.mapper;

import com.bambi.springday02.domain.dao.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

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
