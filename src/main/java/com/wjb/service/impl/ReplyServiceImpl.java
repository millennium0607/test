package com.wjb.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wjb.db.dao.PostMapper;
import com.wjb.db.dao.ReplyMapper;
import com.wjb.db.po.Post;
import com.wjb.db.po.Reply;
import com.wjb.db.po.ReplyExample;
import com.wjb.service.ReplyService;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    ReplyMapper replyMapper;

    @Autowired
    PostMapper postMapper;

    @Override
    public void addReply(Reply reply) {
    	// 更新post信息
        Reply dbReply = reply;
        int postId = reply.getReplyPostId();
        Post post = postMapper.selectByPrimaryKey(postId);
        post.setPostReplyCount(post.getPostReplyCount() + 1);
        postMapper.updateByPrimaryKeySelective(post);

        // 添加回复
        dbReply.setReplyCreateTime(new Timestamp(new Date().getTime()));
        replyMapper.insertSelective(dbReply);
        }

    @Override
    public List<Reply> listReplyByPostId(int replyPostId) {
    	ReplyExample example =new ReplyExample();
    	example.createCriteria().andReplyPostIdEqualTo(replyPostId);
        return replyMapper.selectByExample(example);
    }

    @Override
    public void deleteReply(int replyId) {
    	// 更新post信息
        Reply reply = replyMapper.selectByPrimaryKey(replyId);
        Post post = postMapper.selectByPrimaryKey(reply.getReplyPostId());
        post.setPostReplyCount(post.getPostReplyCount() - 1);
        postMapper.updateByPrimaryKeySelective(post);
        // 删除回复
        replyMapper.deleteByPrimaryKey(replyId);
    }
}
