package com.cr.distributed.lock.controller;

import com.cr.distributed.lock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存Controller
 *
 * @author cr
 * @date 2022/10/8 12:37
 */
@RestController
@RequestMapping("/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/deduct")
    public String deduct() {
        stockService.deduct();
        return "hello stock deduct!";
    }

}
