package com.example.dday.domain.vo;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CartDTO {
    private Long memberNumber;
    private Long productNumber;
    private Integer cartCount;
    private String productName;
    private Long productSalePrice;
    private String addressMain;
    private String addressDetail;
}
