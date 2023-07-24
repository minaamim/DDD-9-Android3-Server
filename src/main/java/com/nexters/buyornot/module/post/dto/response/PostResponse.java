package com.nexters.buyornot.module.post.dto.response;

import com.nexters.buyornot.module.post.domain.Post;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
@Getter
public class PostResponse {
    private Long id;
    private String userId;
    private String userNickname;
    private String title;
    private String content;
    private String publicStatus;
    private String pollStatus;
    private List<PollItemResponse> pollItemResponseList;

    public PostResponse(Long id, String userId, String userNickname, String title, String content, String publicStatus, String pollStatus, List<PollItemResponse> pollItems) {
        this.id = id;
        this.userId = userId;
        this.userNickname = userNickname;
        this.title = title;
        this.content = content;
        this.publicStatus = publicStatus;
        this.pollStatus = pollStatus;
        this.pollItemResponseList = pollItems;
    }

    public PostResponse(Post post) {
        this.id = post.getId();
    }
}
