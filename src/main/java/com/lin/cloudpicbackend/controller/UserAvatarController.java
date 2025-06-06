package com.lin.cloudpicbackend.controller;


import com.lin.cloudpicbackend.annotation.AuthCheck;
import com.lin.cloudpicbackend.common.BaseResponse;
import com.lin.cloudpicbackend.common.ResultUtils;
import com.lin.cloudpicbackend.constant.UserConstant;
import com.lin.cloudpicbackend.exception.ErrorCode;
import com.lin.cloudpicbackend.exception.ThrowUtils;
import com.lin.cloudpicbackend.model.dto.user.avatar.UserAvatarUploadRequest;
import com.lin.cloudpicbackend.model.entity.User;
import com.lin.cloudpicbackend.model.vo.UserAvatarVO;
import com.lin.cloudpicbackend.service.UserAvatarService;
import com.lin.cloudpicbackend.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/user/avatar")
@AuthCheck(mustRole = UserConstant.USER_LOGIN_STATE)
public class UserAvatarController {

    @Resource
    private UserAvatarService userAvatarService;

    @Resource
    private UserService userService;

    /**
     * 用户头像上传
     * @param multipartFile
     * @param userAvatarUploadRequest
     * @param request
     * @return
     */
    @PostMapping("/upload")
    public BaseResponse<UserAvatarVO> uploadAvatar(@RequestPart("file") MultipartFile multipartFile,
                                                   UserAvatarUploadRequest userAvatarUploadRequest,
                                                   HttpServletRequest request) {
        ThrowUtils.throwIf(multipartFile.isEmpty(), ErrorCode.PARAMS_ERROR);
        User loginUser = userService.getLoginUser(request);
        UserAvatarVO userAvatarVO = userAvatarService.uploadAvatar(multipartFile, userAvatarUploadRequest, loginUser);
        return ResultUtils.success(userAvatarVO);
    }

}
