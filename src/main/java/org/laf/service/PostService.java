package org.laf.service;

import org.laf.common.constant.PostStatusEnum;
import org.laf.common.constant.PostTypeEnum;
import org.laf.model.entity.Post;

import java.util.List;

public interface PostService extends BaseService<Post> {

    /**
     * 根据发布人账号ID查询发布列表
     * @param accountId 发布人账号ID
     * @param postType 发布类型（失物/招领）
     * @return 发布列表
     */
    List<Post> listByAccountIdAndType(Long accountId, PostTypeEnum postType);

    /**
     * 根据发布状态查询发布列表
     * @param postStatus 发布状态
     * @param postType 发布类型（可选）
     * @return 发布列表
     */
    List<Post> listByStatusAndType(PostStatusEnum postStatus, PostTypeEnum postType);

    /**
     * 审核发布信息
     * @param postId 发布ID
     * @param auditorAccountId 审核人账号ID
     * @param auditorName 审核人姓名
     * @param postStatus 审核状态
     * @param rejectReason 驳回原因（审核不通过时必填）
     * @return 是否成功
     */
    boolean auditPost(Long postId, Long auditorAccountId, String auditorName, PostStatusEnum postStatus, String rejectReason);

    /**
     * 归档发布信息
     * @param postId 发布ID
     * @param archiveDesc 归档说明
     * @return 是否成功
     */
    boolean archivePost(Long postId, String archiveDesc);
}
