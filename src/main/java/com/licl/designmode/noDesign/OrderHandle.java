package com.licl.designmode.noDesign;

public class OrderHandle {
  /**
   * 无设计模式
   */
  public void generateOrder(String orderType) {
    if ("ordinary".equals(orderType)) {
      System.out.println("生成普通订单");
    } else if ("group".equals(orderType)) {
      System.out.println("生成团购订单");
    } else if ("promotion".equals(orderType)) {
      System.out.println("暂不支持促销订单");
    }
  }
}
