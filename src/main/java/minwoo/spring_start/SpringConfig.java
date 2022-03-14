package minwoo.spring_start;

import minwoo.spring_start.aop.TimeTraceAop;
import minwoo.spring_start.repository.*;
import minwoo.spring_start.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    //private DataSource dataSource;

    /*private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/

    /*@Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    /*@Bean
    TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }*/

    // Contig 방식으로 빈을 생성하면 객체의 변화시 관리 포인트가 줄어듬 MemoryMemberRepository() > JdbcMemberRepository()
    /*@Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository(dataSource);
        // return new JdbcMemberRepository(dataSource);
        // return new JdbcTemplateMemberRepository(dataSource);
        // return new JpaMemberRepository(em);
    }*/
}
