package org.laf.common.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRoleEnum {
    STUDENT("ROLE_STUDENT", "学生"),
    TEACHER("ROLE_TEACHER", "老师"),
    STAFF("STAFF", "失物招领管理员"),
    ADMIN("ADMIN", "系统管理员");

    // 角色编码（用于JWT生成、Spring Security权限校验）
    @EnumValue
    @JsonValue
    private final String code;
    // 角色描述（用于前端展示、日志记录）
    private final String desc;




}
