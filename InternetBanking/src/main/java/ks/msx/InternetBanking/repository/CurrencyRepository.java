package ks.msx.InternetBanking.repository;

import ks.msx.InternetBanking.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Optional<Currency> findCurrencyByType(String type);
}
