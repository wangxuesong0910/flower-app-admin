package com.flower.erp.service.impl;

import com.flower.erp.domain.bo.FlowerDetailedBo;
import com.flower.erp.mapper.FlowerCoreMapper;
import com.flower.erp.service.IFlowerCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerCoreServiceImpl implements IFlowerCoreService {
    @Autowired
    private FlowerCoreMapper mapper;

    @Override
    public List<FlowerDetailedBo> getFlowerDetailedBoList(){
        return mapper.getFlowerDetailedBoList();
    };
}
