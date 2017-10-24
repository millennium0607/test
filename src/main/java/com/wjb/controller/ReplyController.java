package com.wjb.controller;

import com.wjb.db.po.Reply;
import com.wjb.service.ReplyService;
import com.wjb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/reply")
public class ReplyController {
    @Autowired
    ReplyService replyService;

    @Autowired
    UserService userService;

    // Ìí¼Ó»Ø¸´
    @RequestMapping(value = "addReply", method = RequestMethod.POST)
    public String addReply(Reply reply, HttpServletRequest request) {
        replyService.addReply(reply);
        return "redirect:/post/postContent-" + reply.getReplyPostId();
    }
}
