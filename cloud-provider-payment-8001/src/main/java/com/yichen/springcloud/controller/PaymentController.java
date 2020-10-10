package com.yichen.springcloud.controller;

import com.yichen.springcloud.entities.CommonResult;
import com.yichen.springcloud.entities.Payment;
import com.yichen.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(Payment payment){
        int result= paymentService.create(payment);
        log.info("----插入结果-----"+result);
        if(result>0){
            return new CommonResult(200,"插入成功",result);
        }else{
            return new CommonResult(444,"插入失败",null);
        }
    }

    public CommonResult getPaymentById(Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("----查询结果----"+payment);
        if(payment==null){
            return new CommonResult(444,"查询失败"+id,null);
        }else{
            return new CommonResult(200,"查询成功",payment);
        }
    }



}
