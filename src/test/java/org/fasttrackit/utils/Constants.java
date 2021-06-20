package org.fasttrackit.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Constants {
    public static final String USER_EMAIL = "Liviu@gmail.com";
    public static final String USER_PASSWORD = "Liviu2208";
    public static final String GENERATE_EMAIL = RandomStringUtils.randomAlphanumeric(1, 15) + "@gmail.com";
    public static final String GENERATE_2_CHARACTERS_PASSWORD = RandomStringUtils.randomAlphanumeric(2);
    public static final String GENERATE_4_CHARACTERS_PASSWORD = RandomStringUtils.randomAlphanumeric(4);
    public static final String GENERATE_9_CHARACTERS_PASSWORD = RandomStringUtils.randomAlphanumeric(9);
    public static final String GENERATE_PRODUCT_NAME = RandomStringUtils.randomAlphanumeric(5, 15);
    public static final String GENERATE_PRICE = RandomStringUtils.randomNumeric(1, 4);
    public static final String GENERATE_SECOND_PRODUCT_NAME = RandomStringUtils.randomAlphanumeric(5, 15);
    public static final String GENERATE_SECOND_PRICE = RandomStringUtils.randomNumeric(1, 4);
    public static final String GENERATE_THIRD_PRODUCT_NAME = RandomStringUtils.randomAlphanumeric(5, 15);
    public static final String GENERATE_THIRD_PRICE = RandomStringUtils.randomNumeric(1, 4);
}
