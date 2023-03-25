package com.licl.designmode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.licl.designmode.noDesign.OrderHandle;
import com.licl.designmode.strategicFactoryDesign.constant.OrderEnum;
import com.licl.designmode.strategicFactoryDesign.factory.Factory;

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
	 * 工厂 + 策略 + 模版 设计模式
	 */
	@Test
	void testOrdinaryOrder() {
		Factory.getHandle(OrderEnum.ORDINARY.getCode()).generateOrder();
	}

	@Test
	void testGroupOrder() {
		Factory.getHandle(OrderEnum.GROUP.getCode()).generateOrder();
	}

	@Test
	void testPromotionOrder() {
		// 该工单模拟不支持生成，抛出 暂不支持促销订单 异常
		Factory.getHandle(OrderEnum.PROMOTION.getCode()).generateOrder();
	}

}
