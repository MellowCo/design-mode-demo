package com.licl.designmode.staticStrategyFactoryDesign.strategy;

import org.springframework.stereotype.Service;

import com.licl.designmode.staticStrategyFactoryDesign.enums.OrderEnum;
import com.licl.designmode.staticStrategyFactoryDesign.factory.StaticStrategyFactory;

@Service
public class PromotionOrderStrategy extends AbstractOrderStrategy {
  // 模拟促销订单 不支持 generateOrder 方法，所以不需要实现
  // 抛出异常 暂不支持生成该类型订单

  @Override
  public void afterPropertiesSet() throws Exception {
    StaticStrategyFactory.register(OrderEnum.PROMOTION.getCode(), this);
  }
}
