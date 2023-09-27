package ks.msx.InternetBanking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "card_entity")
@Builder
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card__code")
    private String card_code;

    @Column(name = "card_cvv")
    private int card_cvv;

    @Column(name = "card_expire_date")
    private Date card_expire_date;

    @Column(name = "card_firstname")
    private String firstname;

    @Column(name = "card_lastname")
    private String lastname;

    @Column(name = "available_amount")
    private double available_amount;
}
