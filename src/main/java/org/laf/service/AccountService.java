package org.laf.service;

import org.laf.common.constant.UserRoleEnum;
import org.laf.model.entity.Account;

import java.util.List;

public interface AccountService extends BaseService<Account> {
    /**
     * 根据账号ID查询账号信息
     * @param accountId 账号ID（登录账号）
     * @return 账号实体
     */
    Account getByAccountId(String accountId);

    /**
     * 根据角色查询账号列表
     * @param role 角色类型
     * @param status 账号状态（0=启用，1=禁用）
     * @return 账号列表
     */
    List<Account> listByRoleAndStatus(UserRoleEnum role, Integer status);

    /**
     * 验证登录密码
     * @param accountId 账号ID
     * @param password 明文密码
     * @return 验证结果
     */
    boolean verifyPassword(String accountId, String password);

    /**
     * 修改密码
     * @param accountId 账号ID
     * @param newPassword 新密码（明文，内部加密）
     * @return 是否成功
     */
    boolean updatePassword(String accountId, String newPassword);

    /**
     * 初始化首次登录密码
     * @param accountId 账号ID
     * @return 是否成功
     */
    boolean initFirstLoginPassword(String accountId);
}
