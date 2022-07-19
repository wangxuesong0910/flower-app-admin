package com.flower.erp.service;

import java.util.List;
import java.util.Map;

import com.flower.common.core.page.TableDataInfo;
import com.flower.erp.domain.FlowerDetailed;
import com.flower.erp.domain.bo.FlowerDetailedBo;

/**
 * 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)Service接口
 * 
 * @author wxs
 * @date 2022-03-08
 */
public interface IFlowerDetailedService 
{
    /**
     * 查询花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * 
     * @param id 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)主键
     * @return 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     */
    public FlowerDetailed selectFlowerDetailedById(String id);

    /**
     * 查询花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)列表
     * 
     * @param flowerDetailed 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * @return 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)集合
     */
    public List<FlowerDetailed> selectFlowerDetailedList(FlowerDetailed flowerDetailed);

    /**
     * 新增花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * 
     * @param flowerDetailed 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * @return 结果
     */
    public int insertFlowerDetailed(FlowerDetailed flowerDetailed);

    /**
     * 修改花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * 
     * @param flowerDetailed 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * @return 结果
     */
    public int updateFlowerDetailed(FlowerDetailed flowerDetailed);

    /**
     * 批量删除花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * 
     * @param ids 需要删除的花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)主键集合
     * @return 结果
     */
    public int deleteFlowerDetailedByIds(String[] ids);

    /**
     * 删除花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)信息
     * 
     * @param id 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)主键
     * @return 结果
     */
    public int deleteFlowerDetailedById(String id);

    /**
     * 查询花的种类，科属，二级分类
     * @param flowerDetailed 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * @return 结果
     */
    public List<FlowerDetailedBo> selectFlowerDetailedBo(FlowerDetailed flowerDetailed);

    /**
     * 根据条件查询花的种类type
     * @param type 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * @return 结果
     */
    public List<String> selectFlowerDetailedType(String type);

    public List<Map<String,Object>> appDetailSelectList();
}
