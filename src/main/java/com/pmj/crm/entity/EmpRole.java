package com.pmj.crm.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-03-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpRole implements Serializable {



    private Integer empId;

    private Integer roleId;

    private String createTime;

    private String updateTime;

    private Integer isDel;


}
