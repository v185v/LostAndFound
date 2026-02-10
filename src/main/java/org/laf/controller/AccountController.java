package org.laf.controller;

import org.laf.common.constant.UserRoleEnum;
import org.laf.common.result.AjaxResult;
import org.laf.model.entity.Account;
import org.laf.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

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
    public AjaxResult<String> login(@RequestParam String accountId, @RequestParam String password) {
        if (accountService.verifyPassword(accountId, password)) {
            // TODO: Generate and return JWT token
            return AjaxResult.success("Login successful");
        } else {
            return AjaxResult.fail(401, "Invalid credentials");
        }
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
