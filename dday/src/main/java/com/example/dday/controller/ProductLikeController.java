package com.example.dday.controller;

import com.example.dday.domain.vo.CartVO;
import com.example.dday.domain.vo.ProductLikeVO;
import com.example.dday.service.ProductLikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.example.dday.domain.vo.MemberVO;
import com.example.dday.domain.vo.ProductLikeDTO;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpSession;


@RestController
@RequiredArgsConstructor
@RequestMapping("/productlike/*")
@Slf4j
public class ProductLikeController {
    private final ProductLikeService productLikeService;

    @GetMapping("/list")
    public ProductLikeDTO list(HttpSession session){
        Long memberNumber = ((MemberVO)session.getAttribute("member")).getMemberNumber();
        return new ProductLikeDTO(productLikeService.list(memberNumber), productLikeService.findCountAll(memberNumber));
    }

    @DeleteMapping("/{productNumber}")
    public void remove(@PathVariable Long productNumber, HttpSession session){
        Long memberNumber = ((MemberVO)session.getAttribute("member")).getMemberNumber();
        session.setAttribute("likeTotal", productLikeService.findCountAll(memberNumber));
        productLikeService.remove(productNumber, memberNumber);
    }

    // 찜목록 담기
    @ResponseBody
    @RequestMapping(value = "/addLike", method = RequestMethod.POST)
    public void addCart(ProductLikeVO productLikeVO, HttpSession session){
        log.info("productLikeVO :" + productLikeVO);
        MemberVO memberVO = ((MemberVO)session.getAttribute("member"));
        productLikeVO.setMemberNumber((memberVO.getMemberNumber()));

        productLikeService.save(productLikeVO);

    }
}


