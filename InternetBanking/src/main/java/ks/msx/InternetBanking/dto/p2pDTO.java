package ks.msx.InternetBanking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Currency;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class p2pDTO {
    private String donor_card_code;
    private Date donor_card_expire_date;
    private String donor_card_firstname;
    private String donor_card_lastname;
    private int donor_card_cvv;

    private String receiver_card_code;
    private String receiver_card_firstname;
    private String receiver_card_lastname;

    private String amount_type;
    private double amount;
}
