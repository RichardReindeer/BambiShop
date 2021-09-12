package com.bambi.service;

import com.bambi.domain.dao.UserDao;

import java.util.List;

/**
 * 描述：
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/9/12 23:42    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */

public interface IUserService {
    List<UserDao> findAll();
}
