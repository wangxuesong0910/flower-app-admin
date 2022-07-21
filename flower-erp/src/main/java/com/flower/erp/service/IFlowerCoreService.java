package com.flower.erp.service;

import com.flower.erp.domain.bo.FlowerDetailedBo;

import java.util.List;
import java.util.Map;

public interface IFlowerCoreService {

    List<FlowerDetailedBo> getFlowerDetailedBoList();

    int deleteCheck(String detailId);

    int getStoreQuantity();

    Map<Object, List<Map<String, Object>>> getUChartsStore();
}
