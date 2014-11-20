package com.ikaz.demo.tftp.net.Util.TFTPPackets;

import java.nio.ByteBuffer;
import java.text.DecimalFormat;

import javax.xml.bind.DatatypeConverter;

import com.ikaz.demo.tftp.net.Util.PacketType;
import com.ikaz.demo.tftp.net.Util.TransferMode;

/**
 * This represents an *RQ packet
 *  		2 bytes    string   1 byte     string   1 byte
 *	        -----------------------------------------------
 *	 RRQ/  | 01/02 |  Filename  |   0  |    Mode    |   0  |
 *	 WRQ    -----------------------------------------------
 *  
 * @author icastillejos
 * @version 0.0.1
 */
public final class XRQPacket extends TFTPPacket {
	private TransferMode transferMode;
	private String fileName;
	
	public XRQPacket(PacketType packetType, String fileName, TransferMode transferMode) {
		super(packetType);
		this.fileName = fileName;
		this.transferMode = transferMode;
		
		String packetTypeCode = new DecimalFormat("00").format(packetType.getCode());		
		byte[] packetTypeArray = DatatypeConverter.parseHexBinary(packetTypeCode);
		
		byte[] fileNameArray = DatatypeConverter.parseHexBinary(fileName);
		byte[] modeArray = DatatypeConverter.parseHexBinary(transferMode.getModeName());
		
		byte[] packet = TFTPPacket.buildTFTPPacket(packetTypeArray, fileNameArray, separator,modeArray, separator);
		this.setPacketData(packet);
	}
	
	public String getFileName(){
		return this.fileName;
	}
	
	public TransferMode getMode(){
		return this.transferMode;
	}
}
