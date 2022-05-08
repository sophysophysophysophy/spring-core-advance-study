package hello.advanced.trace.template;

import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();

        //비즈니스 로직 발생
        log.info("비즈니스 로직1 실행");
        //비스니스 로직 종료

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);

    }

    private void logic2() {
        long startTime = System.currentTimeMillis();

        //비즈니스 로직 발생
        log.info("비즈니스 로직2 실행");
        //비스니스 로직 종료

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);

    }


    /**
     * 템플릿 메서드 패턴 적용
     */
    @Test
    void templateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.excute();

        AbstractTemplate template2 = new SubClassLogic2();
        template2.excute();

    }

    @Test
    void templateMethodV2() {

        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직1 실행");
            }
        };

        log.info("클래스 이름={}", template1.getClass());
        template1.excute();

        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직2 실행");
            }
        };

        log.info("클래스 이름={}", template2.getClass());
        //익명 내부 클래스이기 때문에 자바가 임의로 이름 생성
//        hello.advanced.trace.template.TemplateMethodTest$1    : TemplateMethodTest class 내부에 존재하는 클래스 $숫자는 임의로 지어준 클래스명
        template2.excute();


    }

}
