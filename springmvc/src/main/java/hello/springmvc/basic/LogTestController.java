package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
@RestController // RestController 로 저 LogTest에서 반환하면 뷰네임이 아니라 string자체를 반환해줌
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass());   // Slf4j 붙이면 자동으로됨

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);

        // 로그로 찍은거는 콘솔에 출력됨
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info(" info log={}", name);
        log.warn(" warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}
