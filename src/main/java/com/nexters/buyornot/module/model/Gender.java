package com.nexters.buyornot.module.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {
    female("F"),
    male("M");

    private String value;
}
