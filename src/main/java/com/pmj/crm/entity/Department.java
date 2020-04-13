package com.pmj.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-03-24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable {


    @TableId(value = "dept_id", type = IdType.AUTO)
    private Integer deptId;

    private String deptName;

    private String createTime;

    private String updateTime;

    private Integer isDel;


}
