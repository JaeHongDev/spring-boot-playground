package in.springbootplayground.core.application;


import in.springbootplayground.core.domain.Member;
import in.springbootplayground.core.domain.RefreshToken;
import in.springbootplayground.core.infrastructure.MemberRepository;
import in.springbootplayground.core.infrastructure.TokenWriter;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;
    private final TokenWriter tokenWriter;

    public Long signup(){

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        var memberId = memberRepository.save(new Member()).getId();

        var token = createToken();

        tokenWriter.write(new RefreshToken(memberId, token));

        return memberId;
    }

    private String createToken(){
        return UUID.randomUUID().toString();
    }

    public Long me(Long memberId){
        return memberRepository.findById(memberId)
                .orElseThrow(()-> new IllegalArgumentException("사용자 없어용~"))
                .getId();
    }



}
