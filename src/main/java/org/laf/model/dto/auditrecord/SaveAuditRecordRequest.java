package org.laf.model.dto.auditrecord;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.laf.common.constant.AuditTypeEnum;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class SaveAuditRecordRequest implements Serializable {
    private Long targetId;
    private AuditTypeEnum auditType;
    private Integer auditOperation;
    private Long auditorId;
    private String auditorName;
    private LocalDateTime auditTime;
    private String auditRemark;
}
