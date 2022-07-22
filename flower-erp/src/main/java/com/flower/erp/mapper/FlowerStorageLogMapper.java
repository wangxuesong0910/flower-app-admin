package com.flower.erp.mapper;

import java.util.List;
import com.flower.erp.domain.FlowerStorageLog;

/**
 * 出入库操作日志记录Mapper接口
 * 
 * @author wxs
 * @date 2022-07-22
 */
public interface FlowerStorageLogMapper 
{
    /**
     * 查询出入库操作日志记录
     * 
     * @param id 出入库操作日志记录主键
     * @return 出入库操作日志记录
     */
    public FlowerStorageLog selectFlowerStorageLogById(Long id);

    /**
     * 查询出入库操作日志记录列表
     * 
     * @param flowerStorageLog 出入库操作日志记录
     * @return 出入库操作日志记录集合
     */
    public List<FlowerStorageLog> selectFlowerStorageLogList(FlowerStorageLog flowerStorageLog);

    /**
     * 新增出入库操作日志记录
     * 
     * @param flowerStorageLog 出入库操作日志记录
     * @return 结果
     */
    public int insertFlowerStorageLog(FlowerStorageLog flowerStorageLog);

    /**
     * 修改出入库操作日志记录
     * 
     * @param flowerStorageLog 出入库操作日志记录
     * @return 结果
     */
    public int updateFlowerStorageLog(FlowerStorageLog flowerStorageLog);

    /**
     * 删除出入库操作日志记录
     * 
     * @param id 出入库操作日志记录主键
     * @return 结果
     */
    public int deleteFlowerStorageLogById(Long id);

    /**
     * 批量删除出入库操作日志记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFlowerStorageLogByIds(Long[] ids);
}
