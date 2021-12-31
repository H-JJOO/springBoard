package org.example.springboard;

import org.example.springboard.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
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
