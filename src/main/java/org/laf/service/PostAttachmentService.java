package org.laf.service;

import org.laf.common.constant.ClaimApplyStatusEnum;
import org.laf.model.entity.PostAttachment;

import java.util.List;

public interface PostAttachmentService extends BaseService<PostAttachment> {

    /**
     * 根据招领发布ID查询附件（认领申请）列表
     * @param postId 发布ID
     * @return 附件列表
     */
    List<PostAttachment> listByPostId(Long postId);

    /**
     * 根据申请人账号ID查询认领申请
     * @param applicantAccountId 申请人账号ID
     * @param applyStatus 申请状态
     * @return 认领申请列表
     */
    List<PostAttachment> listByApplicantIdAndStatus(Long applicantAccountId, ClaimApplyStatusEnum applyStatus);

    /**
     * 审核认领申请
     * @param id 申请ID
     * @param auditorId 审核人ID
     * @param auditorName 审核人姓名
     * @param applyStatus 审核状态
     * @param auditOpinion 审核意见
     * @return 是否成功
     */
    boolean auditClaimApply(Long id, Long auditorId, String auditorName, ClaimApplyStatusEnum applyStatus, String auditOpinion);
}
