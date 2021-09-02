package com.bambi.domain.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

/**
 * 描述：商品类表
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/9/2 0:43    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */
@ApiModel("商品实体类")
@JsonIgnoreProperties(ignoreUnknown = true) //表示JSON转化时忽略未知属性
@TableName("tb_item")
public class ItemDao extends BaseDao {

    //商品id
    @TableId(type = IdType.AUTO)
    private Long id;
    //商品标题
    private String title;
    //商品卖点信息
    private String sellPoint;
    //商品价格 long > dubbo
    private Long price;
    //商品数量
    private Integer num;
    //条形码
    private String barcode;
    //商品图片 1jpg,2jpg,3jpg
    private String image;
    //商品分类id
    private Long cid;
    //商品状态 1正常 2下架
    private Integer status;

    /**
     * 为了满足页面展示效果编写的方法
     *
     * @return
     */
    public String[] getImages() {
        return image.split(",");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
