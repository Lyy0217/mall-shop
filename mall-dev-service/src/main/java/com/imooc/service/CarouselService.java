package com.imooc.service;

import java.util.List;

import com.imooc.pojo.Carousel;
import com.imooc.pojo.bo.CarouselBO;

/**
 * @author Lyy
 * Created on 2020-09-16
 */
public interface CarouselService {
    List<Carousel> queryAll(Integer isShow);

    Carousel saveCarousel(CarouselBO carouselBO);
}
