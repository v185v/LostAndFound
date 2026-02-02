package org.laf.service;

import org.laf.common.constant.AuditTypeEnum;
import org.laf.model.entity.AuditRecord;

import java.util.List;

public interface AuditRecordService extends BaseService<AuditRecord> {

    /**
     * 根据被审核数据ID和审核类型查询审核记录
     * @param targetId 被审核数据ID
     * @param auditType 审核类型
     * @return 审核记录列表
     */
    List<AuditRecord> listByTargetIdAndAuditType(Long targetId, AuditTypeEnum auditType);

    /**
     * 新增审核记录
     * @param auditRecord 审核记录实体
     * @return 是否成功
     */
    boolean saveAuditRecord(AuditRecord auditRecord);
}
