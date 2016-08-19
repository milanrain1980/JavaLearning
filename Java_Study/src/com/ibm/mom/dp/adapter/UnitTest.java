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
		f = new Forward("°ÍµÙ¶û");
		c = new Center("ÄÂÍÐÄ·²©");
		g = new Guard("ÂóµÙ");
//		cc = new ChineseCenter();
//		cc.setName("Ò¦Ã÷");
		t = new Translator("Ò¦Ã÷");
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
