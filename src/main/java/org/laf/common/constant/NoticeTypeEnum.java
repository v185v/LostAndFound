package org.laf.common.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NoticeTypeEnum {
    // 系统管理员发布，全体可见
    GLOBAL(0, "全局公告"),
    // 失物招领管理员发布，指定范围可见
    REGIONAL(1, "区域公告");

    @EnumValue
    @JsonValue
    private final Integer code;
    private final String desc;

}
