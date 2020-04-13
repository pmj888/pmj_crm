package com.pmj.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pmj.crm.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 庞明杰
 * @since 2020-04-05
 */
public interface ICustomerService extends IService<Customer> {

    IPage<Customer> queryCustomerByEmpId(IPage<?> page, @Param("empId") Integer empId);

}
