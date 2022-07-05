package com.flower.erp.service;

import java.util.List;
import com.flower.erp.domain.FlowerVarieties;

/**
 * 花的品种：玫瑰、百合等等(二级分类)Service接口
 * 
 * @author wxs
 * @date 2022-03-08
 */
public interface IFlowerVarietiesService 
{
    /**
     * 查询花的品种：玫瑰、百合等等(二级分类)
     * 
     * @param id 花的品种：玫瑰、百合等等(二级分类)主键
     * @return 花的品种：玫瑰、百合等等(二级分类)
     */
    public FlowerVarieties selectFlowerVarietiesById(String id);

    /**
     * 查询花的品种：玫瑰、百合等等(二级分类)列表
     * 
     * @param flowerVarieties 花的品种：玫瑰、百合等等(二级分类)
     * @return 花的品种：玫瑰、百合等等(二级分类)集合
     */
    public List<FlowerVarieties> selectFlowerVarietiesList(FlowerVarieties flowerVarieties);

    /**
     * 新增花的品种：玫瑰、百合等等(二级分类)
     * 
     * @param flowerVarieties 花的品种：玫瑰、百合等等(二级分类)
     * @return 结果
     */
    public int insertFlowerVarieties(FlowerVarieties flowerVarieties);

    /**
     * 修改花的品种：玫瑰、百合等等(二级分类)
     * 
     * @param flowerVarieties 花的品种：玫瑰、百合等等(二级分类)
     * @return 结果
     */
    public int updateFlowerVarieties(FlowerVarieties flowerVarieties);

    /**
     * 批量删除花的品种：玫瑰、百合等等(二级分类)
     * 
     * @param ids 需要删除的花的品种：玫瑰、百合等等(二级分类)主键集合
     * @return 结果
     */
    public int deleteFlowerVarietiesByIds(String[] ids);

    /**
     * 删除花的品种：玫瑰、百合等等(二级分类)信息
     * 
     * @param id 花的品种：玫瑰、百合等等(二级分类)主键
     * @return 结果
     */
    public int deleteFlowerVarietiesById(String id);
}
