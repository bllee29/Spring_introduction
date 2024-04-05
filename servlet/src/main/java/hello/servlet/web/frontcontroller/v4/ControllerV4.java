package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {

    /**
     * @param paramMap - map
     * @param model - map
     * @return viewName
     */
    String process(Map<String, String> paramMap, Map<String, Object> model);
}