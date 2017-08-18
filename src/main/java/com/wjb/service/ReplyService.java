package com.wjb.service;


import java.util.List;

import com.wjb.db.po.Reply;

public interface ReplyService {
	
    public void addReply(Reply reply);

    public List<Reply> listReplyByPostId(int postId);

    public void deleteReply(int replyId);
}
