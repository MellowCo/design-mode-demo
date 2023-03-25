package com.licl.designmode.staticStrategyFactoryDesign.strategy;

import org.springframework.stereotype.Component;

import com.licl.designmode.staticStrategyFactoryDesign.constant.OrderEnum;
import com.licl.designmode.staticStrategyFactoryDesign.factory.StaticStrategyFactory;;

@Component
public class OrdinaryOrderStrategy extends AbstractOrderStrategy {

  public void generateOrder() {
    System.out.println("生成普通订单");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    StaticStrategyFactory.register(OrderEnum.ORDINARY.getCode(), this);
  }
}
