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
public class Role implements Serializable {



    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

    private String roleName;

    private String createTime;

    private String updateTime;

    private Integer isDel;

    @TableField(exist = false)
    private List<Permission> permissionList;   //一个用户角色对应多个权限

    @TableField(exist = false)
    private List<Department> departmentList;


}
