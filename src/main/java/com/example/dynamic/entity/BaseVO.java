package com.example.dynamic.entity;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.dynamic.util.CamelUnderlineTransformerUtil;

public class BaseVO {

    // 是否使用悲观锁
    private Boolean forUpdate;
    // 根据哪个字段进行排序
    private String sortBy;
    // 排序方向，案例：ASC、DESC
    private String direction;

    public Boolean getForUpdate() {
        return forUpdate;
    }

    public void setForUpdate(Boolean forUpdate) {
        this.forUpdate = forUpdate;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        if (StringUtils.isNotBlank(sortBy)) {
            sortBy = CamelUnderlineTransformerUtil.camelToUnderline(sortBy);
        }
        this.sortBy = sortBy;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        if (StringUtils.isNotBlank(direction)) {
            direction = CamelUnderlineTransformerUtil.camelToUnderline(direction);
        }
        this.direction = direction;
    }


}
