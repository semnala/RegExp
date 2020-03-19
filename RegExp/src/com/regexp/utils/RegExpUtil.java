package com.regexp.utils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpUtil {
		
	public static String getMaskingPrivacy(String input, PrivacyType type) {
		String output = input;
		switch(type) {
		case ADDRESS:
			output = getMaskedAddress(input);
			break;
		case JUMIN_NO:
			output = getMaskedJuminNo(input);
			break;
		case TEL_NO:
			output = getMaskedTelNo(input);
			break;
		case EMAIL:
			output = getMaskedEmail(input);
			break;
		case CARD_NO:
			output = getMaskedCardNo(input);
			break;
		
		}
		return output;
	}
	
	/**
	 * 주소 마스킹
	 * Ex. 02-1234-****
	 * @param address
	 * @return
	 */
	private static String getMaskedAddress(String address) {
		Matcher matcher = Pattern.compile(RegExpPattern.ADDRESS_PATTERN).matcher(address);
		System.out.println("org_address : "+address);
		while(matcher.find()) {
			String group = matcher.group().trim();
			char []c = new char[group.length()];
			Arrays.fill(c, '*');
			address = address.replaceFirst(group, String.valueOf(c));
		}
		System.out.println("masked_address : "+address);
		return address;
	}
	
	private static String getMaskedJuminNo(String jumin) {
		String result="";
		
		return result;
	}
	
	/**
	 * 전화번호 마스킹(뒤 4자리 마스킹)
	 * Ex. 02-1234-****
	 * @param email
	 * @return
	 */
	private static String getMaskedTelNo(String telno) {
		String result = telno;
		int telnoLen = telno.replaceAll("-", "").length();
		// 자리수가 10 ~ 11 인것만 마스킹 처리
		if(telnoLen < 12 && telnoLen > 9) {
			int firstIdx = 0;
			int lastIdx = telno.length()-4;
			String maskStr = telno.substring(telno.length()-4, telno.length()).replaceAll("\\d", "*");
			result = telno.substring(firstIdx, lastIdx) + maskStr;
		} else {
			System.out.println("WARN! 자리수가 올바르지 않습니다." + telno);
		}
		return result;
	}
	
	/**
	 * 이메일 마스킹(ID 중 앞2자리를 제외한 나머지)
	 * Ex. ab*****@korea.co.kr
	 * @param email
	 * @return
	 */
	private static String getMaskedEmail(String email) {
		String result = email;
		System.out.println("org_email : "+email);
		Matcher matcher = Pattern.compile(RegExpPattern.EMAIL_PATTERN).matcher(email);
		if(matcher.find()) {
			String id = matcher.group(1);
			char[] c = new char[id.length()-2];
			Arrays.fill(c, '*');
			id = id.substring(0, 2)+String.valueOf(c);
			result = email.replaceAll(RegExpPattern.EMAIL_PATTERN, id+"@$2");
			System.out.println("masked_email : "+result);
		}
		
		return result;
	}
	
	/**
	 * 카드번호 마스킹
	 * Ex. 1234-56**-****-**89 (16자리 : 일반카드)
	 * Ex. 1234-56**-****-**8 (15자리 : 아메리칸 익스프레스)
	 * Ex. 1234-56**-****-*7 (14자리 : 다이너스 클럽)
	 * @param card
	 * @return
	 */
	private static String getMaskedCardNo(String card) {
		String result= card;
		if(card.contains("-")) {
			Matcher matcher = Pattern.compile(RegExpPattern.CARD_HPN_PATTERN).matcher(card);
			if(matcher.find()) {
				String lastNum = matcher.group(7);
				char[] c = new char[lastNum.length()];
				Arrays.fill(c, '*');
				lastNum = String.valueOf(c);
				result = card.replaceAll(RegExpPattern.CARD_HPN_PATTERN,"$1-$3**-****-"+lastNum+"$8");
			}
		} else {
			Matcher matcher = Pattern.compile(RegExpPattern.CARD_NUM_PATTERN).matcher(card);
			if(matcher.find()) {
				String lastNum = matcher.group(7);
				char[] c = new char[lastNum.length()];
				Arrays.fill(c, '*');
				lastNum = String.valueOf(c);
				result = card.replaceAll(RegExpPattern.CARD_NUM_PATTERN,"$1$3******"+lastNum+"$8");
			}
		}
		return result;
	}

}
