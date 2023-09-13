package ks.msx.InternetBanking.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permissions {
    READ("READ"),
    WRITE("WRITE"),
    UPDATE("UPDATE"),
    DELETE("DELETE");

    @Getter
    public final String permissions;
}
