package com.flower.erp.service.impl;

import java.util.List;

import com.flower.erp.domain.bo.FlowerDetailedBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flower.erp.mapper.FlowerDetailedMapper;
import com.flower.erp.domain.FlowerDetailed;
import com.flower.erp.service.IFlowerDetailedService;

/**
 * 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)Service业务层处理
 * 
 * @author wxs
 * @date 2022-03-08
 */
@Service
public class FlowerDetailedServiceImpl implements IFlowerDetailedService 
{
    @Autowired
    private FlowerDetailedMapper flowerDetailedMapper;

    /**
     * 查询花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * 
     * @param id 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)主键
     * @return 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     */
    @Override
    public FlowerDetailed selectFlowerDetailedById(String id)
    {
        return flowerDetailedMapper.selectFlowerDetailedById(id);
    }

    /**
     * 查询花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)列表
     * 
     * @param flowerDetailed 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * @return 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     */
    @Override
    public List<FlowerDetailed> selectFlowerDetailedList(FlowerDetailed flowerDetailed)
    {
        return flowerDetailedMapper.selectFlowerDetailedList(flowerDetailed);
    }

    /**
     * 新增花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * 
     * @param flowerDetailed 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * @return 结果
     */
    @Override
    public int insertFlowerDetailed(FlowerDetailed flowerDetailed)
    {
        return flowerDetailedMapper.insertFlowerDetailed(flowerDetailed);
    }

    /**
     * 修改花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * 
     * @param flowerDetailed 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * @return 结果
     */
    @Override
    public int updateFlowerDetailed(FlowerDetailed flowerDetailed)
    {
        return flowerDetailedMapper.updateFlowerDetailed(flowerDetailed);
    }

    /**
     * 批量删除花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * 
     * @param ids 需要删除的花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)主键
     * @return 结果
     */
    @Override
    public int deleteFlowerDetailedByIds(String[] ids)
    {
        return flowerDetailedMapper.deleteFlowerDetailedByIds(ids);
    }

    /**
     * 删除花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)信息
     * 
     * @param id 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)主键
     * @return 结果
     */
    @Override
    public int deleteFlowerDetailedById(String id)
    {
        return flowerDetailedMapper.deleteFlowerDetailedById(id);
    }


    /**
     * 查询花的种类，科属，二级分类
     * @param flowerDetailed 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * @return 结果
     */
    @Override
    public List<FlowerDetailedBo> selectFlowerDetailedBo(FlowerDetailed flowerDetailed){
       return flowerDetailedMapper.selectFlowerDetailedBo(flowerDetailed);
    }

    /**
     * 根据条件查询花的种类type
     * @param type 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * @return 结果
     */
    public List<String> selectFlowerDetailedType(String type){
        return flowerDetailedMapper.selectFlowerDetailedType(type);
    }
}
