package com.bambi.domain.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

/**
 * 描述：
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/8/27 2:18    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */
/*表示JSON转化时忽略未知属性*/
@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("tb_item")
public class Item extends BaseDao{

    @TableId(type=IdType.AUTO)
    private long id;
    private String title;			//商品标题
    private String sellPoint;		//商品卖点信息
    private Long   price;			//商品价格 Long > dubbo
    private Integer num;			//商品数量
    private String barcode;			//条形码
    private String image;			//商品图片信息   1.jpg,2.jpg,3.jpg
    private Long   cid;				//表示商品的分类id
    private Integer status;			//1正常，2下架

    /**
     * 页面调用需要，创建get方法
     * @return
     */
    public  String[] getImages(){
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
