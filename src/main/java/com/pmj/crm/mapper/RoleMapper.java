package com.pmj.crm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmj.crm.entity.Employee;
import com.pmj.crm.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 庞明杰
 * @since 2020-03-24
 */
@Repository
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> selectRoleList();

    IPage<Role> selectRolePage(Page<Role> page);

    int insertRole(Role role);

}
