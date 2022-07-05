package com.flower.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flower.erp.mapper.FlowerStorageMapper;
import com.flower.erp.domain.FlowerStorage;
import com.flower.erp.service.IFlowerStorageService;

/**
 * 鲜花的仓储信息单Service业务层处理
 * 
 * @author wxs
 * @date 2022-03-08
 */
@Service
public class FlowerStorageServiceImpl implements IFlowerStorageService 
{
    @Autowired
    private FlowerStorageMapper flowerStorageMapper;

    /**
     * 查询鲜花的仓储信息单
     * 
     * @param id 鲜花的仓储信息单主键
     * @return 鲜花的仓储信息单
     */
    @Override
    public FlowerStorage selectFlowerStorageById(String id)
    {
        return flowerStorageMapper.selectFlowerStorageById(id);
    }

    /**
     * 查询鲜花的仓储信息单列表
     * 
     * @param flowerStorage 鲜花的仓储信息单
     * @return 鲜花的仓储信息单
     */
    @Override
    public List<FlowerStorage> selectFlowerStorageList(FlowerStorage flowerStorage)
    {
        return flowerStorageMapper.selectFlowerStorageList(flowerStorage);
    }

    /**
     * 新增鲜花的仓储信息单
     * 
     * @param flowerStorage 鲜花的仓储信息单
     * @return 结果
     */
    @Override
    public int insertFlowerStorage(FlowerStorage flowerStorage)
    {
        return flowerStorageMapper.insertFlowerStorage(flowerStorage);
    }

    /**
     * 修改鲜花的仓储信息单
     * 
     * @param flowerStorage 鲜花的仓储信息单
     * @return 结果
     */
    @Override
    public int updateFlowerStorage(FlowerStorage flowerStorage)
    {
        return flowerStorageMapper.updateFlowerStorage(flowerStorage);
    }

    /**
     * 批量删除鲜花的仓储信息单
     * 
     * @param ids 需要删除的鲜花的仓储信息单主键
     * @return 结果
     */
    @Override
    public int deleteFlowerStorageByIds(String[] ids)
    {
        return flowerStorageMapper.deleteFlowerStorageByIds(ids);
    }

    /**
     * 删除鲜花的仓储信息单信息
     * 
     * @param id 鲜花的仓储信息单主键
     * @return 结果
     */
    @Override
    public int deleteFlowerStorageById(String id)
    {
        return flowerStorageMapper.deleteFlowerStorageById(id);
    }
}
