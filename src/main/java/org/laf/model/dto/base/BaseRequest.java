package org.laf.model.dto.base;

import lombok.Data;
import java.io.Serializable;

@Data
public class BaseRequest implements Serializable {
    /**
     * 当前页码
     */
    private Integer pageNum = 1;

    /**
     * 每页数量
     */
    private Integer pageSize = 10;
}
