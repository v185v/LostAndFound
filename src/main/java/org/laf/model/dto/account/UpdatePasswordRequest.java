package org.laf.model.dto.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class UpdatePasswordRequest implements Serializable {
    private String accountId;
    private String oldPassword;
    private String newPassword;
}
