package org.laf.common.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 审核类型（如：publish=发布信息、claim=认领申请、notice=公告）
 */
@Getter
@AllArgsConstructor
public enum AuditTypeEnum {
    PUBLISH("publish", "发布信息"),
    CLAIM("claim", "认领申请"),
    NOTICE("notice", "公告");

    @JsonValue
    @EnumValue
    private final String code;
    private final String desc;
}
