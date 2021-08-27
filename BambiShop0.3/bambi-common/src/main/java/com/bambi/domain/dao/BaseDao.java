package com.bambi.domain.dao;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 描述：数据库实体类基础类 创建时间 生成时间
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/8/27 2:17    Bambi        Create
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
