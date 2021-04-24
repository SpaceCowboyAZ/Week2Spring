package jeep.controller.support;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import entity.Jeep;
import entity.jeepModel;

public class FetchTestJeep  extends baseTest {
	protected List<Jeep> buildExpected() {
		List<Jeep> list = new LinkedList<>();
		
		list.add(Jeep.builder()
				.modelId(jeepModel.WRANGLER)
				.trimLevel("Sport")
				.numDoors(2)
				.wheelSize(17)
				.basePrice(new BigDecimal("28475.00"))
				.build());
		
		list.add(Jeep.builder()
				.modelId(jeepModel.WRANGLER)
				.trimLevel("Sport")
				.numDoors(4)
				.wheelSize(17)
				.basePrice(new BigDecimal("31975.00"))
				.build());
		
		return list;
}
}