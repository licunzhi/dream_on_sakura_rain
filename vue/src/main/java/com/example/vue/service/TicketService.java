package com.example.vue.service;

import com.example.vue.bean.ResponseBean;
import com.example.vue.mapper.LoginMapper;
import com.example.vue.mapper.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName TicketService
 * @Description 一句话描述功能
 * @Author lcz
 * @Date 2019/07/16 20:31
 */
@Service
public class TicketService {

    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private LoginMapper loginMapper;

    public ResponseBean orderTicket(List<HashMap<String, String>> list) {
        /*确认账户信息*/
        HashMap<String, String> accountParams = new HashMap<>();
        accountParams.put("user_id", list.get(0).get("user_id"));
        accountParams.put("user_account", list.get(0).get("user_account"));
        accountParams.put("account_pass", list.get(0).get("account_pass"));
        HashMap<String, String> accountInfo = loginMapper.account(accountParams);
        if (accountInfo == null) {
            return new ResponseBean(HttpStatus.BAD_REQUEST.value(), "失败", "账户信息不正确");
        }

        /*确认账户余额是否充足*/
        int tCount = list.size();
        double moviePrice = Double.parseDouble(list.get(0).get("price"));
        double totalPrice = tCount * moviePrice;
        double accountMoney = Double.parseDouble(String.valueOf(accountInfo.get("account_money")));
        if (accountMoney < totalPrice) {
            return new ResponseBean(HttpStatus.BAD_REQUEST.value(), "失败", "账户余额不足");
        }

        /*扣去订单金额 update*/
        HashMap<String, Object> updateMeneyParams = new HashMap<>();
        double restMoney = accountMoney - totalPrice;
        updateMeneyParams.put("account_money", restMoney);
        updateMeneyParams.put("user_id", list.get(0).get("user_id"));
        int updateResult = loginMapper.updateMoney(updateMeneyParams);
        if (updateResult == 0) {
            return new ResponseBean(HttpStatus.BAD_REQUEST.value(), "失败", "金额扣除失败");
        }

        /*list数据进行处理，为了生成唯一票号*/
        String ticketId = UUID.randomUUID().toString();
        String orderCode = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
        String orderPass = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
        for (HashMap<String, String> hashMap : list) {
            hashMap.put("ticket_id", ticketId);
            hashMap.put("order_code", orderCode);
            hashMap.put("order_pass", orderPass);
        }
        int result = ticketMapper.insertTicketSets(list);
        if (result == 0) {
            return new ResponseBean(HttpStatus.BAD_REQUEST.value(), "失败", "操作失败，稍后重试");
        } else {
            HashMap<String, Object> resultCode = new HashMap<>();
            resultCode.put("order_code", orderCode);
            resultCode.put("order_pass", orderPass);
            return new ResponseBean(HttpStatus.OK.value(), "成功", resultCode);
        }
    }

    public ResponseBean orderSets(HashMap<String, String> params) {
        List<HashMap<String, String>> result = ticketMapper.orderSetsInfo(params);
        return new ResponseBean(HttpStatus.OK.value(), "成功", result);
    }

    public ResponseBean orders(HashMap<String, String> params) {
        List<HashMap<String, String>> result = ticketMapper.orders(params);
        return new ResponseBean(HttpStatus.OK.value(), "成功", result);
    }

}
