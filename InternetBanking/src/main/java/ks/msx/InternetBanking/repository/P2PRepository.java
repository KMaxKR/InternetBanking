package ks.msx.InternetBanking.repository;

import ks.msx.InternetBanking.entity.P2PDatabase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface P2PRepository extends JpaRepository<P2PDatabase, Long> {
}
