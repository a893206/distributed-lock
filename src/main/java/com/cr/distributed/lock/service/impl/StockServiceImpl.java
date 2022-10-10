package com.cr.distributed.lock.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cr.distributed.lock.mapper.StockMapper;
import com.cr.distributed.lock.pojo.Stock;
import com.cr.distributed.lock.service.StockService;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 库存服务
 *
 * @author cr
 * @date 2022/10/8 12:35
 */
@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements StockService {

//    private final Stock stock = new Stock();

    private final ReentrantLock lock = new ReentrantLock();

    /**
     * 扣减库存
     */
    @Override
    public synchronized void deduct() {
//        lock.lock();
        try {
            Stock stock = getOne(new LambdaQueryWrapper<Stock>().eq(Stock::getProductCode, "1001"));
            if (stock != null && stock.getCount() > 0) {
                stock.setCount(stock.getCount() - 1);
                updateById(stock);
            }
        } finally {
//            lock.unlock();
        }
    }
}
