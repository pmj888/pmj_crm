package com.pmj.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmj.crm.entity.Business;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 庞明杰
 * @since 2020-04-12
 */
public interface IBusinessService extends IService<Business> {

    IPage<Business> queryBusiness(Page<Business> page);

}
