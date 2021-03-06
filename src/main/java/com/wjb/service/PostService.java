package com.wjb.service;


import java.util.Date;
import java.util.List;

import com.wjb.db.po.Post;

public interface PostService {
	
    public void addPostByPost(Post post);

    public Post listPostContent(int postId);

    public List<Post> listAllPost();

    public void deletePost(int postId);
    
    void updatePoset(Post post);
    
    List<Post> getOuttimePostList(Date date);
}
