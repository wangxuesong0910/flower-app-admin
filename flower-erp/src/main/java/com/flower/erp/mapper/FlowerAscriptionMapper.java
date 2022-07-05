package com.flower.erp.mapper;

import java.util.List;
import com.flower.erp.domain.FlowerAscription;

/**
 * 鲜花的科属(一级分类)Mapper接口
 * 
 * @author wxs
 * @date 2022-03-08
 */
public interface FlowerAscriptionMapper 
{
    /**
     * 查询鲜花的科属(一级分类)
     * 
     * @param id 鲜花的科属(一级分类)主键
     * @return 鲜花的科属(一级分类)
     */
    public FlowerAscription selectFlowerAscriptionById(String id);

    /**
     * 查询鲜花的科属(一级分类)列表
     * 
     * @param flowerAscription 鲜花的科属(一级分类)
     * @return 鲜花的科属(一级分类)集合
     */
    public List<FlowerAscription> selectFlowerAscriptionList(FlowerAscription flowerAscription);

    /**
     * 新增鲜花的科属(一级分类)
     * 
     * @param flowerAscription 鲜花的科属(一级分类)
     * @return 结果
     */
    public int insertFlowerAscription(FlowerAscription flowerAscription);

    /**
     * 修改鲜花的科属(一级分类)
     * 
     * @param flowerAscription 鲜花的科属(一级分类)
     * @return 结果
     */
    public int updateFlowerAscription(FlowerAscription flowerAscription);

    /**
     * 删除鲜花的科属(一级分类)
     * 
     * @param id 鲜花的科属(一级分类)主键
     * @return 结果
     */
    public int deleteFlowerAscriptionById(String id);

    /**
     * 批量删除鲜花的科属(一级分类)
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFlowerAscriptionByIds(String[] ids);
}
