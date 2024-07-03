package com.hodolog.api.repository.post;

import com.hodolog.api.domain.Post;
import com.hodolog.api.request.post.PostSearch;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostRepositoryCustom {

    Page<Post> getList(PostSearch postSearch);
}
