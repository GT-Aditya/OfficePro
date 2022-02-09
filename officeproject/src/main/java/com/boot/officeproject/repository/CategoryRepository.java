package com.boot.officeproject.repository;

import com.boot.officeproject.model.categorymodel.CategoryBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<CategoryBean, String> {
    

    @Query(value = "select concat('CATE',REPLICATE(0,4-len(isNull(max(cast(convert(varchar,substring(category_code,5,15))as int)),1)+1)),isNull(max(cast(convert(varchar, substring(category_code, 5, 15)) as int)),0)+1) from Category", nativeQuery =true)
    public String findCategoryCode();

    @Query(value = "select count(name) from category where name =:n", nativeQuery = true)
    public int exitsOrNot(@Param("n") String name);
}
