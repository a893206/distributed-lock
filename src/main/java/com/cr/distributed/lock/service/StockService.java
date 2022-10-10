package com.cr.distributed.lock.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cr.distributed.lock.pojo.Stock;

/**
 * 库存服务
 *
 * @author cr
 * @date 2022/10/8 12:35
 */
public interface StockService extends IService<Stock> {

    /**
     * 扣减库存
     */
    void deduct();

}
