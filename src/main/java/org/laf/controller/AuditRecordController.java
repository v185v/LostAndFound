package org.laf.controller;

import org.laf.common.constant.AuditTypeEnum;
import org.laf.common.result.AjaxResult;
import org.laf.model.entity.AuditRecord;
import org.laf.service.AuditRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auditRecord")
public class AuditRecordController {

    @Autowired
    private AuditRecordService auditRecordService;

    @GetMapping("/{id}")
    public AjaxResult<AuditRecord> getById(@PathVariable Long id) {
        return AjaxResult.success(auditRecordService.getById(id));
    }

    @GetMapping("/listByTarget")
    public AjaxResult<List<AuditRecord>> listByTarget(@RequestParam Long targetId, @RequestParam AuditTypeEnum auditType) {
        return AjaxResult.success(auditRecordService.listByTargetIdAndAuditType(targetId, auditType));
    }

    @PostMapping("/save")
    public AjaxResult<Boolean> save(@RequestBody AuditRecord auditRecord) {
        return AjaxResult.success(auditRecordService.saveAuditRecord(auditRecord));
    }
}
