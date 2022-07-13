package com.flower.erp.controller;

import com.flower.common.core.controller.BaseController;
import com.flower.common.core.domain.AjaxResult;
import com.flower.common.core.domain.model.TencentBucket;
import com.flower.common.core.page.TableDataInfo;
import com.flower.erp.domain.FlowerAscription;
import com.flower.erp.domain.bo.FlowerDetailedBo;
import com.flower.erp.service.IFlowerCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.flower.common.utils.PageUtils.startPage;

@RestController
@RequestMapping("/erp/core")
public class FlowerCoreController extends BaseController {
    @Autowired
    private IFlowerCoreService service;

    @Autowired
    private TencentBucket tencentBucket;

    /**
     * 查询二级分类列表
     */
    @GetMapping("/titleList")
    public TableDataInfo list()
    {
        startPage();
        List<FlowerDetailedBo> flowerDetailedBoList = service.getFlowerDetailedBoList();
        return getDataTable(flowerDetailedBoList);
    }

    @GetMapping("/bucket")
    public AjaxResult bucket()
    {
//        TencentBucket titleListencentBucket = new TencentBucket();
        return AjaxResult.success(tencentBucket);
    }

}
