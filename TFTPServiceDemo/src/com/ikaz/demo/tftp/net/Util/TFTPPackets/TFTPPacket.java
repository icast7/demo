package com.ikaz.demo.tftp.net.Util.TFTPPackets;

import java.nio.ByteBuffer;
import java.text.DecimalFormat;

import javax.xml.bind.DatatypeConverter;

import com.ikaz.demo.tftp.net.Util.PacketType;

public abstract class TFTPPacket {
	private byte[] packetData;
	private PacketType packetType;
	protected final byte[] separator = new byte[] {0};
	
	/*
	 TFTP Formats
	   Type   Op #     Format without header
	
	          2 bytes    string   1 byte     string   1 byte
	          -----------------------------------------------
	   RRQ/  | 01/02 |  Filename  |   0  |    Mode    |   0  |
	   WRQ    -----------------------------------------------
	          2 bytes    2 bytes       n bytes
	          ---------------------------------
	   DATA  | 03    |   Block #  |    Data    |
	          ---------------------------------
	          2 bytes    2 bytes
	          -------------------
	   ACK   | 04    |   Block #  |
	          --------------------
	          2 bytes  2 bytes        string    1 byte
	          ----------------------------------------
	   ERROR | 05    |  ErrorCode |   ErrMsg   |   0  |
	          ----------------------------------------
	 */
	
	/**
	 * TFTPPacket Protected constructor
	 * @param packetType
	 */
	protected TFTPPacket(PacketType packetType) {
		super();
		this.packetType = packetType;
	}
	
	protected void setPacketData(byte[] packetData){
		this.packetData = packetData;
	}
	
	public byte[] getPackeData(){
		return this.packetData;
	}

	public PacketType getPacketType() {
		return packetType;
	}
	
	/*
	 * Protected static method to build a TFTPPacket byte[] from multiple byte[]s
	 * */
	protected static byte[] buildTFTPPacket(byte[]... arrays) {
		int packetSize = 0;
		
		//Calculate packet size
		for(int i = 0; i < arrays.length; i++){
			packetSize += arrays[i].length;
		}
		
		//Build byte[]
		ByteBuffer bbuffer = ByteBuffer.allocate(packetSize);
		for(int j = 0; j < arrays.length; j++){
			bbuffer.put(arrays[0]);
		} 
		return bbuffer.array();
	}
}
