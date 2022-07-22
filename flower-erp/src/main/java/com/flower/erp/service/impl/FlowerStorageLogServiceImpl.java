package com.flower.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flower.erp.mapper.FlowerStorageLogMapper;
import com.flower.erp.domain.FlowerStorageLog;
import com.flower.erp.service.IFlowerStorageLogService;

/**
 * 出入库操作日志记录Service业务层处理
 * 
 * @author wxs
 * @date 2022-07-22
 */
@Service
public class FlowerStorageLogServiceImpl implements IFlowerStorageLogService 
{
    @Autowired
    private FlowerStorageLogMapper flowerStorageLogMapper;

    /**
     * 查询出入库操作日志记录
     * 
     * @param id 出入库操作日志记录主键
     * @return 出入库操作日志记录
     */
    @Override
    public FlowerStorageLog selectFlowerStorageLogById(Long id)
    {
        return flowerStorageLogMapper.selectFlowerStorageLogById(id);
    }

    /**
     * 查询出入库操作日志记录列表
     * 
     * @param flowerStorageLog 出入库操作日志记录
     * @return 出入库操作日志记录
     */
    @Override
    public List<FlowerStorageLog> selectFlowerStorageLogList(FlowerStorageLog flowerStorageLog)
    {
        return flowerStorageLogMapper.selectFlowerStorageLogList(flowerStorageLog);
    }

    /**
     * 新增出入库操作日志记录
     * 
     * @param flowerStorageLog 出入库操作日志记录
     * @return 结果
     */
    @Override
    public int insertFlowerStorageLog(FlowerStorageLog flowerStorageLog)
    {
        return flowerStorageLogMapper.insertFlowerStorageLog(flowerStorageLog);
    }

    /**
     * 修改出入库操作日志记录
     * 
     * @param flowerStorageLog 出入库操作日志记录
     * @return 结果
     */
    @Override
    public int updateFlowerStorageLog(FlowerStorageLog flowerStorageLog)
    {
        return flowerStorageLogMapper.updateFlowerStorageLog(flowerStorageLog);
    }

    /**
     * 批量删除出入库操作日志记录
     * 
     * @param ids 需要删除的出入库操作日志记录主键
     * @return 结果
     */
    @Override
    public int deleteFlowerStorageLogByIds(Long[] ids)
    {
        return flowerStorageLogMapper.deleteFlowerStorageLogByIds(ids);
    }

    /**
     * 删除出入库操作日志记录信息
     * 
     * @param id 出入库操作日志记录主键
     * @return 结果
     */
    @Override
    public int deleteFlowerStorageLogById(Long id)
    {
        return flowerStorageLogMapper.deleteFlowerStorageLogById(id);
    }
}
