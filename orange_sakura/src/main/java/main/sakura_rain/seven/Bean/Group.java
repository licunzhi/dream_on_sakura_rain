package main.sakura_rain.seven.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Group
 * @function [组概念]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/06/05 14:24
 */
public class Group implements Serializable {

    private static final long serialVersionUID = 4965889092456607846L;

    private String uuid;
    private String name;
    private String desc;

    private List<Team> teams;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
