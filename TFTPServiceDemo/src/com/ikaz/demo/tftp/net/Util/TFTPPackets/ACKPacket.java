package com.ikaz.demo.tftp.net.Util.TFTPPackets;

import java.text.DecimalFormat;

import javax.xml.bind.DatatypeConverter;

import com.ikaz.demo.tftp.net.Util.PacketType;

/**
 * This represents an ACK packet
 *         2 bytes    2 bytes
 *         -------------------
 *  ACK   | 04    |   Block #  |
 *         --------------------
 * @author icastillejos
 * @version 0.0.1
 */
public final class ACKPacket extends TFTPPacket {
	private int blockNumber;

	public ACKPacket(int blockNumber) {
		super(PacketType.ACK);
		this.blockNumber = blockNumber;
		
		String packetTypeCode = new DecimalFormat("00").format(PacketType.ACK);		
		byte[] packetTypeArray = DatatypeConverter.parseHexBinary(packetTypeCode);
		
		String blockNumberStr = new DecimalFormat("00").format(blockNumber);		
		byte[] blockNumberArray = DatatypeConverter.parseHexBinary(blockNumberStr);
		
		byte[] packet = buildTFTPPacket(packetTypeArray, blockNumberArray);
		this.setPacketData(packet);
	}
	
	public int getErrorCode() {
		return blockNumber;
	}
}
