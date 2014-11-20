package com.ikaz.demo.tftp.test;

import java.text.DecimalFormat;

import com.ikaz.demo.tftp.net.Util.PacketType;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PacketType oso = PacketType.WRQ;
		System.out.println(oso.getCode());
		int panza = oso.getCode();
		System.out.println();
	}

}
