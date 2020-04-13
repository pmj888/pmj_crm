package com.pmj.crm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pmj.crm.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 庞明杰
 * @since 2020-04-05
 */
@Repository
public interface CustomerMapper extends BaseMapper<Customer> {

    IPage<Customer> queryCustomerByEmpId(IPage<?> page, @Param("empId") Integer empId);

}
