package com.gb.springbootdemo.enums;

public enum PatType {
    CCB("中国工商银行", "ccb");

    private String bankName;
    private String bankCrad;

    PatType(String bankName, String bankCrad) {
        this.bankName = bankName;
        this.bankCrad = bankCrad;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCrad() {
        return bankCrad;
    }

    public void setBankCrad(String bankCrad) {
        this.bankCrad = bankCrad;
    }
}
