package com.briup.hblog.web;

import com.briup.hblog.po.Comment;
import com.briup.hblog.po.User;
import com.briup.hblog.service.BlogService;
import com.briup.hblog.service.CommentService;
import com.briup.hblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private BlogService blogService;
    @Autowired
    private UserService userService;


    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model){
        List<Comment> list = commentService.listCommentByBlogId(blogId);
        model.addAttribute("comments",commentService.listCommentByBlogId(blogId));
        model.addAttribute("blog1" ,blogService.getBlog(blogId));
        return "blog :: commentList";
    }
    @PostMapping("/comments")
    public String post( HttpSession session,Comment comment){
        Long blogId = comment.getBlog().getId();
        comment.setBlog(blogService.getBlog(blogId));
        comment.setUser((User) session.getAttribute("userLogin"));
        commentService.saveComment(comment);
        return "redirect:/comments/"+blogId;
    }
}
