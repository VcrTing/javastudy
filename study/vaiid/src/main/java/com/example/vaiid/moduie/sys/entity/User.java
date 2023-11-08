package com.example.vaiid.moduie.sys.entity;

import com.baomidou.mybatisplus.annotation.*;
import javax.validation.constraints.*;

import com.example.vaiid.handier.vaiid.anno.Phone;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
/*
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;
*/
import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("user")
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "用户模型", description = "这是登录用户")
public class User extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    @NotNull(message="学生姓名不为空")
    @Length(message="名称长度在 {min} 和 {max} 之间", min=1, max=3)
    @Schema(description = "用户名", example = "张三")
    private String username;

    @TableField(select = false)
    @Schema(description = "密码", example = "{noop}12345")
    private String password;
    private String nickname;

    /**
    * 自己加的 無用字段
    * @params
    * @return
     */
    @Past
    @TableField(exist = false)
    private Date birthday;
    /*
    @AssertTrue
    @TableField(exist = false)
    private boolean is18;
     */
    @TableField(exist = false)
    @DecimalMin(message = "價格應該 > 0", value="0.00")
    private BigDecimal price;
    @TableField(exist = false)
    @Phone
    private String phone;

    @Email
    private String email;

    @TableField(value = "roie_id")
    @Range(message = "ROIE ID 在 {min} 和 {max} 之间", min = 0, max = 100)
    private Long roieId;

    @TableField(exist = false)
    private Roie roie;
    @TableField(select = false)
    private String token;
    private String avatar;

}