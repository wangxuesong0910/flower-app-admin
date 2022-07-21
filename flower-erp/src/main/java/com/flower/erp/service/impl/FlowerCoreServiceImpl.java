package com.flower.erp.service.impl;

import com.flower.erp.domain.bo.FlowerDetailedBo;
import com.flower.erp.mapper.FlowerCoreMapper;
import com.flower.erp.service.IFlowerCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FlowerCoreServiceImpl implements IFlowerCoreService {
    @Autowired
    private FlowerCoreMapper mapper;

    @Override
    public List<FlowerDetailedBo> getFlowerDetailedBoList(){
        return mapper.getFlowerDetailedBoList();
    }

    @Override
    public int deleteCheck(String detailId) {
        return mapper.deleteCheck(detailId);
    }

    @Override
    public int getStoreQuantity() {
        return mapper.getStoreQuantity();
    }

    @Override
    public Map<Object, List<Map<String, Object>>> getUChartsStore() {
        List<Map<String, Object>> uChartsStore = mapper.getUChartsStore();
        Map<Object, List<Map<String, Object>>> collect = uChartsStore.stream().collect(Collectors.groupingBy((map)->{return map.get("varieties");}));
        System.out.println(collect.toString());
        return collect;
    }

    ;
}
