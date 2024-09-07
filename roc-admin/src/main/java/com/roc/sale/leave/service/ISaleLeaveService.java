package com.roc.sale.leave.service;

import java.util.List;
import com.roc.sale.leave.domain.SaleLeave;

/**
 * 请假管理Service接口
 * 
 * @author roc
 * @date 2023-01-03
 */
public interface ISaleLeaveService 
{
    /**
     * 查询请假管理
     * 
     * @param leaveId 请假管理主键
     * @return 请假管理
     */
    public SaleLeave selectSaleLeaveByLeaveId(String leaveId);

    /**
     * 查询请假管理列表
     * 
     * @param saleLeave 请假管理
     * @return 请假管理集合
     */
    public List<SaleLeave> selectSaleLeaveList(SaleLeave saleLeave);

    /**
     * 新增请假管理
     * 
     * @param saleLeave 请假管理
     * @return 结果
     */
    public int insertSaleLeave(SaleLeave saleLeave);

    /**
     * 修改请假管理
     * 
     * @param saleLeave 请假管理
     * @return 结果
     */
    public int updateSaleLeave(SaleLeave saleLeave);

    /**
     * 批量删除请假管理
     * 
     * @param leaveIds 需要删除的请假管理主键集合
     * @return 结果
     */
    public int deleteSaleLeaveByLeaveIds(String[] leaveIds);

    /**
     * 删除请假管理信息
     * 
     * @param leaveId 请假管理主键
     * @return 结果
     */
    public int deleteSaleLeaveByLeaveId(String leaveId);
}
