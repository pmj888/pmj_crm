package com.pmj.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 庞明杰
 * @since 2020-03-24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {



    @TableId(value = "emp_id", type = IdType.AUTO)
    private Integer empId;

    private String empName;

    private String pwd;

    private String salt;

    private Integer age;

    private String sex;

    private String phone;

    private String address;

    private String createTime;

    private String updateTime;

    private Integer isDel;


    @TableField(exist = false)
    private List<Role> roleList;//用户角色  一个用户可能有一个角色


}
