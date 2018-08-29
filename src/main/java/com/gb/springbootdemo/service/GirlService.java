package com.gb.springbootdemo.service;

import com.gb.springbootdemo.bean.Girl;
import com.gb.springbootdemo.enums.ResultEnums;
import com.gb.springbootdemo.exception.GirlException;
import com.gb.springbootdemo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {
    @Autowired
    GirlRepository girlRepository;

    @Transactional
    public void insertTwoGirl() {
        Girl girlA = new Girl();
        girlA.setAge(55);
        girlA.setCupSize("A");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(5);
        girlB.setCupSize("C");
        girlRepository.save(girlB);

    }

    public void findOne(Integer id) throws Exception {
        Girl girl = girlRepository.findById(id).get();

        Integer age = girl.getAge();

//        if (age < 15) {
//            throw new GirlException(ResultEnums.PRIMARYSCHOOL);
//        } else if (age > 18) {
//            throw new GirlException(ResultEnums.HIGHSCHOOL);
//        }

    }

    public void deleteByAge(Integer age) {
        girlRepository.deleteByAge(age);
    }


}
