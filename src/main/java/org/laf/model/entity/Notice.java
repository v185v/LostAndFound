package org.laf.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.laf.common.constant.NoticeTypeEnum;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor(force = true)
@TableName("notice")
public class Notice extends BaseEntity{
    /**
     * 公告标题
     */
    private String title;

    /**
     * 公告内容
     */
    private String content;

    /**
     * 公告类型（0=全局，1=区域，关联NoticeTypeEnum）
     */
    private NoticeTypeEnum noticeType;

    // ========== 发布人信息（关联统一账号表，无需互斥字段）==========
    /**
     * 发布人账号ID（关联account.id，全局公告=系统管理员，区域公告=失物管理员）
     */
    private Long publisherId;

    /**
     * 发布人姓名（冗余，关联account.realName，前端直接展示）
     */
    private String publisherName;

    // ========== 公告时效 ==========
    /**
     * 生效时间
     */
    private LocalDateTime effectiveTime;

    /**
     * 失效时间（null=永久有效）
     */
    private LocalDateTime invalidTime;

    /**
     * 是否置顶（0=否，1=是）
     */
    private Integer isTop;
}
