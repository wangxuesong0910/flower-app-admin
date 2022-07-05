package com.flower.erp.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.flower.erp.domain.FlowerAscription;
import com.flower.erp.service.IFlowerAscriptionService;
import com.flower.common.utils.poi.ExcelUtil;
import com.flower.common.core.page.TableDataInfo;

/**
 * 鲜花的科属(一级分类)Controller
 * 
 * @author wxs
 * @date 2022-03-08
 */
@RestController
@RequestMapping("/erp/ascription")
public class FlowerAscriptionController extends BaseController
{
    @Autowired
    private IFlowerAscriptionService flowerAscriptionService;

    /**
     * 查询鲜花的科属(一级分类)列表
     */
    @PreAuthorize("@ss.hasPermi('erp:ascription:list')")
    @GetMapping("/list")
    public TableDataInfo list(FlowerAscription flowerAscription)
    {
        startPage();
        List<FlowerAscription> list = flowerAscriptionService.selectFlowerAscriptionList(flowerAscription);
        return getDataTable(list);
    }

    /**
     * 导出鲜花的科属(一级分类)列表
     */
    @PreAuthorize("@ss.hasPermi('erp:ascription:export')")
    @Log(title = "鲜花的科属(一级分类)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FlowerAscription flowerAscription)
    {
        List<FlowerAscription> list = flowerAscriptionService.selectFlowerAscriptionList(flowerAscription);
        ExcelUtil<FlowerAscription> util = new ExcelUtil<FlowerAscription>(FlowerAscription.class);
        util.exportExcel(response, list, "鲜花的科属(一级分类)数据");
    }

    /**
     * 获取鲜花的科属(一级分类)详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:ascription:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(flowerAscriptionService.selectFlowerAscriptionById(id));
    }

    /**
     * 新增鲜花的科属(一级分类)
     */
    @PreAuthorize("@ss.hasPermi('erp:ascription:add')")
    @Log(title = "鲜花的科属(一级分类)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FlowerAscription flowerAscription)
    {
        return toAjax(flowerAscriptionService.insertFlowerAscription(flowerAscription));
    }

    /**
     * 修改鲜花的科属(一级分类)
     */
    @PreAuthorize("@ss.hasPermi('erp:ascription:edit')")
    @Log(title = "鲜花的科属(一级分类)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FlowerAscription flowerAscription)
    {
        return toAjax(flowerAscriptionService.updateFlowerAscription(flowerAscription));
    }

    /**
     * 删除鲜花的科属(一级分类)
     */
    @PreAuthorize("@ss.hasPermi('erp:ascription:remove')")
    @Log(title = "鲜花的科属(一级分类)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(flowerAscriptionService.deleteFlowerAscriptionByIds(ids));
    }
}
