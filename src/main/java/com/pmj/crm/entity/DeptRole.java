package com.pmj.crm.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

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
 * @since 2020-04-03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer deptId;

    private Integer roleId;

    private String createTime;

    private String updateTime;

    private Integer isDel;


}
