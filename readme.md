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

## 静态工厂策略模式

* factory

```java
public class StaticStrategyFactory {
  static Map<String, AbstractOrderHandle> strategyMap = new HashMap<>();

  public static AbstractOrderHandle getStrategy(String type) {
    return strategyMap.get(type);
  }

  public static void register(String type, AbstractOrderHandle handle) {
    strategyMap.put(type, handle);
  }
}

```

* 策略抽象类
```java
public abstract class AbstractOrderHandle implements InitializingBean {

  public void generateOrder() {
    throw new UnsupportedOperationException("暂不支持生成该类型订单");
  }
}
```

* 订单策略
```java
@Component
public class GroupOrderHandle extends AbstractOrderHandle {

  public void generateOrder() {
    System.out.println("生成团购订单");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    StaticStrategyFactory.register(OrderEnum.GROUP.getCode(), this);
  }
}
```

* test
```java
@Test
void testOrdinaryOrder() {
  StaticStrategyFactory.getStrategy(OrderEnum.ORDINARY.getCode()).generateOrder();
}
```
