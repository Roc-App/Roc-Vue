package com.roc.sale.leave.service.impl;

import java.util.List;

import com.roc.common.utils.AutoWiredToStatic;
import com.roc.sequence.controller.SeqController;
import com.roc.sequence.factory.SequenceClient;
import com.roc.sequence.utils.SequenctUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.roc.sale.leave.mapper.SaleLeaveMapper;
import com.roc.sale.leave.domain.SaleLeave;
import com.roc.sale.leave.service.ISaleLeaveService;

/**
 * 请假管理Service业务层处理
 * 
 * @author roc
 * @date 2023-01-03
 */
@Service
public class SaleLeaveServiceImpl implements ISaleLeaveService 
{
    @Autowired
    private SaleLeaveMapper saleLeaveMapper;

    @Autowired
    SeqController seqController;

    /**
     * 查询请假管理
     * 
     * @param leaveId 请假管理主键
     * @return 请假管理
     */
    @Override
    public SaleLeave selectSaleLeaveByLeaveId(String leaveId)
    {
        return saleLeaveMapper.selectSaleLeaveByLeaveId(leaveId);
    }

    /**
     * 查询请假管理列表
     * 
     * @param saleLeave 请假管理
     * @return 请假管理
     */
    @Override
    public List<SaleLeave> selectSaleLeaveList(SaleLeave saleLeave)
    {
        return saleLeaveMapper.selectSaleLeaveList(saleLeave);
    }

    /**
     * 新增请假管理
     * 
     * @param saleLeave 请假管理
     * @return 结果
     */
    @Override
    public int insertSaleLeave(SaleLeave saleLeave)
    {
        String id = AutoWiredToStatic.getBean(SequenctUtils.class).getSeqNoDefault();
        saleLeave.setLeaveId(id);
        return saleLeaveMapper.insertSaleLeave(saleLeave);
    }

    /**
     * 修改请假管理
     * 
     * @param saleLeave 请假管理
     * @return 结果
     */
    @Override
    public int updateSaleLeave(SaleLeave saleLeave)
    {
        return saleLeaveMapper.updateSaleLeave(saleLeave);
    }

    /**
     * 批量删除请假管理
     * 
     * @param leaveIds 需要删除的请假管理主键
     * @return 结果
     */
    @Override
    public int deleteSaleLeaveByLeaveIds(String[] leaveIds)
    {
        return saleLeaveMapper.deleteSaleLeaveByLeaveIds(leaveIds);
    }

    /**
     * 删除请假管理信息
     * 
     * @param leaveId 请假管理主键
     * @return 结果
     */
    @Override
    public int deleteSaleLeaveByLeaveId(String leaveId)
    {
        return saleLeaveMapper.deleteSaleLeaveByLeaveId(leaveId);
    }
}
