package com.cr.distributed.lock.service.impl;

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
public class StockServiceImpl implements StockService {

    private final Stock stock = new Stock();

    private final ReentrantLock lock = new ReentrantLock();

    /**
     * 扣减库存
     */
    @Override
    public void deduct() {
        lock.lock();
        try {
            stock.setStock(stock.getStock() - 1);
            System.out.println("库存余量：" + stock.getStock());
        } finally {
            lock.unlock();
        }
    }
}
