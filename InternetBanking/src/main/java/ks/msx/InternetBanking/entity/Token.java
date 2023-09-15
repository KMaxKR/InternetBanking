package ks.msx.InternetBanking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "token_table")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "confirmed")
    private boolean confirmed;


    @Column(name = "user_id")
    private Long user_id;
}
