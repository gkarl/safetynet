package com.SafetyNet.alerts.dto.url3phoneAlert;

import java.util.List;

public class PhoneAlertListDto {

    private final List<String> listPhones;

    public PhoneAlertListDto(List<String> listPhones) {
        this.listPhones = listPhones;
    }

    public List<String> getListPhones() {
        return listPhones;
    }

    @Override
    public String toString(){
        return " [listPhones=" + getListPhones() + "]";
    }
}
