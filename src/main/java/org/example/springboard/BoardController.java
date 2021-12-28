package org.example.springboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller//주소값 맵핑을 할수 있는 특별한 Bean
@RequestMapping("/board")//1차 주소값 만들때 이거밖에 못 쓴다.
public class BoardController {
    @Autowired
    private BoardService service;

    @GetMapping("/list")
    public void list(Model model) {
        List<BoardEntity> list = service.selBoardList();
        model.addAttribute("list", list);//req.setAttribute 대신해서 사용 (스프링에서는 Model 권장)


    }

    @GetMapping("/write")
    public void write() {

    }

    @PostMapping("/write")
    public String writeProc(BoardEntity entity) {
        System.out.println(entity);
        int result = service.insBoard(entity);
        return "redirect:/board/list";
    }


}
