package org.laf.controller;

import org.laf.common.constant.PostStatusEnum;
import org.laf.common.constant.PostTypeEnum;
import org.laf.common.result.AjaxResult;
import org.laf.model.entity.Post;
import org.laf.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public AjaxResult<Post> getById(@PathVariable Long id) {
        return AjaxResult.success(postService.getById(id));
    }

    @PostMapping("/publish")
    public AjaxResult<Boolean> publish(@RequestBody Post post) {
        return AjaxResult.success(postService.save(post));
    }

    @PutMapping("/update")
    public AjaxResult<Boolean> update(@RequestBody Post post) {
        return AjaxResult.success(postService.updateById(post));
    }

    @DeleteMapping("/{id}")
    public AjaxResult<Boolean> delete(@PathVariable Long id) {
        return AjaxResult.success(postService.removeById(id));
    }

    @GetMapping("/listByAccount")
    public AjaxResult<List<Post>> listByAccount(@RequestParam Long accountId, @RequestParam PostTypeEnum postType) {
        return AjaxResult.success(postService.listByAccountIdAndType(accountId, postType));
    }

    @GetMapping("/listByStatus")
    public AjaxResult<List<Post>> listByStatus(@RequestParam PostStatusEnum postStatus, @RequestParam(required = false) PostTypeEnum postType) {
        return AjaxResult.success(postService.listByStatusAndType(postStatus, postType));
    }

    @PostMapping("/audit")
    public AjaxResult<Boolean> audit(@RequestParam Long postId,
                                     @RequestParam Long auditorAccountId,
                                     @RequestParam String auditorName,
                                     @RequestParam PostStatusEnum postStatus,
                                     @RequestParam(required = false) String rejectReason) {
        return AjaxResult.success(postService.auditPost(postId, auditorAccountId, auditorName, postStatus, rejectReason));
    }

    @PostMapping("/archive")
    public AjaxResult<Boolean> archive(@RequestParam Long postId, @RequestParam String archiveDesc) {
        return AjaxResult.success(postService.archivePost(postId, archiveDesc));
    }
}
