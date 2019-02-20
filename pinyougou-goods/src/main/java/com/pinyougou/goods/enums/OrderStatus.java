package com.pinyougou.goods.enums;

/**
 * @author ljn
 * @date 2019/2/19.
 */
public enum OrderStatus {

    WaitPayment("1", "未付款"),

    Paid("2", "已付款"),

    WaitDelivery("3", "未发货"),

    Delivery("4", "已发货"),

    TradeSuccess("5", "交易成功"),

    TradeClosed("6", "交易关闭"),

    WaitEvaluate("7", "待评价");

    private String code;

    private String status;

    OrderStatus(String code, String status) {
        this.code = code;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public static OrderStatus getStatusByCode(String code) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("未找到匹配的订单状态:" + code);
    }
}
