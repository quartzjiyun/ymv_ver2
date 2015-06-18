package org.log5j.ymv.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.log5j.ymv.model.member.MemberVO;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

public class LoginInterceptor extends WebContentInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
        //@NoCheckLogin 어노테이션이 컨트롤러에 사용되었는지 체크함
        NoLoginCheck usingAuth = ((HandlerMethod) handler).getMethodAnnotation(NoLoginCheck.class);
        System.out.println("test"+usingAuth);
        //NoCheckLogin 어노테이션이 없음으로 무조건 로그인 체크
        if(usingAuth == null) {
            HttpSession session=request.getSession();
            MemberVO memberVO=(MemberVO)session.getAttribute("mvo");
            if(memberVO==null){
            	try {
					response.sendRedirect("loginCheck.ymv");
					return false;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
/*					return super.preHandle(request, response, handler);*/
				}
            }
        }
        //NoCheckLogin 어노테이션이 없음으로 로그인 체크 하지 않음
        else {
            //TODO 추가작업
        }
      return true;
    }   
}