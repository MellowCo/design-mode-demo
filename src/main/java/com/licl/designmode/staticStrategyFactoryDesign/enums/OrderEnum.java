package com.licl.designmode.staticStrategyFactoryDesign.enums;

public enum OrderEnum {
  ORDINARY("ORDINARY", "普通订单"),
  GROUP("GROUP", "团购订单"),
  PROMOTION("PROMOTION", "促销订单");

  private String code;
  private String desc;

  OrderEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public String getCode() {
    return code;
  }

  public String getDesc() {
    return desc;
  }
}
