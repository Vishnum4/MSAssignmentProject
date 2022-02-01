package com.prokarma.api.customer.publiser.util;

public class PublisherConstants {

	public static final String Error = "Failed";

	public static final String SUCCESS = "Sccuess";

	public static final String CUSTOMER_EXPRESSION = "\\d(?=(?:\\D*\\d){0,3}\\D*$)";

	public static final String EMAIL_EXPRESSION = "(^[^@]{4}|(?!^)\\G)[^@]";

	public static final String DOB_EXPRESSION = "[^-\\n](?=.*-[^-]*$)";

}
