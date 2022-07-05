package com.flower.erp.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.flower.common.annotation.Excel;
import com.flower.common.core.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 鲜花的仓储信息单对象 flower_storage
 * 
 * @author wxs
 * @date 2022-03-08
 */
public class FlowerStorage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** 花的种类ID */
    @Excel(name = "花的种类")
    private String type;

    /** 花的档次：低中高... */
    @Excel(name = "花的档次：低中高...")
    private String grade;

    /** 花的状态：花苞、开花 */
    @Excel(name = "花的状态：花苞、开花")
    private Integer status;

    /** 花的进货价 */
    @Excel(name = "花的进货价")
    private BigDecimal buyingPrice;

    /** 花的出货价 */
    @Excel(name = "花的出货价")
    private BigDecimal exportPrice;

    /** 花的折扣价 */
    @Excel(name = "花的折扣价")
    private BigDecimal discountPrice;

    /** 花的仓储状态：0:未入库|1:已入库|2:已出库|3:已损坏|4:已拆分 */
    @Excel(name = "花的仓储状态：0:未入库|1:已入库|2:已出库|3:已损坏|4:已拆分")
    private Integer storageStatus;

    /** 花的入库时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "花的入库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date enterDatetime;

    /** 花的出库时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "花的出库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date takeoutDatetime;

    /** 花的批发方式：扎、捆、支、束... */
    @Excel(name = "花的批发方式：扎、捆、支、束...")
    private String packaging;

    /** 数量 */
    @Excel(name = "数量")
    private Long quantity;

    /** 包含数量：例如一扎有多少支 */
    @Excel(name = "包含数量：例如一扎有多少支")
    private Long quantityIncluded;

    /** 如果一扎花拆分开卖，已经售卖了多少 */
    @Excel(name = "如果一扎花拆分开卖，已经售卖了多少")
    private Long salesQuantity;

    /** 售卖方式：0:拆分|1:整卖(如果sales_quantity为空就为整卖，不为空就是拆分卖) */
    @Excel(name = "售卖方式：0:拆分|1:整卖(如果sales_quantity为空就为整卖，不为空就是拆分卖)")
    private Integer modeOfSale;

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
    public void setGrade(String grade) 
    {
        this.grade = grade;
    }

    public String getGrade() 
    {
        return grade;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setBuyingPrice(BigDecimal buyingPrice) 
    {
        this.buyingPrice = buyingPrice;
    }

    public BigDecimal getBuyingPrice() 
    {
        return buyingPrice;
    }
    public void setExportPrice(BigDecimal exportPrice) 
    {
        this.exportPrice = exportPrice;
    }

    public BigDecimal getExportPrice() 
    {
        return exportPrice;
    }
    public void setDiscountPrice(BigDecimal discountPrice) 
    {
        this.discountPrice = discountPrice;
    }

    public BigDecimal getDiscountPrice() 
    {
        return discountPrice;
    }
    public void setStorageStatus(Integer storageStatus) 
    {
        this.storageStatus = storageStatus;
    }

    public Integer getStorageStatus() 
    {
        return storageStatus;
    }
    public void setEnterDatetime(Date enterDatetime) 
    {
        this.enterDatetime = enterDatetime;
    }

    public Date getEnterDatetime() 
    {
        return enterDatetime;
    }
    public void setTakeoutDatetime(Date takeoutDatetime) 
    {
        this.takeoutDatetime = takeoutDatetime;
    }

    public Date getTakeoutDatetime() 
    {
        return takeoutDatetime;
    }
    public void setPackaging(String packaging) 
    {
        this.packaging = packaging;
    }

    public String getPackaging() 
    {
        return packaging;
    }
    public void setQuantity(Long quantity) 
    {
        this.quantity = quantity;
    }

    public Long getQuantity() 
    {
        return quantity;
    }
    public void setQuantityIncluded(Long quantityIncluded) 
    {
        this.quantityIncluded = quantityIncluded;
    }

    public Long getQuantityIncluded() 
    {
        return quantityIncluded;
    }
    public void setSalesQuantity(Long salesQuantity) 
    {
        this.salesQuantity = salesQuantity;
    }

    public Long getSalesQuantity() 
    {
        return salesQuantity;
    }
    public void setModeOfSale(Integer modeOfSale) 
    {
        this.modeOfSale = modeOfSale;
    }

    public Integer getModeOfSale() 
    {
        return modeOfSale;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("grade", getGrade())
            .append("status", getStatus())
            .append("buyingPrice", getBuyingPrice())
            .append("exportPrice", getExportPrice())
            .append("discountPrice", getDiscountPrice())
            .append("storageStatus", getStorageStatus())
            .append("enterDatetime", getEnterDatetime())
            .append("takeoutDatetime", getTakeoutDatetime())
            .append("packaging", getPackaging())
            .append("quantity", getQuantity())
            .append("quantityIncluded", getQuantityIncluded())
            .append("salesQuantity", getSalesQuantity())
            .append("modeOfSale", getModeOfSale())
            .toString();
    }
}
