package com.bambi.domain.dao;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 描述：dao基类，完成2个任务，2个日期，实现序列化
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/9/2 0:38    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */
public class BaseDao implements Serializable {
    private static final long serialVersionUID = 1l;
    private LocalDateTime created;
    private LocalDateTime updated;
}
