package com.lin.cloudpicbackend.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.lin.cloudpicbackend.model.dto.category.CategoryQueryRequest;
import com.lin.cloudpicbackend.model.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.cloudpicbackend.model.vo.CategoryVO;

import java.util.List;

public interface CategoryService extends IService<Category> {

    /**
     * 获取VO
     * @param list
     * @return
     */
    List<CategoryVO> getVOByList(List<Category> list);

    /**
     * 根据 categoryQueryRequest 快速构建 QueryWrapper
     * @param categoryQueryRequest
     * @return
     */
    Wrapper<Category> getQueryWrapper(CategoryQueryRequest categoryQueryRequest);
}
