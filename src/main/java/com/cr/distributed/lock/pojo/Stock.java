package com.cr.distributed.lock.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 库存
 *
 * @author cr
 * @date 2022/10/8 12:34
 */
@Data
@TableName("db_stock")
public class Stock {
//    private Integer stock = 5000;

    private Long id;

    private String productCode;

    private String warehouse;

    private Integer count;
}
