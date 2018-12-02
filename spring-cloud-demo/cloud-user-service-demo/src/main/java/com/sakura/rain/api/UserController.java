package com.sakura.rain.api;

import com.sakura.rain.entity.User;
import com.sakura.rain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author licunzhi
 * @desc 用户控制层
 * @date 2018-11-29
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/get/{id}")
    public User get(@PathVariable Long id) {
        return userService.get(id);
    }

    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }

    @PostMapping("/create")
    public boolean create(@RequestBody User user) {
        return userService.add(user);
    }

    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("CLOUD-USER-SERVICE-DEMO");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                            + element.getUri());
        }
        return this.client;
    }
}
