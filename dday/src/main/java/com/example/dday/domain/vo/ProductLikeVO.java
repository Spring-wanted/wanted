package com.example.dday.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ProductLikeVO {
    private Long productNumber;
    private Long memberNumber;

    public void create(Long productNumber, Long memberNumber){
        this.productNumber = productNumber;
        this.memberNumber = memberNumber;
    }
}
