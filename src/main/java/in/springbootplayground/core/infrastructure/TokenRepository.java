package in.springbootplayground.core.infrastructure;

import in.springbootplayground.core.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<RefreshToken, Long> {
}
