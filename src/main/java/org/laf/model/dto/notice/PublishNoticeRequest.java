package org.laf.model.dto.notice;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.laf.common.constant.NoticeTypeEnum;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class PublishNoticeRequest implements Serializable {
    /*
    公告标题
     */
    @Size(min=1, max=40,message = "标题长度必须在1-40之间")
    private String title;

    /*
    公告内容
     */
    @NotBlank(message = "内容不能为空")
    private String content;

    /*
    公告类型
     */
    private NoticeTypeEnum noticeType;

    private Long publisherId;

    private String publisherName;

    /*
    生效期
     */
    private LocalDateTime effectiveTime;

    /*
    失效期
     */
    private LocalDateTime invalidTime;

    /*
    是否置顶
     */
    private Integer isTop;
}
