package org.example.springboard;

import org.example.springboard.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component//Bean 등록 (객체값 가져올수 있다)
public class UserUtils {

    @Autowired
    private HttpSession session;

    public int getLoginUSerPk() {
        return getLoginUser().getIuser();
    }

    public UserEntity getLoginUser() {
    return (UserEntity) session.getAttribute(Const.LOGIN_USER);
    }
}
