package com.flower.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flower.erp.mapper.FlowerAscriptionMapper;
import com.flower.erp.domain.FlowerAscription;
import com.flower.erp.service.IFlowerAscriptionService;

/**
 * 鲜花的科属(一级分类)Service业务层处理
 * 
 * @author wxs
 * @date 2022-03-08
 */
@Service
public class FlowerAscriptionServiceImpl implements IFlowerAscriptionService 
{
    @Autowired
    private FlowerAscriptionMapper flowerAscriptionMapper;

    /**
     * 查询鲜花的科属(一级分类)
     * 
     * @param id 鲜花的科属(一级分类)主键
     * @return 鲜花的科属(一级分类)
     */
    @Override
    public FlowerAscription selectFlowerAscriptionById(String id)
    {
        return flowerAscriptionMapper.selectFlowerAscriptionById(id);
    }

    /**
     * 查询鲜花的科属(一级分类)列表
     * 
     * @param flowerAscription 鲜花的科属(一级分类)
     * @return 鲜花的科属(一级分类)
     */
    @Override
    public List<FlowerAscription> selectFlowerAscriptionList(FlowerAscription flowerAscription)
    {
        return flowerAscriptionMapper.selectFlowerAscriptionList(flowerAscription);
    }

    /**
     * 新增鲜花的科属(一级分类)
     * 
     * @param flowerAscription 鲜花的科属(一级分类)
     * @return 结果
     */
    @Override
    public int insertFlowerAscription(FlowerAscription flowerAscription)
    {
        return flowerAscriptionMapper.insertFlowerAscription(flowerAscription);
    }

    /**
     * 修改鲜花的科属(一级分类)
     * 
     * @param flowerAscription 鲜花的科属(一级分类)
     * @return 结果
     */
    @Override
    public int updateFlowerAscription(FlowerAscription flowerAscription)
    {
        return flowerAscriptionMapper.updateFlowerAscription(flowerAscription);
    }

    /**
     * 批量删除鲜花的科属(一级分类)
     * 
     * @param ids 需要删除的鲜花的科属(一级分类)主键
     * @return 结果
     */
    @Override
    public int deleteFlowerAscriptionByIds(String[] ids)
    {
        return flowerAscriptionMapper.deleteFlowerAscriptionByIds(ids);
    }

    /**
     * 删除鲜花的科属(一级分类)信息
     * 
     * @param id 鲜花的科属(一级分类)主键
     * @return 结果
     */
    @Override
    public int deleteFlowerAscriptionById(String id)
    {
        return flowerAscriptionMapper.deleteFlowerAscriptionById(id);
    }
}
