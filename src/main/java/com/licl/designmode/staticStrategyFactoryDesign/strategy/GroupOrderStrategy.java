package com.licl.designmode.staticStrategyFactoryDesign.strategy;

import org.springframework.stereotype.Component;

import com.licl.designmode.staticStrategyFactoryDesign.constant.OrderEnum;
import com.licl.designmode.staticStrategyFactoryDesign.factory.StaticStrategyFactory;;

@Component
public class GroupOrderStrategy extends AbstractOrderStrategy {

  public void generateOrder() {
    System.out.println("生成团购订单");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    StaticStrategyFactory.register(OrderEnum.GROUP.getCode(), this);
  }
}
