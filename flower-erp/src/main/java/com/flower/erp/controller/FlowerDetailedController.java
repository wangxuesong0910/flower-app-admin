package com.flower.erp.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.flower.erp.domain.bo.FlowerDetailedBo;
import com.flower.erp.service.IFlowerAscriptionService;
import com.flower.erp.service.IFlowerVarietiesService;
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
import com.flower.erp.domain.FlowerDetailed;
import com.flower.erp.service.IFlowerDetailedService;
import com.flower.common.utils.poi.ExcelUtil;
import com.flower.common.core.page.TableDataInfo;

/**
 * 花的种类管理Controller
 * 
 * @author wxs
 * @date 2022-03-08
 */
@RestController
@RequestMapping("/erp/detailed")
public class FlowerDetailedController extends BaseController
{
    @Autowired
    private IFlowerDetailedService flowerDetailedService;

    /**
     * 查询花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)列表
     */
    @PreAuthorize("@ss.hasPermi('erp:detailed:list')")
    @GetMapping("/list")
    public TableDataInfo list(FlowerDetailed flowerDetailed)
    {
        startPage();
        List<FlowerDetailed> list = flowerDetailedService.selectFlowerDetailedList(flowerDetailed);
        return getDataTable(list);
    }

    /**
     * 导出花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)列表
     */
    @PreAuthorize("@ss.hasPermi('erp:detailed:export')")
    @Log(title = "花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FlowerDetailed flowerDetailed)
    {
        List<FlowerDetailed> list = flowerDetailedService.selectFlowerDetailedList(flowerDetailed);
        ExcelUtil<FlowerDetailed> util = new ExcelUtil<FlowerDetailed>(FlowerDetailed.class);
        util.exportExcel(response, list, "花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)数据");
    }

    /**
     * 获取花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:detailed:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(flowerDetailedService.selectFlowerDetailedById(id));
    }

    /**
     * 新增花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     */
    @PreAuthorize("@ss.hasPermi('erp:detailed:add')")
    @Log(title = "花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FlowerDetailed flowerDetailed)
    {
        return toAjax(flowerDetailedService.insertFlowerDetailed(flowerDetailed));
    }

    /**
     * 修改花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     */
    @PreAuthorize("@ss.hasPermi('erp:detailed:edit')")
    @Log(title = "花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FlowerDetailed flowerDetailed)
    {
        return toAjax(flowerDetailedService.updateFlowerDetailed(flowerDetailed));
    }

    /**
     * 删除花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     */
    @PreAuthorize("@ss.hasPermi('erp:detailed:remove')")
    @Log(title = "花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(flowerDetailedService.deleteFlowerDetailedByIds(ids));
    }

    /**
     * 查询花的种类，科属，二级分类
     * @param flowerDetailed 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * @return 结果
     */
    @PreAuthorize("@ss.hasPermi('erp:detailed:list')")
    @GetMapping("/listBo")
    public TableDataInfo selectFlowerDetailedBo(FlowerDetailed flowerDetailed){
        startPage();
        List<FlowerDetailedBo> flowerDetailedBos = flowerDetailedService.selectFlowerDetailedBo(flowerDetailed);
        return getDataTable(flowerDetailedBos);
    }

    /**
     * 查询花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)列表
     * 为app界面入库下拉框做筛选
     */
    @PreAuthorize("@ss.hasPermi('erp:detailed:list')")
    @GetMapping("/appDetailSelectList")
    public AjaxResult appDetailSelectList()
    {
//        startPage();
//        List<FlowerDetailed> list = flowerDetailedService.selectFlowerDetailedList();
        Map<Object, List<Map<String, Object>>> maps = flowerDetailedService.appDetailSelectList();
        return AjaxResult.success(maps);
    }

}
