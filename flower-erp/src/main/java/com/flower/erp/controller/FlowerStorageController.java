package com.flower.erp.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.flower.erp.service.IFlowerDetailedService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.flower.common.annotation.Log;
import com.flower.common.core.controller.BaseController;
import com.flower.common.core.domain.AjaxResult;
import com.flower.common.enums.BusinessType;
import com.flower.erp.domain.FlowerStorage;
import com.flower.erp.service.IFlowerStorageService;
import com.flower.common.utils.poi.ExcelUtil;
import com.flower.common.core.page.TableDataInfo;

/**
 * 鲜花的仓储信息单Controller
 * 
 * @author wxs
 * @date 2022-03-08
 */
@RestController
@RequestMapping("/erp/storage")
public class FlowerStorageController extends BaseController
{
    @Autowired
    private IFlowerStorageService flowerStorageService;

    @Autowired
    private IFlowerDetailedService flowerDetailedService;

    /**
     * 查询鲜花的仓储信息单列表
     */
    @PreAuthorize("@ss.hasPermi('erp:storage:list')")
    @GetMapping("/list")
    public TableDataInfo list(FlowerStorage flowerStorage)
    {
        startPage();
        List<FlowerStorage> list = flowerStorageService.selectFlowerStorageList(flowerStorage);
        return getDataTable(list);
    }

    /**
     * 导出鲜花的仓储信息单列表
     */
    @PreAuthorize("@ss.hasPermi('erp:storage:export')")
    @Log(title = "鲜花的仓储信息单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FlowerStorage flowerStorage)
    {
        List<FlowerStorage> list = flowerStorageService.selectFlowerStorageList(flowerStorage);
        ExcelUtil<FlowerStorage> util = new ExcelUtil<FlowerStorage>(FlowerStorage.class);
        util.exportExcel(response, list, "鲜花的仓储信息单数据");
    }

    /**
     * 获取鲜花的仓储信息单详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:storage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(flowerStorageService.selectFlowerStorageById(id));
    }

    /**
     * 新增鲜花的仓储信息单
     */
    @PreAuthorize("@ss.hasPermi('erp:storage:add')")
    @Log(title = "鲜花的仓储信息单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FlowerStorage flowerStorage)
    {
        return toAjax(flowerStorageService.insertFlowerStorage(flowerStorage));
    }

    /**
     * 修改鲜花的仓储信息单
     */
    @PreAuthorize("@ss.hasPermi('erp:storage:edit')")
    @Log(title = "鲜花的仓储信息单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FlowerStorage flowerStorage)
    {
        return toAjax(flowerStorageService.updateFlowerStorage(flowerStorage));
    }

    /**
     * 删除鲜花的仓储信息单
     */
    @PreAuthorize("@ss.hasPermi('erp:storage:remove')")
    @Log(title = "鲜花的仓储信息单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(flowerStorageService.deleteFlowerStorageByIds(ids));
    }

    /**
     * 获取鲜花的仓储信息单详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:storage:query')")
    @GetMapping(value = "/{type}")
    public AjaxResult getTypeInfo(@PathVariable("type") String type)
    {
        return AjaxResult.success(flowerDetailedService.selectFlowerDetailedType(type));
    }
}
