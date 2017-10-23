package com.gwssi.eoms;

import com.gwssi.eoms.model.domain.produce.gonggao.FaBzggCbjyb2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EomsApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println(new FaBzggCbjyb2().toString());
	}

}
