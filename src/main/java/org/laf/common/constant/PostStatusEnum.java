package org.laf.common.constant;


import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PostStatusEnum {
    PENDING_AUDIT(0, "待审核"),
    PASSED(1, "已通过"),
    MATCHED(2, "已匹配"),
    CLAIMED(3, "已认领"),
    REJECTED(4, "已驳回"),
    CANCELED(5, "已取消"),
    // 长期无人认领（30天+）
    ARCHIVED(6, "已归档");

    @EnumValue
    @JsonValue
    private final Integer code;
    private final String desc;
}
