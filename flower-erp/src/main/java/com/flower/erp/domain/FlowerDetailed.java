package com.flower.erp.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.flower.common.annotation.Excel;
import com.flower.common.core.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)对象 flower_detailed
 * 
 * @author wxs
 * @date 2022-03-08
 */
public class FlowerDetailed extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private String id;

    /** 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰 */
    @Excel(name = "花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰")
    private String type;

    /** 花的颜色：红橙黄绿等 */
    @Excel(name = "花的颜色：红橙黄绿等")
    private String color;

    /** 花的科属ID */
    @Excel(name = "花的科属ID")
    private String ascriptionId;

    /** 花的品种ID */
    @Excel(name = "花的品种ID")
    private String varietiesId;

    /** 创建者 */
    @Excel(name = "创建者")
    private String creator;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDatetime;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyDatetime;

    /** 图片 */
    @Excel(name = "图片")
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setColor(String color) 
    {
        this.color = color;
    }

    public String getColor() 
    {
        return color;
    }
    public void setAscriptionId(String ascriptionId) 
    {
        this.ascriptionId = ascriptionId;
    }

    public String getAscriptionId() 
    {
        return ascriptionId;
    }
    public void setVarietiesId(String varietiesId) 
    {
        this.varietiesId = varietiesId;
    }

    public String getVarietiesId() 
    {
        return varietiesId;
    }
    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }
    public void setCreateDatetime(Date createDatetime) 
    {
        this.createDatetime = createDatetime;
    }

    public Date getCreateDatetime() 
    {
        return createDatetime;
    }
    public void setModifyDatetime(Date modifyDatetime) 
    {
        this.modifyDatetime = modifyDatetime;
    }

    public Date getModifyDatetime() 
    {
        return modifyDatetime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("color", getColor())
            .append("ascriptionId", getAscriptionId())
            .append("varietiesId", getVarietiesId())
            .append("creator", getCreator())
            .append("img", getImg())
            .append("createDatetime", getCreateDatetime())
            .append("modifyDatetime", getModifyDatetime())
            .toString();
    }
}
