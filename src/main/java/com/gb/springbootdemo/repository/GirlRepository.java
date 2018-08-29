package com.gb.springbootdemo.repository;

import com.gb.springbootdemo.bean.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface GirlRepository extends JpaRepository<Girl, Integer> {

    List<Girl> findByAge(Integer age);

    void deleteByAge(Integer age);

    List<Girl> findByAgeAndId(Integer id,Integer age);


}
