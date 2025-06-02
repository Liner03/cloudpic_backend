package com.lin.cloudpicbackend.model.vo;


import com.lin.cloudpicbackend.model.entity.Tag;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * tag
 */
@Data
public class TagVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * tag id
     */
    private Long id;

    /**
     * tag 名称
     */
    private String name;

    /**
     * tag 描述
     */
    private String description;

    /**
     * tag 类型 hot normal system
     */
    private String type;

    /**
     * 使用次数
     */
    private Long usageCount;

    /**
     * 对象转封装类
     */
    public static TagVO objToVo(Tag tag) {
        if (tag == null) {
            return null;
        }
        TagVO tagVO = new TagVO();
        BeanUtils.copyProperties(tag, tagVO);
        return tagVO;
    }
}
