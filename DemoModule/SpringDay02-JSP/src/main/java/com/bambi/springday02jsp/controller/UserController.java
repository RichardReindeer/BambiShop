package com.bambi.springday02jsp.controller;

import com.bambi.springday02jsp.domain.dao.User;
import com.bambi.springday02jsp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedList;
import java.util.List;

/**
 * 描述：user控制器类
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/8/27 16:26    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */
@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/findAll")
    public String findAll(Model model){
        List<User> userList = userMapper.selectList(null);
        model.addAttribute("userList",userList);
        return "userList";
    }
}
