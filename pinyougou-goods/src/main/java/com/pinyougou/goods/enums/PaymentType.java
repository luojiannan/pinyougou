package com.pinyougou.goods.enums;

/**
 * @author ljn
 * @date 2019/2/19.
 */
public enum PaymentType {

    WeChat("1","微信"),

    AliPay("2","支付宝");

    private String code;

    private String paymentType;

    PaymentType(String code, String paymentType) {
        this.code = code;
        this.paymentType = paymentType;
    }

    public String getCode() {
        return code;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public static PaymentType getPaymentTypeByCode(String code) {
        for (PaymentType type : PaymentType.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("未找到对应的支付类型:" + code);
    }
}
