package hello.core.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
    // 이게 붙어있으면 컴포넌트 스캔에 추가
}