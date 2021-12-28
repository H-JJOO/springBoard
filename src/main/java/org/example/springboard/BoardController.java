package org.example.springboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//주소값 맵핑을 할수 있는 특별한 Bean
@RequestMapping("/board")//1차 주소값 만들때 이거밖에 못 쓴다.
public class BoardController {
    @Autowired
    private BoardService service;

    @GetMapping("/list")
    public void list() {

    }

    @GetMapping("/write")
    public void write() {

    }
}
