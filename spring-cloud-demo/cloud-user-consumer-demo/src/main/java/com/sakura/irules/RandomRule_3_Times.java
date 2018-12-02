package com.sakura.irules;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-12-02
 */
public class RandomRule_3_Times extends AbstractLoadBalancerRule {
    // total = 0 // 当total==5以后，我们指针才能往下走，
    // index = 0 // 当前对外提供服务的服务器地址，
    // total需要重新置为零，但是已经达到过一个5次，我们的index = 1
    // 分析：我们5次，但是微服务只有8001 8002 8003 三台，OK？
    //


    private int total = 0; 			// 统计调用的次数
    private int currentIndex = 0;	// 当前机器的标记, 默认开始的机器是第一个

    public Server choose(ILoadBalancer lb, Object key)
    {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                如果没有找到存活状态的直接返回
                 */
                return null;
            }

            /*源代码中的实际上采用的实际java中的随意函数结果去得到随机访问的哪一个*/
            //			int index = rand.nextInt(serverCount);// java.util.Random().nextInt(3);
            //			server = upList.get(index);

            /*
            * 如果调用的次数小于3
            * 下次调用的时候还是调用这个
            * 调用次数累加一次
            * */
            if(total < 3)
            {
                server = upList.get(currentIndex);
                total++;
            }else {
                /*
                * 如果调用的次数大于三次
                * 清空计数
                * 换一个机器编号重新调用
                * 如果切换的机器编号不存在  重新调用初始化第一个可以调用的机器
                * */
                total = 0;
                currentIndex++;
                if(currentIndex >= upList.size())
                {
                    currentIndex = 0;
                }
            }


            if (server == null) {
                /*
                 * The only time this should happen is if the server list were somehow trimmed.
                 * This is a transient condition. Retry after yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    @Override
    public Server choose(Object key)
    {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig)
    {
        // TODO Auto-generated method stub

    }
}
