package com.example.sell_demo04.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity//表示当前类为实体类
@DynamicUpdate//设置为ture 表示update对象的时候 生成动态的update语句，如果这个字段的值是null就不会加入到update语句中
@Table(name = "product_category")//表名
public class ProductCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//表示自增IDENTITY：mysql SEQUENCE:oracle
    private Integer categoryId;
//    类目名字
    private String  categoryName;
    //类目编号
    private Integer categoryType;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
}
