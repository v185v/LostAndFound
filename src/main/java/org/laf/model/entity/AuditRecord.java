package org.laf.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.laf.common.constant.AuditTypeEnum;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor(force = true)
@TableName("audit_record")
public class AuditRecord extends BaseEntity{
    /**
     * 被审核数据ID（如：publish_record.id、claim_apply.id、notice.id）
     */
    private Long targetId;

    /**
     * 审核类型（如：publish=发布信息、claim=认领申请、notice=公告）
     */
    private AuditTypeEnum auditType;

    /**
     * 审核操作（0=通过，1=驳回，关联AuditOperationEnum）
     */
    private Integer auditOperation;

    // ========== 审核人信息（关联统一账号表）==========
    /**
     * 审核人账号ID（关联account.id，仅失物管理员/系统管理员角色有效）
     */
    private Long auditorId;

    /**
     * 审核人姓名（冗余，关联account.realName）
     */
    private String auditorName;

    /**
     * 审核时间
     */
    private LocalDateTime auditTime;

    /**
     * 审核备注（驳回原因/审核说明）
     */
    private String auditRemark;
}
