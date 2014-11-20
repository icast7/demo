package com.ikaz.demo.tftp.net.Util;

/** Transfer modes defined on https://www.ietf.org/rfc/rfc1350.txt
 * 
 * @author icastillejos
 * @version 0.0.1
 */
public enum TransferMode {
	/*
	Tranfer Modes
	   Value     	Meaning	
	   netascii	"8 bit ASCII"
	   octect   "Raw 8 bit bytes"
	  - mail     Obsolete, should not be implemented
	 */
	NETASCII(0, "netascii"), 
	OCTECT(1, "octect");
	
	private int code;
	private String modeName;
	
	private TransferMode(int code, String modeName){
		this.code = code;
		this.modeName = modeName;
	}
	
	public int getCode(){
		return this.code;
	}
	
	public String getModeName(){
		return this.modeName;
	}
}