package com.flower.erp.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.flower.common.annotation.Excel;
import com.flower.common.core.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 鲜花的科属(一级分类)对象 flower_ascription
 * 
 * @author wxs
 * @date 2022-03-08
 */
public class FlowerAscription extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** uuid */
    private String id;

    /** 科属 */
    @Excel(name = "科属")
    private String ascription;

    /** 创建者 */
    @Excel(name = "创建者")
    private String creator;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDatetime;

    /** 最后修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyDatetime;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setAscription(String ascription) 
    {
        this.ascription = ascription;
    }

    public String getAscription() 
    {
        return ascription;
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
            .append("ascription", getAscription())
            .append("creator", getCreator())
            .append("createDatetime", getCreateDatetime())
            .append("modifyDatetime", getModifyDatetime())
            .toString();
    }
}
