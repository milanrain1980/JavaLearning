package com.ibm.mom.dp.facade.example;

import org.junit.Before;
import org.junit.Test;

public class FacadeTest {
	private Stock1 stock1;
	private Stock2 stock2;
	private Stock3 stock3;
	private NationalDebt1 nd1;
	private NationalDebt2 nd2;
	
	private FundFacade fundFacade;

	@Before
	public void setUp() throws Exception {
		stock1 = new Stock1();
		stock2 = new Stock2();
		stock3 = new Stock3();
		nd1 = new NationalDebt1();
		nd2 = new NationalDebt2();
		
		fundFacade = new FundFacade();
	}

	@Test
	public void operation() {
		System.out.println("=============��ͨ����================");
		stock1.buy();
		stock2.buy();
		stock3.buy();
		nd1.buy();
		nd2.buy();
		stock1.sell();
		stock2.sell();
		stock3.sell();
		nd1.sell();
		nd2.sell();
	}
	
	@Test
	public void fundOperation() {
		System.out.println("=============�������================");
		fundFacade.buyFund();
		fundFacade.sellFund();
	}
	
	@Test
	public void stockOperation() {
		System.out.println("=============��Ʊ����================");
		fundFacade.buyStock();
		fundFacade.sellStock();
	}
	
	@Test
	public void nationalDebtOperation() {
		System.out.println("=============ծȯ����================");
		fundFacade.buyNationalDebt();
		fundFacade.sellNationalDebt();
	}

}
