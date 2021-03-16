package com.briup.hblog.web.admin;

import com.briup.hblog.po.Tag;

import com.briup.hblog.po.User;
import com.briup.hblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public String tags(@PageableDefault (size=5,sort ={"id"},direction = Sort.Direction.DESC) Pageable pageable, Model model){
        model.addAttribute("page",userService.listUser(pageable));
        return "admin/users";
    }
    @GetMapping("/users/input")
    public String input(Model model){
        model.addAttribute("user",new User());
        return "admin/users_input";
    }
    @GetMapping("/users/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("user",userService.getUser(id));
        return "/admin/users_input";
    }
    @PostMapping("/users")
    public String post(User user,RedirectAttributes attributes){

        User user1 = userService.saveUser(user);
        if (user1 ==null){
            //没保存成功
            attributes.addFlashAttribute("message","新增失败");
        }else{
            //保存成功
            attributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/users";
    }
    @PostMapping("/users/{id}")
    public String editPost(@Valid User user, BindingResult result, Long id, RedirectAttributes attributes){

        User tag1 = userService.updateUser(id,user);
        if (tag1 ==null){
            //没保存成功
            attributes.addFlashAttribute("message","更新失败");
        }else{
            //保存成功
            attributes.addFlashAttribute("message","更新成功");
        }
        return "redirect:/admin/users";
    }
    @GetMapping("/users/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        userService.deleteUser(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/users";
    }
}
