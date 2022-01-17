package com.dexlace.annotation.case7.controller;

import com.dexlace.annotation.case7.annotation.RequiredPermission;
import com.dexlace.annotation.case7.constant.PermissionConstants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/product")
// @PermissionConstants.ADMIN_PRODUCT_MANAGEMENT
public class PermissionController {

    /**
     * 产品列表
     *
     */
    @RequestMapping("/list")
    @RequiredPermission(PermissionConstants.ADMIN_PRODUCT_LIST) // 权限注解
    public String list() {
        // 省略产品列表查询逻辑
        return "list";
    }

    /**
     * 产品详情
     */
    @RequestMapping("/detail")
    @RequiredPermission(PermissionConstants.ADMIN_PRODUCT_DETAIL) // 权限注解
    public String detail() {
        // 省略查询产品详情的逻辑
        return "detail";
    }

    /**
     * 删除产品
     *
     */
    @RequestMapping("/delete")
    public String delete() {
        // 省略删除产品的逻辑
        return "delete";
    }
}
