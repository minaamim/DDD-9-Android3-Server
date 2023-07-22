package com.nexters.buyornot.module.post.domain;

import com.nexters.buyornot.module.model.BaseEntity;
import com.nexters.buyornot.module.model.Price;
import com.nexters.buyornot.module.post.dto.response.PollItemResponse;
import com.nexters.buyornot.module.post.dto.response.PostResponse;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PollItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "poll_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    private String itemUrl;

    private String itemName;

    @Embedded
    private Price itemPrice;

    @Lob
    private String imgUrl;

    public static PollItem newPollItem(String itemName, Price itemPrice, String itemUrl, String imgUrl) {
        return builder()
                .itemName(itemName)
                .itemPrice(itemPrice)
                .itemUrl(itemUrl)
                .imgUrl(imgUrl)
                .build();
    }

    public void belong(Post post) {
        this.post = post;
    }

    public PollItemResponse newPollItemResponse() {
        return new PollItemResponse(this.id, this.itemUrl, this.itemName, this.imgUrl, this.itemPrice.getValue(), this.itemPrice.getDiscountRate(), this.itemPrice.getDiscountedPrice());
    }
}
