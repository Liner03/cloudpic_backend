package com.lin.cloudpicbackend.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.cloudpicbackend.model.dto.category.CategoryQueryRequest;
import com.lin.cloudpicbackend.model.entity.Category;
import com.lin.cloudpicbackend.model.vo.CategoryVO;
import com.lin.cloudpicbackend.service.CategoryService;
import com.lin.cloudpicbackend.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

    @Override
    public List<CategoryVO> getVOByList(List<Category> list) {
        if (list == null || list.isEmpty()) return new ArrayList<>();
        return list.stream().map(category ->
                new CategoryVO(category.getId(), category.getName(), category.getDescription(), category.getCreateTime())).collect(Collectors.toList());

    }

    @Override
    public Wrapper<Category> getQueryWrapper(CategoryQueryRequest categoryQueryRequest) {
        if (categoryQueryRequest == null) return null;
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(categoryQueryRequest.getName())) {
            queryWrapper.like("name", categoryQueryRequest.getName());
        }
        if (StrUtil.isNotBlank(categoryQueryRequest.getDescription())) {
            queryWrapper.like("description", categoryQueryRequest.getDescription());
        }
        return queryWrapper;
    }
}




