package com.lin.cloudpicbackend.service;

import com.lin.cloudpicbackend.model.dto.user.avatar.UserAvatarUploadRequest;
import com.lin.cloudpicbackend.model.entity.User;
import com.lin.cloudpicbackend.model.entity.UserAvatar;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.cloudpicbackend.model.vo.UserAvatarVO;
import org.springframework.web.multipart.MultipartFile;


public interface UserAvatarService extends IService<UserAvatar> {
    /**
     * 用户头像上传
     */
    UserAvatarVO uploadAvatar(MultipartFile multipartFile, UserAvatarUploadRequest userAvatarUploadRequest, User loginUser);
}
