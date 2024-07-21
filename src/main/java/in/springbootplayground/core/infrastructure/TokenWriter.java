package in.springbootplayground.core.infrastructure;


import in.springbootplayground.core.domain.RefreshToken;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class TokenWriter {
    private final TokenRepository tokenRepository;


    @Async
    public void write(RefreshToken refreshToken) {
        // 실제 네트워크 속도에 영향을 주도록
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tokenRepository.delete(refreshToken);
        tokenRepository.save(refreshToken);
    }
}
