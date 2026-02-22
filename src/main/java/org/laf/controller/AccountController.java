package org.laf.controller;

import lombok.RequiredArgsConstructor;
import org.laf.common.constant.UserRoleEnum;
import org.laf.common.result.AjaxResult;
import org.laf.common.utils.JwtUtils;
import org.laf.model.dto.account.LoginRequest;
import org.laf.model.dto.account.LoginResponse;
import org.laf.model.entity.Account;
import org.laf.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {


    private final AccountService accountService;

    private final JwtUtils jwtUtils;

    @GetMapping("/{id}")
    public AjaxResult<Account> getById(@PathVariable Long id) {
        return AjaxResult.success(accountService.getById(id));
    }

    @GetMapping("/getByAccountId/{accountId}")
    public AjaxResult<Account> getByAccountId(@PathVariable String accountId) {
        return AjaxResult.success(accountService.getByAccountId(accountId));
    }

    @GetMapping("/listByRole")
    public AjaxResult<List<Account>> listByRole(@RequestParam UserRoleEnum role, @RequestParam(required = false) Integer status) {
        return AjaxResult.success(accountService.listByRoleAndStatus(role, status));
    }

    @PostMapping("/login")
    public AjaxResult<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        if (accountService.verifyPassword(loginRequest.getAccountId(), loginRequest.getPassword())) {
            Account account = accountService.getByAccountId(loginRequest.getAccountId());
            String token = jwtUtils.generateToken(account.getAccountId(), account.getRole().getCode());
            
            LoginResponse response = new LoginResponse();
            response.setToken(token);
            response.setIsFirstLogin(Boolean.TRUE.equals(account.getIsFirstLogin()));
            response.setId(account.getId());
            response.setCreatedAt(account.getCreatedAt());
            response.setUpdatedAt(account.getUpdatedAt());
            
            return AjaxResult.success(response);
        } else {
            return AjaxResult.fail(401, "Invalid credentials");
        }
    }

    @PostMapping("/logout")
    public AjaxResult<String> logout() {
        // Client side should remove the token. Server side can blacklist token if needed (requires Redis).
        return AjaxResult.success("Logout successful");
    }

    @PostMapping("/updatePassword")
    public AjaxResult<Boolean> updatePassword(@RequestParam String accountId, @RequestParam String newPassword) {
        return AjaxResult.success(accountService.updatePassword(accountId, newPassword));
    }

    @PostMapping("/initFirstLoginPassword")
    public AjaxResult<Boolean> initFirstLoginPassword(@RequestParam String accountId) {
        return AjaxResult.success(accountService.initFirstLoginPassword(accountId));
    }
}
