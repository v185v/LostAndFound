package org.laf.model.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.laf.common.constant.PostStatusEnum;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class AuditPostRequest implements Serializable {
    private Long postId;
    private Long auditorAccountId;
    private String auditorName;
    private PostStatusEnum postStatus;
    private String rejectReason;
}
