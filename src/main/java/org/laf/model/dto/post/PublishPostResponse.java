package org.laf.model.dto.post;

import lombok.*;
import org.laf.model.dto.base.BaseResponse;

@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PublishPostResponse extends BaseResponse {
    // 可以根据需要返回发布后的ID或其他信息
}
