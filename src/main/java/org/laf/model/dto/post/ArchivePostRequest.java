package org.laf.model.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class ArchivePostRequest implements Serializable {
    private Long postId;
    private String archiveDesc;
}
