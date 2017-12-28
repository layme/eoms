package com.gwssi.eoms;

import com.gwssi.eoms.dao.bookConcern.TBdListDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EomsApplicationTests {
	@Autowired
	TBdListDao tBdListDao;

	@Test
	public void contextLoads() {
		log.debug("");
	}

}
