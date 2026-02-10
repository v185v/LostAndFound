package org.laf.controller;

import org.laf.common.constant.ClaimApplyStatusEnum;
import org.laf.common.result.AjaxResult;
import org.laf.model.entity.PostAttachment;
import org.laf.service.PostAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postAttachment")
public class PostAttachmentController {

    @Autowired
    private PostAttachmentService postAttachmentService;

    @GetMapping("/{id}")
    public AjaxResult<PostAttachment> getById(@PathVariable Long id) {
        return AjaxResult.success(postAttachmentService.getById(id));
    }

    @GetMapping("/listByPost/{postId}")
    public AjaxResult<List<PostAttachment>> listByPost(@PathVariable Long postId) {
        return AjaxResult.success(postAttachmentService.listByPostId(postId));
    }

    @GetMapping("/listByApplicant")
    public AjaxResult<List<PostAttachment>> listByApplicant(@RequestParam Long applicantAccountId,
                                                            @RequestParam ClaimApplyStatusEnum applyStatus) {
        return AjaxResult.success(postAttachmentService.listByApplicantIdAndStatus(applicantAccountId, applyStatus));
    }

    @PostMapping("/apply")
    public AjaxResult<Boolean> apply(@RequestBody PostAttachment postAttachment) {
        return AjaxResult.success(postAttachmentService.save(postAttachment));
    }

    @PostMapping("/audit")
    public AjaxResult<Boolean> audit(@RequestParam Long id,
                                     @RequestParam Long auditorId,
                                     @RequestParam String auditorName,
                                     @RequestParam ClaimApplyStatusEnum applyStatus,
                                     @RequestParam(required = false) String auditOpinion) {
        return AjaxResult.success(postAttachmentService.auditClaimApply(id, auditorId, auditorName, applyStatus, auditOpinion));
    }
}
