package ks.msx.InternetBanking.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum StatusOperation {
    DENIED("DENIED"),
    APPROVED("APPROVED");

    @Getter
    public final String status;
}
