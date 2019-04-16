package com.example.sell_demo04.dto;

import com.example.sell_demo04.entity.ProductInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfoDto implements Serializable {
    @JsonProperty("id")//注解的意思是：返回的json的属性名跟要求的属性名不一样 我们就用这个注解配置
    private String productId;
    @JsonProperty("name")
    private String productName;
    @JsonProperty("price")
    private BigDecimal productPrice;//单价
    @JsonProperty("description")
    private String productDescription;
    @JsonProperty("icon")
    private String productIcon;
    public static  ProductInfoDto build(ProductInfo productInfo){
        ProductInfoDto productInfoDto = new ProductInfoDto();
        //复制属性
        BeanUtils.copyProperties(productInfo,productInfoDto );
        return productInfoDto;
    }

}
