package com.roc.system.service.impl;import com.roc.system.domain.SysSequenceDTO;import com.roc.system.domain.SysSequenceRange;import com.roc.system.mapper.SysSequenceMapper;import com.roc.system.service.ISysSequenceService;import lombok.extern.slf4j.Slf4j;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Propagation;import org.springframework.transaction.annotation.Transactional;import java.util.Date;@Service@Slf4jpublic class SysSequenceServiceImpl implements ISysSequenceService {    @Autowired    private SysSequenceMapper sequenceMapper;    private static final long overLong = 8223372036854775807L;    @Override    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)    public SysSequenceRange getNewSequenceRange(String seqName) {        log.info("开始获取序列{}的数据", seqName);        SysSequenceRange sequenceRange;        SysSequenceDTO inParam = new SysSequenceDTO();        inParam.setSeqName(seqName);        SysSequenceDTO sequenceDTO = sequenceMapper.getSequenceByIdForUpdate(inParam);        if (sequenceDTO == null) {            return null;        } else {            if ("N".equals(sequenceDTO.getCycleFlg()) && sequenceDTO.getCurrentValue().equals(sequenceDTO.getMaximum())) {                log.error("获取{}的数据失败，序列已经使用完，请速度重新设计解决方案", seqName);                return null;            } else {                long newMinValue = sequenceDTO.getCurrentValue();                long newMaxValue = sequenceDTO.getCurrentValue() + sequenceDTO.getIncrementValue();                if (newMaxValue > sequenceDTO.getMaximum()) {                    newMaxValue = sequenceDTO.getMaximum();                    /*新的起始值*/                    if ("Y".equals(sequenceDTO.getCycleFlg())) {                        sequenceDTO.setCurrentValue(1L);                    } else {                        sequenceDTO.setCurrentValue(sequenceDTO.getMaximum());                    }                } else {                    /*新的起始值*/                    sequenceDTO.setCurrentValue(newMaxValue);                }                /*最后更新时间*/                if (sequenceDTO.getCurrentValue() > overLong) {                    log.error("{}序列已经只剩10^19次方个，请及时分配新的，请速度重新设计解决方案", seqName);                }                sequenceDTO.setUpdTime(new Date());                int result = sequenceMapper.updateSequenceById(sequenceDTO);                if (result > 0) {                    log.info("获取序列{}的数据成功，新的序列范围为[{},{}]", seqName, newMinValue, newMaxValue - 1);                    sequenceRange = new SysSequenceRange(newMinValue, newMaxValue - 1);                    return sequenceRange;                } else {                    log.error("获取{}的数据失败，数据库中没有查询到此数据", seqName);                    return null;                }            }        }    }}