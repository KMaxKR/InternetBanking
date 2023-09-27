package ks.msx.InternetBanking.repository;

import ks.msx.InternetBanking.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<Card> findCardByCode(String code);

    Optional<Card> findCardByFirstname(String firstname);
}
