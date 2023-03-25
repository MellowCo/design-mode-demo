package com.licl.designmode.staticStrategyFactoryDesign.strategy;

import org.springframework.stereotype.Service;

import com.licl.designmode.staticStrategyFactoryDesign.enums.OrderEnum;
import com.licl.designmode.staticStrategyFactoryDesign.factory.StaticStrategyFactory;;

@Service
public class GroupOrderStrategy extends AbstractOrderStrategy {

  public void generateOrder() {
    System.out.println("生成团购订单");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    StaticStrategyFactory.register(OrderEnum.GROUP.getCode(), this);
  }
}
