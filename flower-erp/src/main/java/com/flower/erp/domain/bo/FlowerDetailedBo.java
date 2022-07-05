package com.flower.erp.domain.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.flower.common.annotation.Excel;

import java.util.Date;

//此Bo(业务对象) 包含了玫瑰花品种的详细页面字段信息，结合了：FlowerDetailed,FlowerVarieties,FlowerAscription
public class FlowerDetailedBo {
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


    /** 花的品种：玫瑰、百合等等 */
    @Excel(name = "花的品种：玫瑰、百合等等")
    private String varieties;

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

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyDatetime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAscriptionId() {
        return ascriptionId;
    }

    public void setAscriptionId(String ascriptionId) {
        this.ascriptionId = ascriptionId;
    }

    public String getVarietiesId() {
        return varietiesId;
    }

    public void setVarietiesId(String varietiesId) {
        this.varietiesId = varietiesId;
    }

    public String getVarieties() {
        return varieties;
    }

    public void setVarieties(String varieties) {
        this.varieties = varieties;
    }

    public String getAscription() {
        return ascription;
    }

    public void setAscription(String ascription) {
        this.ascription = ascription;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getModifyDatetime() {
        return modifyDatetime;
    }

    public void setModifyDatetime(Date modifyDatetime) {
        this.modifyDatetime = modifyDatetime;
    }

    @Override
    public String toString() {
        return "FlowerDetailedBo{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", ascriptionId='" + ascriptionId + '\'' +
                ", varietiesId='" + varietiesId + '\'' +
                ", varieties='" + varieties + '\'' +
                ", ascription='" + ascription + '\'' +
                ", creator='" + creator + '\'' +
                ", createDatetime=" + createDatetime +
                ", modifyDatetime=" + modifyDatetime +
                '}';
    }
}
