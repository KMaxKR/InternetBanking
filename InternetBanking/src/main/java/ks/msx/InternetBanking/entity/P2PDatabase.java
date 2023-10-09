package ks.msx.InternetBanking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "p2p_database")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class P2PDatabase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long operation_id;

    @Column(name = "donor_id")
    private Long donor_id;

    @Column(name = "donor_card_id")
    private Long donor_card_id;

    @Column(name = "receiver_id")
    private Long receiver_id;

    @Column(name = "receiver_card_id")
    private Long receiver_card_id;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusOperation status;

    @Column(name = "sum")
    private Double sum;

    @Column(name = "donor_value_type")
    private Long donor_value_type;

    @Column(name = "receiver_value_type")
    private Long receiver_value_type;
}
