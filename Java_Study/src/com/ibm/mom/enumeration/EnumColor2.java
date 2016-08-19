package com.ibm.mom.enumeration;

public enum EnumColor2 implements ColorInfo {
		RED{
			public String getColor() {
				return "This is color red";
			}
		}, 
		GREEN{
			public String getColor() {
				return "This is color green";
			}
		}, BLUE{
			public String getColor() {
				return "This is color blue";
			}
		};

}
