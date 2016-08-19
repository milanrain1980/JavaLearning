package com.ibm.mom.dp.adapter;

import org.junit.Before;
import org.junit.Test;

public class UnitTest {
	private Player f;
	private Player c;
	private Player g;
//	private ChineseCenter cc;
	private Translator t;
	
	@Before
	public void setup() {
		f = new Forward("�͵ٶ�");
		c = new Center("����ķ��");
		g = new Guard("���");
//		cc = new ChineseCenter();
//		cc.setName("Ҧ��");
		t = new Translator("Ҧ��");
	}

	@Test
	public void test() {
		f.attack();
		f.defence();
		System.out.println("============================================");
		c.attack();
		c.defence();
		System.out.println("============================================");
		g.attack();
		g.defence();
		System.out.println("============================================");
//		cc.jingong();
//		cc.fangshou();
		System.out.println("============================================");
		t.attack();
		t.defence();
	}

}
