package com.flower.erp.mapper;

import com.flower.erp.domain.bo.FlowerDetailedBo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FlowerCoreMapper {
    
    List<FlowerDetailedBo> getFlowerDetailedBoList();

    int deleteCheck(String detailId);

    int getStoreQuantity();

    List<Map<String,Object>> getUChartsStore();

}
