package main.sakura_rain.seven.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Project
 * @function [项目信息]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/06/05 14:22
 */
public class Project implements Serializable {

    private static final long serialVersionUID = -5136141770819438627L;

    private String uuid;
    private String name;
    private String desc;

    private List<Group> groups;


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

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
