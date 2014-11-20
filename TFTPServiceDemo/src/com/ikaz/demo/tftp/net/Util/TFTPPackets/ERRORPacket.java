package com.ikaz.demo.tftp.net.Util.TFTPPackets;

import java.text.DecimalFormat;

import javax.xml.bind.DatatypeConverter;

import com.ikaz.demo.tftp.net.Util.PacketType;
/**
 * This represents an ERROR packet
 *         		2 bytes  2 bytes        string    1 byte
 *	          ----------------------------------------
 *	   ERROR | 05    |  ErrorCode |   ErrMsg   |   0  |
 *	          ----------------------------------------
 * @author icastillejos
 * @version 0.0.1
 */
public final class ERRORPacket extends TFTPPacket {
	private int errorCode;
	private String errorMsg;	
	
	public ERRORPacket(int errorCode, String errorMsg) {
		super(PacketType.ERROR);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		
		String packetTypeCode = new DecimalFormat("00").format(PacketType.ERROR);		
		byte[] packetTypeArray = DatatypeConverter.parseHexBinary(packetTypeCode);
		
		String errorCodeStr = new DecimalFormat("00").format(errorCode);		
		byte[] errorCodeArray = DatatypeConverter.parseHexBinary(errorCodeStr);
		
		byte[] errorMsgArray = DatatypeConverter.parseHexBinary(errorMsg);
	
		byte[] packet = buildTFTPPacket(packetTypeArray, errorCodeArray, errorMsgArray, separator);
		this.setPacketData(packet);
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
}