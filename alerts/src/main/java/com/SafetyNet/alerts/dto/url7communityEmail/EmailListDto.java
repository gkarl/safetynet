package com.SafetyNet.alerts.dto.url7communityEmail;

import java.util.List;

public class EmailListDto {

    private final List<String> listEmails;

    public EmailListDto(List<String> listEmails) {
        this.listEmails = listEmails;
    }

    public List<String> getListEmails() {
        return listEmails;
    }

    @Override
    public String toString(){
        return "listEmails [" + getListEmails() + "]";
    }
}

