package com.licl.designmode.strategicFactoryDesign.handle;

import org.springframework.stereotype.Component;
import com.licl.designmode.strategicFactoryDesign.constant.OrderEnum;
import com.licl.designmode.strategicFactoryDesign.factory.Factory;

@Component
public class PromotionOrderHandle extends BaseHandle {
  // 模拟促销订单 不支持 generateOrder 方法，所以不需要实现
  // 抛出异常 暂不支持生成该类型订单

  @Override
  public void afterPropertiesSet() throws Exception {
    Factory.register(OrderEnum.PROMOTION.getCode(), this);
  }
}
