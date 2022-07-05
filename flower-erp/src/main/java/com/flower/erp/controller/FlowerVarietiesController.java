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
import com.flower.erp.domain.FlowerVarieties;
import com.flower.erp.service.IFlowerVarietiesService;
import com.flower.common.utils.poi.ExcelUtil;
import com.flower.common.core.page.TableDataInfo;

/**
 * 花的品种：玫瑰、百合等等(二级分类)Controller
 * 
 * @author wxs
 * @date 2022-03-08
 */
@RestController
@RequestMapping("/erp/varieties")
public class FlowerVarietiesController extends BaseController
{
    @Autowired
    private IFlowerVarietiesService flowerVarietiesService;

    /**
     * 查询花的品种：玫瑰、百合等等(二级分类)列表
     */
    @PreAuthorize("@ss.hasPermi('erp:varieties:list')")
    @GetMapping("/list")
    public TableDataInfo list(FlowerVarieties flowerVarieties)
    {
        startPage();
        List<FlowerVarieties> list = flowerVarietiesService.selectFlowerVarietiesList(flowerVarieties);
        return getDataTable(list);
    }

    /**
     * 导出花的品种：玫瑰、百合等等(二级分类)列表
     */
    @PreAuthorize("@ss.hasPermi('erp:varieties:export')")
    @Log(title = "花的品种：玫瑰、百合等等(二级分类)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FlowerVarieties flowerVarieties)
    {
        List<FlowerVarieties> list = flowerVarietiesService.selectFlowerVarietiesList(flowerVarieties);
        ExcelUtil<FlowerVarieties> util = new ExcelUtil<FlowerVarieties>(FlowerVarieties.class);
        util.exportExcel(response, list, "花的品种：玫瑰、百合等等(二级分类)数据");
    }

    /**
     * 获取花的品种：玫瑰、百合等等(二级分类)详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:varieties:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(flowerVarietiesService.selectFlowerVarietiesById(id));
    }

    /**
     * 新增花的品种：玫瑰、百合等等(二级分类)
     */
    @PreAuthorize("@ss.hasPermi('erp:varieties:add')")
    @Log(title = "花的品种：玫瑰、百合等等(二级分类)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FlowerVarieties flowerVarieties)
    {
        return toAjax(flowerVarietiesService.insertFlowerVarieties(flowerVarieties));
    }

    /**
     * 修改花的品种：玫瑰、百合等等(二级分类)
     */
    @PreAuthorize("@ss.hasPermi('erp:varieties:edit')")
    @Log(title = "花的品种：玫瑰、百合等等(二级分类)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FlowerVarieties flowerVarieties)
    {
        return toAjax(flowerVarietiesService.updateFlowerVarieties(flowerVarieties));
    }

    /**
     * 删除花的品种：玫瑰、百合等等(二级分类)
     */
    @PreAuthorize("@ss.hasPermi('erp:varieties:remove')")
    @Log(title = "花的品种：玫瑰、百合等等(二级分类)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(flowerVarietiesService.deleteFlowerVarietiesByIds(ids));
    }
}
