package org.laf.model.dto.postattachment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class ApplyClaimRequest implements Serializable {
    private Long postId;
    private Long applicantAccountId;
    private String applicantName;
    private String applicantPhone;
    private String proofInfo;
}
