package org.laf.common.constant;


import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PostTypeEnum {
    LOST(0, "失物","丢失"),
    FOUND(1, "招领","拾取");

    @EnumValue
    @JsonValue
    private final Integer code;
    private final String desc;
    private final String prefix;
}
