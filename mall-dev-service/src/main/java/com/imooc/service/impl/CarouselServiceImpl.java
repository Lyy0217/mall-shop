package com.imooc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.mapper.CarouselMapper;
import com.imooc.pojo.Carousel;
import com.imooc.pojo.bo.CarouselBO;
import com.imooc.service.CarouselService;

import tk.mybatis.mapper.entity.Example;

/**
 * @author Lyy
 * Created on 2020-09-16
 */
@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Carousel> queryAll(Integer isShow) {

        Example example = new Example(Carousel.class);
        example.orderBy("sort");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isShow", isShow);

        return carouselMapper.selectByExample(example);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Carousel saveCarousel(CarouselBO carouselBO) {
        Carousel carousel = new Carousel();

        carousel.setId(carouselBO.getId());
        carousel.setImageUrl(carouselBO.getImageUrl());
        carousel.setBackgroundColor(carouselBO.getBackgroundColor());
        carousel.setItemId(carouselBO.getItemId());
        carousel.setCatId(carouselBO.getCatId());
        carousel.setType(carouselBO.getType());
        carousel.setIsShow(carouselBO.getIsShow());
        carousel.setSort(carouselBO.getSort());
        carousel.setCreateTime(new Date());
        carousel.setUpdateTime(new Date());

        carouselMapper.insert(carousel);

        return carousel;
    }
}
