package org.laf.service;

import org.laf.common.constant.NoticeTypeEnum;
import org.laf.model.entity.Notice;

import java.util.List;

public interface NoticeService extends BaseService<Notice> {

    /**
     * 查询有效公告列表（未过期+已生效）
     * @param noticeType 公告类型（可选）
     * @param isTop 是否置顶（可选）
     * @return 公告列表
     */
    List<Notice> listValidNotice(NoticeTypeEnum noticeType, Integer isTop);

    /**
     * 发布公告
     * @param notice 公告实体
     * @return 是否成功
     */
    boolean publishNotice(Notice notice);

    /**
     * 修改公告置顶状态
     * @param noticeId 公告ID
     * @param isTop 是否置顶（0=否，1=是）
     * @return 是否成功
     */
    boolean updateNoticeTopStatus(Long noticeId, Integer isTop);
}
