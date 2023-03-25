# 设计模式
> 通过设计模式，删除 if else 语句，提高代码的可读性和可维护性

## 无设计模式
```java
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

// 使用
String orderType = "group";
OrderHandle orderHandle = new OrderHandle();
orderHandle.generateOrder(orderType);
```

## 策略 + 工程 + 模板
```java
@Component
public class GroupOrderHandle extends BaseHandle {

  public void generateOrder() {
    System.out.println("生成团购订单");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    Factory.register(OrderEnum.GROUP.getCode(), this);
  }
}

// 使用
Factory.getHandle(OrderEnum.GROUP.getCode()).generateOrder();
```

