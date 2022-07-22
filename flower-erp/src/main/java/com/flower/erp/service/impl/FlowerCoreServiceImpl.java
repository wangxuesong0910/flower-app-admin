package com.flower.erp.service.impl;

import com.flower.common.utils.SecurityUtils;
import com.flower.common.utils.uuid.IdUtils;
import com.flower.erp.domain.FlowerDetailed;
import com.flower.erp.domain.FlowerStorage;
import com.flower.erp.domain.FlowerStorageLog;
import com.flower.erp.domain.bo.FlowerDetailedBo;
import com.flower.erp.mapper.FlowerCoreMapper;
import com.flower.erp.mapper.FlowerDetailedMapper;
import com.flower.erp.mapper.FlowerStorageLogMapper;
import com.flower.erp.mapper.FlowerStorageMapper;
import com.flower.erp.service.IFlowerCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FlowerCoreServiceImpl implements IFlowerCoreService {
    @Autowired
    private FlowerCoreMapper mapper;

    @Autowired
    private FlowerStorageMapper storageMapper;

    @Autowired
    private FlowerStorageLogMapper storageLogMapper;

    @Autowired
    private FlowerDetailedMapper detailedMapper;

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

    @Override
    public int addOrUpdateStorage(FlowerStorage flowerStorage) {
        String detailedId = flowerStorage.getDetailedId();
        //查询当前入库的三级分类具体对应表detailed中的type，为了存储再storage_log表中
        FlowerDetailed flowerDetailed = detailedMapper.selectFlowerDetailedById(detailedId);
        System.out.println("=============>>>"+SecurityUtils.getUsername());
        if (detailedId!=null){
            List<Map<String, Object>> detailIdList = mapper.getDetailId(detailedId);
            if (detailIdList.size()==1){
                String id = (String) detailIdList.get(0).get("id");
                int quantity = (int) detailIdList.get(0).get("quantity");

                flowerStorage.setId(id);
                Long quantity1 = flowerStorage.getQuantity();
                flowerStorage.setQuantity(quantity1+quantity);
                flowerStorage.setUpdateBy(SecurityUtils.getUsername());
                flowerStorage.setUpdateTime(new Date());


                //向storageLog表中添加一条记录
                FlowerStorageLog flowerStorageLog = new FlowerStorageLog();
                flowerStorageLog.setStorageId(id);
                flowerStorageLog.setInOut("in");
                flowerStorageLog.setNum(quantity1);
                flowerStorageLog.setCreateDatetime(new Date());
                flowerStorageLog.setCreateBy(SecurityUtils.getUsername());
                flowerStorageLog.setType(flowerDetailed.getType());
                storageLogMapper.insertFlowerStorageLog(flowerStorageLog);
                return storageMapper.updateFlowerStorage(flowerStorage);
            }else if (detailIdList.size()==0){
                String id = IdUtils.fastSimpleUUID();
                flowerStorage.setId(id);
                flowerStorage.setCreateBy(SecurityUtils.getUsername());
                flowerStorage.setCreateTime(new Date());
                //向storageLog表中添加一条记录
                FlowerStorageLog flowerStorageLog = new FlowerStorageLog();
                flowerStorageLog.setStorageId(id);
                flowerStorageLog.setInOut("in");
                flowerStorageLog.setNum(flowerStorage.getQuantity());
                flowerStorageLog.setCreateDatetime(new Date());
                flowerStorageLog.setCreateBy(SecurityUtils.getUsername());
                flowerStorageLog.setType(flowerDetailed.getType());
                storageLogMapper.insertFlowerStorageLog(flowerStorageLog);
                return storageMapper.insertFlowerStorage(flowerStorage);
            }else {
                return 0;
            }
        }
        return 0;
    }

    ;
}
