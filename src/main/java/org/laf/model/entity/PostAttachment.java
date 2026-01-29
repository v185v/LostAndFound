package org.laf.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.laf.common.constant.ClaimApplyStatusEnum;

import java.time.LocalDateTime;

/**
 * 发布附件（照片）实体（post_attachment）
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "post_attachment")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class PostAttachment extends BaseEntity {
    /**
     * 关联招领发布记录ID（仅招领信息可申请，publish_record.id）
     */
    private Long postId;

    // ========== 申请人信息（关联统一账号表）==========
    /**
     * 申请人账号ID（关联account.id，仅师生角色有效）
     */
    private Long applicantAccountId;

    /**
     * 申请人姓名（冗余，关联account.realName）
     */
    private String applicantName;

    /**
     * 申请人电话（冗余，关联account.phone）
     */
    private String applicantPhone;

    /**
     * 额外物品特征/证明信息（申请人填写，用于审核）
     */
    private String proofInfo;

    // ========== 审核人信息（关联统一账号表）==========
    /**
     * 申请状态（关联ClaimApplyStatusEnum）
     */
    private ClaimApplyStatusEnum applyStatus;

    /**
     * 审核人账号ID（关联account.id，仅失物管理员角色有效）
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
     * 审核意见（驳回时填写原因，通过时可选填写）
     */
    private String auditOpinion;
}
