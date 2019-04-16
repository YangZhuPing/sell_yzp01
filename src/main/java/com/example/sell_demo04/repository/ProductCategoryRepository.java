package com.example.sell_demo04.repository;

import com.example.sell_demo04.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
//第一个泛型是实体类型，第二个是主键类型
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

}
