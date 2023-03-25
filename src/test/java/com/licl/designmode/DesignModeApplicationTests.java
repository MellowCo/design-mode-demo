package com.licl.designmode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.licl.designmode.noDesign.OrderHandle;
import com.licl.designmode.staticStrategyFactoryDesign.constant.OrderEnum;
import com.licl.designmode.staticStrategyFactoryDesign.factory.StaticStrategyFactory;

@SpringBootTest
class DesignModeApplicationTests {
	@Test
	void noDesignMode() {
		// 无设计模式
		String orderType = "group";
		OrderHandle orderHandle = new OrderHandle();
		orderHandle.generateOrder(orderType);
	}

	/**
	 * 静态工厂策略模式
	 */
	@Test
	void testStaticStrategyOrdinaryOrder() {
		StaticStrategyFactory.getStrategy(OrderEnum.ORDINARY.getCode()).generateOrder();
	}

	@Test
	void testStaticStrategyGroupOrder() {
		StaticStrategyFactory.getStrategy(OrderEnum.GROUP.getCode()).generateOrder();
	}

	@Test
	void testStaticStrategyPromotionOrder() {
		// 该工单模拟不支持生成方法，抛出 暂不支持促销订单 异常
		StaticStrategyFactory.getStrategy(OrderEnum.PROMOTION.getCode()).generateOrder();
	}

}
