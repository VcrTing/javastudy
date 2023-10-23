package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

public class Roie {
    private Integer id;
    private String name;

    private List<User> users;

    public Roie() {
    }

    public Roie(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * 设置
     * @param users
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String toString() {
        return "Roie{id = " + id + ", name = " + name + ", users = " + users + "}";
    }
}
