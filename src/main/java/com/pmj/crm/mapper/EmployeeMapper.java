package com.pmj.crm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmj.crm.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 庞明杰
 * @since 2020-03-24
 */
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {

    IPage<Employee> selectList(Page<Employee> page);

    Employee selectByName(String empName);

}
