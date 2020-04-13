package com.pmj.crm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleVo {
    private Integer roleId;

    private String roleName;

    private String createTime;

    private String updateTime;

    private Integer isDel;

}
