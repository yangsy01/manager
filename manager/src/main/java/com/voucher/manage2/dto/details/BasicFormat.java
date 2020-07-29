package com.voucher.manage2.dto.details;

import lombok.Data;

@Data
public class BasicFormat {
    private String name;
    private Object value;

    public BasicFormat(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}
