package com.regexp;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import com.regexp.utils.ExcelUtil;
import com.regexp.utils.PrivacyType;
import com.regexp.utils.RegExpUtil;

public class MaskingService {

	private static String UPLOAD_PATH = "";

	public static void main(String[] args) throws Exception {
		String fileName = args[0];
		
		Properties prop = loadProp();
		UPLOAD_PATH = prop.getProperty("FILE.UPLOAD.PATH");
				
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList = ExcelUtil.ExcelRead(fileName, UPLOAD_PATH);
		for(String address : arrayList) {
			RegExpUtil.getMaskingPrivacy(address, PrivacyType.ADDRESS);
		}
		
		String [] telnoList = {"02-319-5839","0325648454","032-345-4455","032-3453-3334","010-3444-1234","010-3444-91234"};
		String maskingcard = "";
		for(String card : telnoList) {
			maskingcard = RegExpUtil.getMaskingPrivacy(card, PrivacyType.TEL_NO);
			System.out.println("maskingtelno : "+maskingcard);
		}
	}
	
	private static Properties loadProp() throws Exception {
		Properties properties = new Properties();
		String proFilePath = "config/local.properties";
		InputStream inputStream = MaskingService.class.getClassLoader().getResourceAsStream(proFilePath);
		try {
			properties.load(inputStream);
		} catch (Exception e) {
			System.out.println("local.properties 파일을 읽을수 없습니다");
		} finally {
			inputStream.close();
		}
		return properties;
	}
}
