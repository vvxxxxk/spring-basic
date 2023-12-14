package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// @ComponentScan: @Componet 어노테이션이 붙은 클래스를 찾아 자동으로 스프링 빈에 등록해주는 역할
@ComponentScan(
        // 컴포넌트 중 제외할 대상을 선정
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
