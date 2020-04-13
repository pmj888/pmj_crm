package com.pmj.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 庞明杰
 * @since 2020-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Business implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "business_id", type = IdType.AUTO)
    private Integer businessId;

    private String businessName;

    private Integer empId;

    private String telphone;

    private String description;

    @TableField(exist = false)
    private String empName;


}
