package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String creatAt;

    private Integer roieId;
    private Roie roie;

    public User (String username, String password) { this.username = username; this.password = password; }


    public User(Integer id, String username, String password, String nickname, String email, String creatAt, Integer roieId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.creatAt = creatAt;
        this.roieId = roieId;
    }

    public User() {
    }

    public User(Integer id, String username, String password, String nickname, String email, String creatAt, Integer roieId, Roie roie) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.creatAt = creatAt;
        this.roieId = roieId;
        this.roie = roie;
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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取
     * @return creatAt
     */
    public String getCreatAt() {
        return creatAt;
    }

    /**
     * 设置
     * @param creatAt
     */
    public void setCreatAt(String creatAt) {
        this.creatAt = creatAt;
    }

    /**
     * 获取
     * @return roieId
     */
    public Integer getRoieId() {
        return roieId;
    }

    /**
     * 设置
     * @param roieId
     */
    public void setRoieId(Integer roieId) {
        this.roieId = roieId;
    }

    /**
     * 获取
     * @return roie
     */
    public Roie getRoie() {
        return roie;
    }

    /**
     * 设置
     * @param roie
     */
    public void setRoie(Roie roie) {
        this.roie = roie;
    }

    public String toString() {
        return "User{id = " + id + ", username = " + username + ", password = " + password + ", nickname = " + nickname + ", email = " + email + ", creatAt = " + creatAt + ", roieId = " + roieId + ", roie = " + roie + "}";
    }
}
