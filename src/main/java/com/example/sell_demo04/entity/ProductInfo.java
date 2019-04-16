package com.example.sell_demo04.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity//表示当前类为实体类
@DynamicUpdate//设置为ture 表示update对象的时候 生成动态的update语句，如果这个字段的值是null就不会加入到update语句中
@Table(name = "product_info")//表名
public class ProductInfo implements Serializable {
    @Id
    private String productId;
    private String productName;//商品名称
    private BigDecimal productPrice;//单价
    private Integer productStock;//库存
    private String productDescription;//描述
    private String productIcon;//小图
    private Integer productStatus;//商品状态0：正常1：下架
    private Integer categoryType;//类目编号
    private Date createTime;//创建时间
    private Date updateTime;//修改时间
}
