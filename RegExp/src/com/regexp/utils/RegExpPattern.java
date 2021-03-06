package com.regexp.utils;

public class RegExpPattern {
	/*
	public class Address{
		// 시군구
		public static final String PATTERN_SIGUNGU = "";
		// 도로명 주소 : 도로명(대로/로/길) + 건물번호
		public static final String PATTERN_ROAD_NAME = "(([가-힣a-zA-Z]|(\\d{1,5}(~|-)\\d{1,5})|\\d{1,5})+(로|길)|\\d{1,5})";
		// 지번 주소
		public static final String PATTERN_JIBUN ="((\\d{1,5})|(\\d{1,5}번지)|(\\d{1,5}(-|~)\\d{1,5})|(\\d{1,5}(-|~)\\d{1,5}번지))";
	}
	*/
	public static final String ADDRESS_PATTERN = "(((\\d{1,5}(~|-)\\d{1,5})|\\d{1,5})+(로|길)|\\d{1,5}[^가])|((\\d{1,5}번지)|(\\d{1,5}(-|~)\\d{1,5})|(\\d{1,5}(-|~)\\d{1,5}번지))";
	public static final String TELNO_PATTERN = "";
	public static final String EMAIL_PATTERN = "\\b(\\S+)+@(\\S+.\\S)";
	public static final String JUMIN_PATTERN = "";
	public static final String CARD_HPN_PATTERN = "(\\d{4})-((\\d{2})[^-][^-])-((\\d{2})[^-][^-])-((\\d{1,2})([^-][^-]|[^-]))";
	public static final String CARD_NUM_PATTERN = "(\\d{4})((\\d{2})[^ ][^ ])((\\d{2})[^ ][^ ])((\\d{1,2})([^ ][^ ]|[^ ]))";


}
