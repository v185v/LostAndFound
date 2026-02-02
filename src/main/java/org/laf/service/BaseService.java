package org.laf.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.laf.model.entity.BaseEntity;

public interface BaseService<T extends BaseEntity> extends IService<T> {
}
