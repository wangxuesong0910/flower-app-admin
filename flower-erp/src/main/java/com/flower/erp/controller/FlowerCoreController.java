package com.flower.erp.controller;

import com.flower.common.annotation.Log;
import com.flower.common.core.controller.BaseController;
import com.flower.common.core.domain.AjaxResult;
import com.flower.common.core.domain.model.TencentBucket;
import com.flower.common.core.page.TableDataInfo;
import com.flower.common.enums.BusinessType;
import com.flower.common.utils.SecurityUtils;
import com.flower.common.utils.file.FileUploadUtils;
import com.flower.erp.domain.FlowerAscription;
import com.flower.erp.domain.FlowerStorage;
import com.flower.erp.domain.bo.FlowerDetailedBo;
import com.flower.erp.service.IFlowerCoreService;
import com.flower.erp.service.IFlowerStorageService;
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

    /**
     * 三级分类图片上传
     * @param fileName 文件名：detailImg
     * @param multipartFile 图片
     * @return 上传结果
     * @throws IOException
     */
    @RequestMapping("/detailImgUpload")
    public AjaxResult bucket(@RequestParam(value = "fileName", required = false)String fileName,@RequestParam(value = "img", required = false)MultipartFile multipartFile) throws IOException {
        String upload = FileUploadUtils.upload(multipartFile,fileName);
        return AjaxResult.success(upload);
    }

    /**
     * 删除三级分类前，需要查询其对应的flowe_store表中有与之关联的内容，如果有则不允许删除
     * @param detailId 三级分类ID
     * @return
     */
    @GetMapping("/deleteCheck")
    public AjaxResult deleteCheck(@RequestParam(value = "detailId")String detailId){
        return AjaxResult.success(service.deleteCheck(detailId));
    }

    /**
     * 获取库存总数，app首页展示
     * @return
     */
    @GetMapping("/getStoreQuantity")
    public AjaxResult getStoreQuantity(){
        return AjaxResult.success(service.getStoreQuantity());
    }

    /**
     * 获取ucharts图标需要的对应数据以及格式
     * @return
     */
    @GetMapping("/getUChartsStore")
    public AjaxResult getUChartsStore(){
        return AjaxResult.success(service.getUChartsStore());
    }

    /**
     * 新增鲜花的仓储信息单
     */

    @Log(title = "鲜花的仓储信息单", businessType = BusinessType.INSERT)
    @PostMapping("/putForm")
    public AjaxResult addOrUpdateStorage(@RequestBody FlowerStorage flowerStorage)
    {
        return AjaxResult.success(service.addOrUpdateStorage(flowerStorage));
    }

}
