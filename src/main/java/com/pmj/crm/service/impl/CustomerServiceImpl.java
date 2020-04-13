package com.pmj.crm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pmj.crm.entity.Customer;
import com.pmj.crm.mapper.CustomerMapper;
import com.pmj.crm.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 庞明杰
 * @since 2020-04-05
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public IPage<Customer> queryCustomerByEmpId(IPage<?> page, Integer empId) {
        return customerMapper.queryCustomerByEmpId(page,empId);
    }
}
