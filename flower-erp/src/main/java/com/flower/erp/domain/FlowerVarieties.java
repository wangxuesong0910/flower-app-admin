package com.flower.erp.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.flower.common.annotation.Excel;
import com.flower.common.core.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 花的品种：玫瑰、百合等等(二级分类)对象 flower_varieties
 * 
 * @author wxs
 * @date 2022-03-08
 */
public class FlowerVarieties extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** 花的品种：玫瑰、百合等等 */
    @Excel(name = "花的品种：玫瑰、百合等等")
    private String varieties;

    /** 创建者 */
    @Excel(name = "创建者")
    private String creator;

    /** 花的科属ID */
    @Excel(name = "花的科属ID")
    private String ascriptionId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDatetime;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyDatetime;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setVarieties(String varieties) 
    {
        this.varieties = varieties;
    }

    public String getVarieties() 
    {
        return varieties;
    }
    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }
    public void setAscriptionId(String ascriptionId) 
    {
        this.ascriptionId = ascriptionId;
    }

    public String getAscriptionId() 
    {
        return ascriptionId;
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
            .append("varieties", getVarieties())
            .append("creator", getCreator())
            .append("ascriptionId", getAscriptionId())
            .append("createDatetime", getCreateDatetime())
            .append("modifyDatetime", getModifyDatetime())
            .toString();
    }
}
