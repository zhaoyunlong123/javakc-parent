package com.javakc.pms.dispord.controller;

import com.javakc.commonutils.api.APICODE;
import org.springframework.web.bind.annotation.*;

/**
 * @program: javakc-parent
 * @Description: 前后交互
 * @Author: zhao yun long
 * @date: 2020/11/25 17:22
 */
@RestController
@RequestMapping("/pms/user")
//@CrossOrigin // 解决跨域问题
public class LoginController {

    @PostMapping("login")
    public APICODE login() {
        return APICODE.ok().data("token", "admin");
    }

    @GetMapping("info")
    public APICODE info() {
        return APICODE.ok().data("roles", "[admin]").data("name", "admin").data("avatar", "http://img0.imgtn.bdimg.com/it/u=1782959667,617309577&fm=26&gp=0.jpg");
    }

}
