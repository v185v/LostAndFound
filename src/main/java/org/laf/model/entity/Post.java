package org.laf.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.laf.common.constant.PostStatusEnum;
import org.laf.common.constant.PostTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * 发布附件（照片）实体（publish_attachment）
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "post")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Post extends BaseEntity{
    /**
     * 发布人账号ID（关联account.id，仅师生角色有效）
     */
    private Long accountId;

    private String title;

    private String content;

    /**
     * 发布人姓名（冗余，关联account.realName，减少联表查询）
     */
    private String publisherName;

    /**
     * 发布人电话（冗余，关联account.phone，管理员可见）
     */
    private String publisherPhone;

    // ========== 发布基础信息 ==========
    /**
     * 发布类型（失物/招领，关联PostTypeEnum）
     */
    private PostTypeEnum postType;

    /**
     * 物品名称
     */
    private String itemName;

    /**
     * 物品类型（关联system_config，如：证件、电子产品、衣物）
     */
    private String itemType;

    /**
     * 丢失/拾取地点（根据publishType区分）
     */
    private String location;

    /**
     * 丢失/拾取时间（根据publishType区分）
     */
    private LocalDateTime occurTime;

    /**
     * 物品特征描述
     */
    private String itemDesc;

    /**
     * 悬赏金额（仅失物信息有效，单位：元，可选）
     */
    private BigDecimal reward;

    /**
     * 物品存放地点（仅招领信息有效，审核通过后由失物管理员填写）
     */
    private String storageLocation;

    // ========== 审核信息（关联统一账号表account.id，仅失物管理员角色有效）==========
    /**
     * 发布状态（关联PostStatusEnum）
     */
    private PostStatusEnum postStatus;

    /**
     * 驳回原因（仅publishStatus=4时有效，失物管理员填写）
     */
    private String rejectReason;

    /**
     * 归档说明（仅publishStatus=6时有效，失物管理员填写物品处理方式）
     */
    private String archiveDesc;

    /**
     * 审核人账号ID（关联account.id，仅失物管理员角色有效）
     */
    private Long auditorAccountId;

    /**
     * 审核人姓名（冗余，关联account.realName，前端展示）
     */
    private String auditorName;

    /**
     * 审核时间
     */
    private LocalDateTime auditTime;


}
