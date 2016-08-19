package com.ibm.mom.dp.facade.example;

public class FundFacade {
	private Stock1 stock1;
	private Stock2 stock2;
	private Stock3 stock3;
	private NationalDebt1 nd1;
	private NationalDebt2 nd2;
	
	public FundFacade() {
		stock1 = new Stock1();
		stock2 = new Stock2();
		stock3 = new Stock3();
		nd1 = new NationalDebt1();
		nd2 = new NationalDebt2();
	};

	public void buyFund() {
		stock1.buy();
		stock2.buy();
		stock3.buy();
		nd1.buy();
		nd2.buy();
	}
	
	public void sellFund() {
		stock1.sell();
		stock2.sell();
		stock3.sell();
		nd1.sell();
		nd2.sell();
	}
	
	public void buyStock() {
		stock1.buy();
		stock2.buy();
		stock3.buy();
	}
	
	public void sellStock() {
		stock1.sell();
		stock2.sell();
		stock3.sell();
	}
	
	public void buyNationalDebt() {
		nd1.buy();
		nd2.buy();
	}
	
	public void sellNationalDebt() {
		nd1.sell();
		nd2.sell();
	}
	
}
