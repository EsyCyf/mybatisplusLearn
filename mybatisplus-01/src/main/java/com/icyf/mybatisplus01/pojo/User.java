package com.icyf.mybatisplus01.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: ESy
 * @Date: 2020/6/28 20:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //主键自增
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @Version //乐观锁注解
    private Integer version;
    @TableLogic
    private Integer deleted;
    //插入时填充字段
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    //插入和更新时填充字段
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
