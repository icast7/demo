package com.ikaz.demo.tftp.net.Util.TFTPPackets;

import java.text.DecimalFormat;

import javax.xml.bind.DatatypeConverter;

import com.ikaz.demo.tftp.net.Util.PacketType;

/**
 * This represents a Data packet
 *	          2 bytes    2 bytes       n bytes
 *	          ---------------------------------
 *	   DATA  | 03    |   Block #  |    Data    |
 *           ---------------------------------
 * @author icastillejos
 * @version 0.0.1
 */
public final class DATAPacket extends TFTPPacket {
	//This constructor takes data as a Str 
	public DATAPacket(int blockNumber, String dataStr) {
		this(blockNumber, DatatypeConverter.parseHexBinary(dataStr));		
	}
	
	//This constructor takes data as a byte[]	
	public DATAPacket(int blockNumber, byte[] data) {
		super(PacketType.DATA);
		
		String packetTypeCode = new DecimalFormat("00").format(PacketType.DATA);		
		byte[] packetTypeArray = DatatypeConverter.parseHexBinary(packetTypeCode);
		
		String blockNumberStr = new DecimalFormat("00").format(blockNumber);		
		byte[] blockNumberArray = DatatypeConverter.parseHexBinary(blockNumberStr);
		
		byte[] packet = buildTFTPPacket(packetTypeArray, blockNumberArray, data);
		this.setPacketData(packet);
	}
}
