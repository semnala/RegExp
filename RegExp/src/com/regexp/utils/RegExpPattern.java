package com.regexp.utils;

public class RegExpPattern {
	/*
	public class Address{
		// ½Ã±º±¸
		public static final String PATTERN_SIGUNGU = "";
		// µµ·Î¸í ÁÖ¼Ò : µµ·Î¸í(´ë·Î/·Î/±æ) + °Ç¹°¹øÈ£
		public static final String PATTERN_ROAD_NAME = "(([°¡-ÆRa-zA-Z]|(\\d{1,5}(~|-)\\d{1,5})|\\d{1,5})+(·Î|±æ)|\\d{1,5})";
		// Áö¹ø ÁÖ¼Ò
		public static final String PATTERN_JIBUN ="((\\d{1,5})|(\\d{1,5}¹øÁö)|(\\d{1,5}(-|~)\\d{1,5})|(\\d{1,5}(-|~)\\d{1,5}¹øÁö))";
	}
	*/
	public static final String ADDRESS_PATTERN = "(((\\d{1,5}(~|-)\\d{1,5})|\\d{1,5})+(·Î|±æ)|\\d{1,5}[^°¡])|((\\d{1,5}¹øÁö)|(\\d{1,5}(-|~)\\d{1,5})|(\\d{1,5}(-|~)\\d{1,5}¹øÁö))";
	public static final String TELNO_PATTERN = "";
	public static final String EMAIL_PATTERN = "\\b(\\S+)+@(\\S+.\\S)";
	public static final String JUMIN_PATTERN = "";
	public static final String CARD_HPN_PATTERN = "(\\d{4})-((\\d{2})[^-][^-])-((\\d{2})[^-][^-])-((\\d{1,2})([^-][^-]|[^-]))";
	public static final String CARD_NUM_PATTERN = "(\\d{4})((\\d{2})[^ ][^ ])((\\d{2})[^ ][^ ])((\\d{1,2})([^ ][^ ]|[^ ]))";


}
