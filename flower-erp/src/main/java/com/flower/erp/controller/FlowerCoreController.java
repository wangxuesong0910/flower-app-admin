package com.flower.erp.controller;

import com.flower.common.core.controller.BaseController;
import com.flower.common.core.domain.AjaxResult;
import com.flower.common.core.domain.model.TencentBucket;
import com.flower.common.core.page.TableDataInfo;
import com.flower.common.utils.SecurityUtils;
import com.flower.common.utils.file.FileUploadUtils;
import com.flower.erp.domain.FlowerAscription;
import com.flower.erp.domain.bo.FlowerDetailedBo;
import com.flower.erp.service.IFlowerCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @RequestMapping("/detailImgUpload")
    public AjaxResult bucket(@RequestParam(value = "fileName", required = false)String fileName,@RequestParam(value = "img", required = false)MultipartFile multipartFile) throws IOException {
        String upload = FileUploadUtils.upload(multipartFile,fileName);
        return AjaxResult.success(upload);
    }

}
