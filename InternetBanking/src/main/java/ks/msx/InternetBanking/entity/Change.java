package ks.msx.InternetBanking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "change_table")
public class Change {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value_type")
    private String type;

    @Column(name = "current_price_buy")
    private float current_price_buy;

    @Column(name = "current_price_sale")
    private float current_price_sale;
}
