package com.example.sell_demo04.service.impl;

import com.example.sell_demo04.common.ResultEnums;
import com.example.sell_demo04.common.ResultResponse;
import com.example.sell_demo04.dto.ProductCategoryDto;
import com.example.sell_demo04.dto.ProductInfoDto;
import com.example.sell_demo04.entity.ProductCategory;
import com.example.sell_demo04.entity.ProductInfo;
import com.example.sell_demo04.repository.ProductCategoryRepository;
import com.example.sell_demo04.repository.ProductInfoRepository;
import com.example.sell_demo04.service.ProductCategoryService;
import com.example.sell_demo04.service.ProductInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Override
    public ResultResponse queryList() {
        List<ProductCategory> categoryList = productCategoryRepository.findAll();
        if (CollectionUtils.isEmpty(categoryList)){
            return ResultResponse.fail();
        }
        //将categoryList转换成dto
        List<ProductCategoryDto> productCategoryDtoList
                = categoryList.stream().map(productCategory -> ProductCategoryDto.build(productCategory)).collect(Collectors.toList());
        //获取类目编号集合
        List<Integer> typeList
                = productCategoryDtoList.stream().map(productCategoryDto -> productCategoryDto.getCategoryType()).collect(Collectors.toList());
        //根据typeList查询商品列表
        List<ProductInfo> productInfoList
                = productInfoRepository.findByProductStatusAndCategoryTypeIn(ResultEnums.PRODUCR_UP.getCode(), typeList);
        //对collect集合进行遍历  取出每个商品的类目编号 设置到对应的目录、
        //将productInfo设置到foods中
        //过滤：不同的type 进行不同的封装
        //将productInfo转成dto
        List<ProductCategoryDto> categoryDtoList = productCategoryDtoList.parallelStream().map(productCategoryDto -> {
            productCategoryDto.setProductInfoDtoList(productInfoList.stream()
                    .filter(productInfo -> productInfo.getCategoryType() == productCategoryDto.getCategoryType())
                    .map(productInfo -> ProductInfoDto.build(productInfo)).collect(Collectors.toList()));
            return productCategoryDto;
        }).collect(Collectors.toList());
        return ResultResponse.success(categoryDtoList);
    }
}
