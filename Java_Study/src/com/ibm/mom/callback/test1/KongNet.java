package com.ibm.mom.callback.test1;

/**
 * 中国电信(ChinaTelecom)是移动运营商之一，想必近两年满天飞的“天翼3G”大家都知道吧。
 * 空中网（KongNet）是那个总是喊“用手机看NBA”的服务提供商（ServiceProvider，简称“SP”）。
 * 移动运营商和SP合作才能为我们广大移动用户提供各种服务。比如音乐，彩铃，手机看NBA等等。
 * 这里有一个接口ServiceProvider，也就是Callback接口；
 */
public class KongNet implements ServiceProvider {

	@Override
	public void customHint() {
		System.out.println("优惠活动开始啦，即日起登陆空中网就有好礼送！ 详情见网站公告。");
	}

	public void init() {
		ChinaTelecom ct = new ChinaTelecom();
		ct.setSp(new KongNet());// 告诉ChinaTelecom这是哪家sp
		// KongNet（也就是当前类）实现了ServiceProvider，因此就能把当前类作为适合
		// ChinaTelecom.setSp()的参数，可以修改为ct.setSP(this);
		ct.init();
	}

	public static void main(String[] args) {
		KongNet sp = new KongNet();
		sp.init();
	}
	
}
