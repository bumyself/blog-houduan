package com.linminrui.blog.dao;

import com.linminrui.blog.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public class TypeRespository extends JpaRepository<Type,Long>{
    Type findByName(String name);

    @Query("select t from Type_t")
    List<Type> findTop(Pageable pageable);


}
