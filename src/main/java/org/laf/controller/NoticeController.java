package org.laf.controller;

import org.laf.common.constant.NoticeTypeEnum;
import org.laf.common.result.AjaxResult;
import org.laf.model.entity.Notice;
import org.laf.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/{id}")
    public AjaxResult<Notice> getById(@PathVariable Long id) {
        return AjaxResult.success(noticeService.getById(id));
    }

    @GetMapping("/listValid")
    public AjaxResult<List<Notice>> listValid(@RequestParam(required = false) NoticeTypeEnum noticeType,
                                              @RequestParam(required = false) Integer isTop) {
        return AjaxResult.success(noticeService.listValidNotice(noticeType, isTop));
    }

    @PostMapping("/publish")
    public AjaxResult<Boolean> publish(@RequestBody Notice notice) {
        return AjaxResult.success(noticeService.publishNotice(notice));
    }

    @PutMapping("/update")
    public AjaxResult<Boolean> update(@RequestBody Notice notice) {
        return AjaxResult.success(noticeService.updateById(notice));
    }

    @DeleteMapping("/{id}")
    public AjaxResult<Boolean> delete(@PathVariable Long id) {
        return AjaxResult.success(noticeService.removeById(id));
    }

    @PostMapping("/updateTopStatus")
    public AjaxResult<Boolean> updateTopStatus(@RequestParam Long noticeId, @RequestParam Integer isTop) {
        return AjaxResult.success(noticeService.updateNoticeTopStatus(noticeId, isTop));
    }
}
