package com.pmj.crm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmj.crm.entity.Business;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pmj.crm.entity.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 庞明杰
 * @since 2020-04-12
 */
@Repository
public interface BusinessMapper extends BaseMapper<Business> {

    IPage<Business> queryBusiness(Page<Business> page);

}
