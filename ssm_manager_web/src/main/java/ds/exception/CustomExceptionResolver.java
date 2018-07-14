package ds.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 * 
 * @author 董帅
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

    /**
     * ex : 系统抛出的异常
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, 
            HttpServletResponse response, Object handler,
            Exception ex) {
        // handler就是处理器适配器要执行的handler对象(只有method)
        
        CustomException customException = null;
        if (ex instanceof CustomException) {
            customException = (CustomException)ex;
        } else {
            customException = new CustomException("未知错误");
        }
        
        //错误信息
        String message = customException.getMessage();
        
        ModelAndView modelAndView = new ModelAndView();
        
        //将错误信息传到页面
        modelAndView.addObject("message", message);
        
        //指向错误页面
        modelAndView.setViewName("/error.jsp");
        
        
        return modelAndView;
    }

}
