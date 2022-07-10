package com.flower.erp.mapper;

import com.flower.erp.domain.bo.FlowerDetailedBo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowerCoreMapper {
    
    List<FlowerDetailedBo> getFlowerDetailedBoList();
    
}
