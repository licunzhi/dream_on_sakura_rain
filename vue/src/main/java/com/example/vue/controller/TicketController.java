package com.example.vue.controller;

import com.example.vue.bean.ResponseBean;
import com.example.vue.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName TicketController
 * @Description 购票定座
 * @Author lcz
 * @Date 2019/07/16 20:30
 */
@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/orderTicket")
    private ResponseBean orderTicket(@RequestBody List<HashMap<String, String>> list) {
        return ticketService.orderTicket(list);
    }

    @PostMapping("/orderSets")
    private ResponseBean orderSets(@RequestBody HashMap<String, String> params) {
        return ticketService.orderSets(params);
    }

    @PostMapping("/orders")
    private ResponseBean orders(@RequestBody HashMap<String, String> params) {
        return ticketService.orders(params);
    }
}
