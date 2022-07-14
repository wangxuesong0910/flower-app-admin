package com.flower.erp.service.impl;

import java.util.Date;
import java.util.List;

import com.flower.common.utils.SecurityUtils;
import com.flower.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flower.erp.mapper.FlowerVarietiesMapper;
import com.flower.erp.domain.FlowerVarieties;
import com.flower.erp.service.IFlowerVarietiesService;

/**
 * 花的品种：玫瑰、百合等等(二级分类)Service业务层处理
 * 
 * @author wxs
 * @date 2022-03-08
 */
@Service
public class FlowerVarietiesServiceImpl implements IFlowerVarietiesService 
{
    @Autowired
    private FlowerVarietiesMapper flowerVarietiesMapper;

    /**
     * 查询花的品种：玫瑰、百合等等(二级分类)
     * 
     * @param id 花的品种：玫瑰、百合等等(二级分类)主键
     * @return 花的品种：玫瑰、百合等等(二级分类)
     */
    @Override
    public FlowerVarieties selectFlowerVarietiesById(String id)
    {
        return flowerVarietiesMapper.selectFlowerVarietiesById(id);
    }

    /**
     * 查询花的品种：玫瑰、百合等等(二级分类)列表
     * 
     * @param flowerVarieties 花的品种：玫瑰、百合等等(二级分类)
     * @return 花的品种：玫瑰、百合等等(二级分类)
     */
    @Override
    public List<FlowerVarieties> selectFlowerVarietiesList(FlowerVarieties flowerVarieties)
    {
        return flowerVarietiesMapper.selectFlowerVarietiesList(flowerVarieties);
    }

    /**
     * 新增花的品种：玫瑰、百合等等(二级分类)
     * 
     * @param flowerVarieties 花的品种：玫瑰、百合等等(二级分类)
     * @return 结果
     */
    @Override
    public int insertFlowerVarieties(FlowerVarieties flowerVarieties)
    {
        flowerVarieties.setId(IdUtils.fastSimpleUUID());
        flowerVarieties.setCreator(SecurityUtils.getUsername());
        flowerVarieties.setCreateDatetime(new Date());
        return flowerVarietiesMapper.insertFlowerVarieties(flowerVarieties);
    }

    /**
     * 修改花的品种：玫瑰、百合等等(二级分类)
     * 
     * @param flowerVarieties 花的品种：玫瑰、百合等等(二级分类)
     * @return 结果
     */
    @Override
    public int updateFlowerVarieties(FlowerVarieties flowerVarieties)
    {
        return flowerVarietiesMapper.updateFlowerVarieties(flowerVarieties);
    }

    /**
     * 批量删除花的品种：玫瑰、百合等等(二级分类)
     * 
     * @param ids 需要删除的花的品种：玫瑰、百合等等(二级分类)主键
     * @return 结果
     */
    @Override
    public int deleteFlowerVarietiesByIds(String[] ids)
    {
        return flowerVarietiesMapper.deleteFlowerVarietiesByIds(ids);
    }

    /**
     * 删除花的品种：玫瑰、百合等等(二级分类)信息
     * 
     * @param id 花的品种：玫瑰、百合等等(二级分类)主键
     * @return 结果
     */
    @Override
    public int deleteFlowerVarietiesById(String id)
    {
        return flowerVarietiesMapper.deleteFlowerVarietiesById(id);
    }
}
