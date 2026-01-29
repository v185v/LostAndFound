package org.laf.model.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.laf.common.constant.UserRoleEnum;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor(force = true)
@TableName("account")
public class Account extends BaseEntity{
    // ========== 所有角色通用字段（必填，无空置）==========
    /**
     * 登录账号（唯一）：学生=学号、老师=工号、失物管理员=分配工号、系统管理员=自定义账号
     */
    private String accountId;

    /**
     * 密码（BCrypt加密存储）：师生初始=身份证后六位，管理员初始=系统分配
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 角色（对应UserRoleEnum的code，区分身份核心字段）
     */
    private UserRoleEnum role;

    /**
     * 账号状态（对应UserStatusEnum，0=启用，1=禁用）
     */
    private Integer status;

    /**
     * 是否首次登录（0=否，1=是）：师生首次登录强制改密码，管理员可选
     */
    private Boolean isFirstLogin;

    /**
     * 备注（可选）：如学生年级/老师科室/管理员分配说明
     */
    private String remark;

    // ========== 专属字段（仅对应角色有效，其他角色空置，无需非空）==========
    /**
     * 身份证后六位（仅师生有效，用于生成初始密码，可选加密存储）
     */
    private String idCardSuffix;



    /**
     * 管理员类型（仅系统管理员有效，0=超级管理员（仅1个），1=子管理员）
     */
    private Integer adminType;


}
