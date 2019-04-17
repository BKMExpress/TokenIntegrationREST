/*
 * Copyright 2011 Pozitron.
 * All rights reserved.
 * POZITRON PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package model.dto;

/**
 * Created by IntelliJ IDEA.
 * User: omer.kayis
 * Date: 12/8/11
 * Time: 2:07 PM
 * To change this template use File | Settings | File Templates.
 */
public enum OtpType {

    NUMERIC("numeric"),
    ALPHABETIC("alphabetic"),
    ALPHANUMERIC("alphanumeric");

    private String type;

    OtpType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static OtpType get(String type) {

        for (OtpType otpType : values()) {

            if (otpType.getType().equals(type)) {

                return otpType;

            }

        }

        throw new IllegalStateException("Otp type not found!");

    }
}
