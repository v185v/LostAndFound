package org.laf.model.dto.account;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class LoginRequest implements Serializable {

    @NotBlank(message = "账号不能为空")
    private String accountId;

    @NotBlank(message = "密码不能为空")
    private String password;
}
