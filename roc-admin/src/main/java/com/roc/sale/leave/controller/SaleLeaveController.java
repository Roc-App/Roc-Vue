package com.roc.sale.leave.controller;

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
import com.roc.common.annotation.Log;
import com.roc.common.core.controller.BaseController;
import com.roc.common.core.domain.AjaxResult;
import com.roc.common.enums.BusinessType;
import com.roc.sale.leave.domain.SaleLeave;
import com.roc.sale.leave.service.ISaleLeaveService;
import com.roc.common.utils.poi.ExcelUtil;
import com.roc.common.core.page.TableDataInfo;

/**
 * 请假管理Controller
 * 
 * @author roc
 * @date 2023-01-03
 */
@RestController
@RequestMapping("/sale/leave")
public class SaleLeaveController extends BaseController
{
    @Autowired
    private ISaleLeaveService saleLeaveService;

    /**
     * 查询请假管理列表
     */
    @PreAuthorize("@ss.hasPermi('sale:leave:list')")
    @GetMapping("/list")
    public TableDataInfo list(SaleLeave saleLeave)
    {
        startPage();
        List<SaleLeave> list = saleLeaveService.selectSaleLeaveList(saleLeave);
        return getDataTable(list);
    }

    /**
     * 导出请假管理列表
     */
    @PreAuthorize("@ss.hasPermi('sale:leave:export')")
    @Log(title = "请假管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SaleLeave saleLeave)
    {
        List<SaleLeave> list = saleLeaveService.selectSaleLeaveList(saleLeave);
        ExcelUtil<SaleLeave> util = new ExcelUtil<SaleLeave>(SaleLeave.class);
        util.exportExcel(response, list, "请假管理数据");
    }

    /**
     * 获取请假管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('sale:leave:query')")
    @GetMapping(value = "/{leaveId}")
    public AjaxResult getInfo(@PathVariable("leaveId") String leaveId)
    {
        return success(saleLeaveService.selectSaleLeaveByLeaveId(leaveId));
    }

    /**
     * 新增请假管理
     */
    @PreAuthorize("@ss.hasPermi('sale:leave:add')")
    @Log(title = "请假管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SaleLeave saleLeave)
    {
        return toAjax(saleLeaveService.insertSaleLeave(saleLeave));
    }

    /**
     * 修改请假管理
     */
    @PreAuthorize("@ss.hasPermi('sale:leave:edit')")
    @Log(title = "请假管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SaleLeave saleLeave)
    {
        return toAjax(saleLeaveService.updateSaleLeave(saleLeave));
    }

    /**
     * 删除请假管理
     */
    @PreAuthorize("@ss.hasPermi('sale:leave:remove')")
    @Log(title = "请假管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{leaveIds}")
    public AjaxResult remove(@PathVariable String[] leaveIds)
    {
        return toAjax(saleLeaveService.deleteSaleLeaveByLeaveIds(leaveIds));
    }
}
