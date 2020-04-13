package com.pmj.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2020-04-05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer customerId;
    private String customerName;
    private String sex;
    private String telphone;
    private String company;
    private String address;
    private Integer isOrders;
    private Integer empId;
    @TableField(exist = false)
    private Employee employee;


}
