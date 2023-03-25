package com.licl.designmode.autoInjectStrategyFactoryDesign.enums;

public enum PlatformEnum {
  TB("TB", "淘宝"),
  JD("JD", "京东"),
  WX("WX", "微信");

  private String platform;
  private String desc;

  PlatformEnum(String platform, String desc) {
    this.platform = platform;
    this.desc = desc;
  }

  public String getPlatform() {
    return platform;
  }

  public String getDesc() {
    return desc;
  }
}
