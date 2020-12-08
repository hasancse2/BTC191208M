package com.bit.project.test;

import org.testng.annotations.Test;

import com.bit.support.Core;

public class SmokTest extends BaseTest {
	
	Core c;
	
	@Test
	public void verifyTarget() throws InterruptedException {
		 c = new Core(dr);
		c.verifyFooterLinks();
		c.globalsearchVerification();
		
	}
	
}
