package org.laf.common.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 认领申请状态枚举
 */
@Getter
@AllArgsConstructor
public enum ClaimApplyStatusEnum {
    PENDING_REVIEW(0, "待审核"),
    APPROVED(1, "已通过"),
    REJECTED(2, "已驳回"),
    COMPLETED(3, "已完成");

    @JsonValue
    @EnumValue
    private final Integer code;
    private final String desc;

}
