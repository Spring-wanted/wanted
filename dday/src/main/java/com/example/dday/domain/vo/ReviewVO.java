package com.example.dday.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ReviewVO {
    private Long reviewNumber;
    private String reviewContent;
    private String reviewRegistDate;
    private String reviewUpdateDate;
    private Long productNumber;
    private Long orderDetailNumber;
}
