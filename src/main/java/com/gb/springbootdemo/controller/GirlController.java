package com.gb.springbootdemo.controller;

import com.gb.springbootdemo.bean.Result;
import com.gb.springbootdemo.utils.ResultUtil;
import com.gb.springbootdemo.repository.GirlRepository;
import com.gb.springbootdemo.bean.Girl;
import com.gb.springbootdemo.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    public static final Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 添加用户
     *
     * @return
     */
    @PostMapping(value = "/girl")
    public Object addGirl(@Valid Girl girl, BindingResult bindingResult) {
        logger.info("age = " + girl.getAge() + ", cupSize = " + girl.getCupSize());

        if (bindingResult.hasErrors()) {
            return ResultUtil.error(100, bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultUtil.success("添加成功", girlRepository.save(girl));

//        Result result = new Result();
//        if (bindingResult.hasErrors()){
//            result.setCode(1);
//            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
//            return result;
//        }
//        result.setData(girlRepository.save(girl));
//        //可以不需要先set
////        girl.setAge(girl.getAge());
////        girl.setCupSize(girl.getCupSize());
//        return result;
    }

    /**
     * 更新用户
     *
     * @return
     */
    @PostMapping(value = "/girl/{id}")
    public Result updateGirl(@Valid Girl girl, BindingResult bindingResult) {
        logger.info("age = " + girl.getAge() + ", cupSize = " + girl.getCupSize());

        if (bindingResult.hasErrors()) {
            return ResultUtil.error(100, bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultUtil.success("更新成功", girlRepository.save(girl));
    }

    /**
     * 插入2个数据  测试回滚
     */
    @PostMapping("/girl/two")
    public void insertTwo() {

        girlService.insertTwoGirl();
    }

    /**
     * 查询某个女生
     *
     * @return
     */
    @GetMapping(value = "/girl/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findById(id).get();
    }

    /**
     * 查询所有女生
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public Result queryAllGirl() {
        return ResultUtil.success("查询所有女生成功", girlRepository.findAll());
    }


    @GetMapping(value = "/girls/{id}")
    public void queryOneGirl(@PathVariable("id") Integer id) throws Exception {
        girlService.findOne(id);
    }

    @GetMapping(value = "/girl/age/{age}")
    public void removeGirl(@PathVariable("age") Integer age) {
        girlRepository.deleteByAge(age);
    }

    @GetMapping(value = "/girl/age/query/{age}")
    public Result queryGirlByAge(@PathVariable("age") Integer age) {
        List<Girl> girls = girlRepository.findByAge(age);
        return ResultUtil.success("通过年龄查询成功", girls);
    }

    @PostMapping(value = "/girl/find")
    public Result queryGirlByAgeAndId(@RequestParam("id") Integer id, @RequestParam("age") Integer age,BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return ResultUtil.error(100, bindingResult.getFieldError().getDefaultMessage());
        }

        List<Girl> girls = girlRepository.findByAgeAndId(id, age);
        return ResultUtil.success("success", girls);
    }

}
