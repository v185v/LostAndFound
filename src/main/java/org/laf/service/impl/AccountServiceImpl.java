package org.laf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.laf.common.constant.UserRoleEnum;
import org.laf.mapper.AccountMapper;
import org.laf.model.entity.Account;
import org.laf.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    private final PasswordEncoder passwordEncoder;

    @Override
    public Account getByAccountId(String accountId) {
        LambdaQueryWrapper<Account> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Account::getAccountId, accountId);
        return this.getOne(wrapper);
    }

    @Override
    public List<Account> listByRoleAndStatus(UserRoleEnum role, Integer status) {
        LambdaQueryWrapper<Account> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Account::getRole, role);
        if (status != null) {
            wrapper.eq(Account::getStatus, status);
        }
        return this.list(wrapper);
    }

    @Override
    public boolean verifyPassword(String accountId, String password) {
        Account account = getByAccountId(accountId);
        if (account == null) {
            return false;
        }
        return passwordEncoder.matches(password, account.getPassword());
    }

    @Override
    public boolean updatePassword(String accountId, String newPassword) {
        Account account = getByAccountId(accountId);
        if (account == null) {
            return false;
        }
        account.setPassword(passwordEncoder.encode(newPassword));
        // 如果是首次登录，修改密码后标记为非首次登录
        if (Boolean.TRUE.equals(account.getIsFirstLogin())) {
            account.setIsFirstLogin(false);
        }
        return this.updateById(account);
    }

    @Override
    public boolean initFirstLoginPassword(String accountId) {
        Account account = getByAccountId(accountId);
        if (account == null) {
            return false;
        }
        // 师生初始密码为身份证后六位
        if (UserRoleEnum.STUDENT.equals(account.getRole()) || UserRoleEnum.TEACHER.equals(account.getRole())) {
            String idCardSuffix = account.getIdCardSuffix();
            if (idCardSuffix != null && idCardSuffix.length() == 6) {
                account.setPassword(passwordEncoder.encode(idCardSuffix));
                account.setIsFirstLogin(true);
                return this.updateById(account);
            }
        }
        return false;
    }
}
