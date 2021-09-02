package com.bambi.domain.param;

import java.io.Serializable;

/**
 * 描述：用于商品分类树形展现
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/9/3 1:12    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */
public class EasyUITree implements Serializable {
    private static long serialVersionUID=1l;

    //节点的id信息
    private Long id;
    //节点的名称
    private String text;
    //节点的状态(open / close)
    private String state;

    public EasyUITree(Long id, String text, String state) {
        this.id = id;
        this.text = text;
        this.state = state;
    }

    public EasyUITree() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        EasyUITree.serialVersionUID = serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
