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
import com.flower.erp.domain.FlowerStorageLog;
import com.flower.erp.service.IFlowerStorageLogService;
import com.flower.common.utils.poi.ExcelUtil;
import com.flower.common.core.page.TableDataInfo;

/**
 * 出入库操作日志记录Controller
 * 
 * @author wxs
 * @date 2022-07-22
 */
@RestController
@RequestMapping("/erp/log")
public class FlowerStorageLogController extends BaseController
{
    @Autowired
    private IFlowerStorageLogService flowerStorageLogService;

    /**
     * 查询出入库操作日志记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:log:list')")
    @GetMapping("/list")
    public TableDataInfo list(FlowerStorageLog flowerStorageLog)
    {
        startPage();
        List<FlowerStorageLog> list = flowerStorageLogService.selectFlowerStorageLogList(flowerStorageLog);
        return getDataTable(list);
    }

    /**
     * 导出出入库操作日志记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:log:export')")
    @Log(title = "出入库操作日志记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FlowerStorageLog flowerStorageLog)
    {
        List<FlowerStorageLog> list = flowerStorageLogService.selectFlowerStorageLogList(flowerStorageLog);
        ExcelUtil<FlowerStorageLog> util = new ExcelUtil<FlowerStorageLog>(FlowerStorageLog.class);
        util.exportExcel(response, list, "出入库操作日志记录数据");
    }

    /**
     * 获取出入库操作日志记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:log:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(flowerStorageLogService.selectFlowerStorageLogById(id));
    }

    /**
     * 新增出入库操作日志记录
     */
    @PreAuthorize("@ss.hasPermi('system:log:add')")
    @Log(title = "出入库操作日志记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FlowerStorageLog flowerStorageLog)
    {
        return toAjax(flowerStorageLogService.insertFlowerStorageLog(flowerStorageLog));
    }

    /**
     * 修改出入库操作日志记录
     */
    @PreAuthorize("@ss.hasPermi('system:log:edit')")
    @Log(title = "出入库操作日志记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FlowerStorageLog flowerStorageLog)
    {
        return toAjax(flowerStorageLogService.updateFlowerStorageLog(flowerStorageLog));
    }

    /**
     * 删除出入库操作日志记录
     */
    @PreAuthorize("@ss.hasPermi('system:log:remove')")
    @Log(title = "出入库操作日志记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(flowerStorageLogService.deleteFlowerStorageLogByIds(ids));
    }
}
