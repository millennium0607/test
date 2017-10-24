package com.wjb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wjb.db.dao.PostMapper;
import com.wjb.db.po.Post;
import com.wjb.db.po.PostExample;
import com.wjb.service.PostService;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostMapper postMapper;

    @Override
    public void addPostByPost(Post post) {
    	postMapper.insert(post);
    }

    @Override
    public Post listPostContent(int postId) {
        return postMapper.selectByPrimaryKey(postId);
    }

    @Override
    public List<Post> listAllPost() {
        return postMapper.selectByExample(null);
    }

    @Override
    public void deletePost(int postId) {
        postMapper.deleteByPrimaryKey(postId);
    }

	@Override
	public void updatePoset(Post post) {
		postMapper.updateByPrimaryKeySelective(post);
		
	}

	@Override
	public List<Post> getOuttimePostList(Date date) {
		PostExample example = new PostExample();
		example.createCriteria().andPostCreateTimeLessThanOrEqualTo(date);
		List<Post> selectByExample = postMapper.selectByExample(example);
		return selectByExample;
	}
    
}
