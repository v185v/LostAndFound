package org.laf.model.dto.account;

import lombok.*;
import org.laf.model.dto.base.BaseResponse;

@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class LoginResponse extends BaseResponse {
    private String token;
    private boolean isFirstLogin;
}
