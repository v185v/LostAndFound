package org.laf.model.dto.postattachment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.laf.common.constant.ClaimApplyStatusEnum;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class AuditClaimRequest implements Serializable {
    private Long id;
    private Long auditorId;
    private String auditorName;
    private ClaimApplyStatusEnum applyStatus;
    private String auditOpinion;
}
