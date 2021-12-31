package org.example.springboard.user;

import org.example.springboard.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/login")
    public void login() {}

    @PostMapping("/login")
    public String loginProc(UserEntity entity, RedirectAttributes reAttr) {
        int result = service.login(entity);
        switch (result) {
            case 0:
                reAttr.addFlashAttribute("msg", "에러가 발생하였습니다.");
                break;
            case 1:
                return "redirect:/board/list";
            case 2:
                reAttr.addFlashAttribute("msg", "아이디를 확인해주세요.");
                break;
            case 3:
                reAttr.addFlashAttribute("msg", "비밀번호를 확인해주세요.");
                break;
        }
        return "redirect:/user/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession hs, HttpServletRequest req) {
        hs.invalidate();
        //이전 페이지로 이동
        String referer = req.getHeader("Referer");
        if (referer == null) { referer = "/user/login"; }
        System.out.println("referer : " + referer);
        return "redirect:" + referer;
    }
}
