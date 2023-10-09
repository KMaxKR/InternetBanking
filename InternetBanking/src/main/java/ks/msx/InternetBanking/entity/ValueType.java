package ks.msx.InternetBanking.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ValueType {
    MDL("MDL"),
    EUR("EUR"),
    USD("USD");

    @Getter
    private final String valueType;
}
