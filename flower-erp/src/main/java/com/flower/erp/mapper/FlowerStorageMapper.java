package com.flower.erp.mapper;

import java.util.List;
import com.flower.erp.domain.FlowerStorage;

/**
 * 鲜花的仓储信息单Mapper接口
 * 
 * @author wxs
 * @date 2022-03-08
 */
public interface FlowerStorageMapper 
{
    /**
     * 查询鲜花的仓储信息单
     * 
     * @param id 鲜花的仓储信息单主键
     * @return 鲜花的仓储信息单
     */
    public FlowerStorage selectFlowerStorageById(String id);

    /**
     * 查询鲜花的仓储信息单列表
     * 
     * @param flowerStorage 鲜花的仓储信息单
     * @return 鲜花的仓储信息单集合
     */
    public List<FlowerStorage> selectFlowerStorageList(FlowerStorage flowerStorage);

    /**
     * 新增鲜花的仓储信息单
     * 
     * @param flowerStorage 鲜花的仓储信息单
     * @return 结果
     */
    public int insertFlowerStorage(FlowerStorage flowerStorage);

    /**
     * 修改鲜花的仓储信息单
     * 
     * @param flowerStorage 鲜花的仓储信息单
     * @return 结果
     */
    public int updateFlowerStorage(FlowerStorage flowerStorage);

    /**
     * 删除鲜花的仓储信息单
     * 
     * @param id 鲜花的仓储信息单主键
     * @return 结果
     */
    public int deleteFlowerStorageById(String id);

    /**
     * 批量删除鲜花的仓储信息单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFlowerStorageByIds(String[] ids);
}
