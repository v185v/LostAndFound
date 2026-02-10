package org.laf.model.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.laf.common.constant.PostTypeEnum;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class PublishPostRequest implements Serializable {
    private Long accountId;
    private String title;
    private String content;
    private String publisherName;
    private String publisherPhone;
    private PostTypeEnum postType;
    private String itemName;
    private String itemType;
    private String location;
    private LocalDateTime occurTime;
    private String itemDesc;
    private BigDecimal reward;
    // 招领信息发布时必须上传照片，这里假设照片上传后返回URL列表或其他标识，具体根据实际实现调整
    // private List<String> photoUrls; 
}
