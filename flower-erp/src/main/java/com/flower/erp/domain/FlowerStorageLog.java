package com.flower.erp.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.flower.common.annotation.Excel;
import com.flower.common.core.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 出入库操作日志记录对象 flower_storage_log
 * 
 * @author wxs
 * @date 2022-07-22
 */
public class FlowerStorageLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 库存id */
    @Excel(name = "库存id")
    private String storageId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /** 三级分类 */
    @Excel(name = "三级分类")
    private String type;

    /** 入库/出库 */
    @Excel(name = "入库/出库")
    private String inOut;

    /** 出入库数量 */
    @Excel(name = "出入库数量")
    private Long num;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createDatetime;

    /** 出库状态：正常出库；损坏出库 */
    @Excel(name = "出库状态：正常出库；损坏出库")
    private String outStatus;

    /** 出库状态：正常出库；损坏出库 */
    @Excel(name = "出入库操作人")
    private String createBy;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStorageId(String storageId) 
    {
        this.storageId = storageId;
    }

    public String getStorageId() 
    {
        return storageId;
    }
    public void setInOut(String inOut) 
    {
        this.inOut = inOut;
    }

    public String getInOut() 
    {
        return inOut;
    }
    public void setNum(Long num) 
    {
        this.num = num;
    }

    public Long getNum() 
    {
        return num;
    }
    public void setCreateDatetime(Date createDatetime) 
    {
        this.createDatetime = createDatetime;
    }

    public Date getCreateDatetime() 
    {
        return createDatetime;
    }
    public void setOutStatus(String outStatus) 
    {
        this.outStatus = outStatus;
    }

    public String getOutStatus() 
    {
        return outStatus;
    }

    @Override
    public String getCreateBy() {
        return createBy;
    }

    @Override
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("storageId", getStorageId())
            .append("type", getType())
            .append("inOut", getInOut())
            .append("num", getNum())
            .append("createDatetime", getCreateDatetime())
            .append("outStatus", getOutStatus())
            .append("createBy", getCreateBy())
            .toString();
    }
}
