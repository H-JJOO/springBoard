package org.example.springboard.board;

import com.sun.istack.internal.NotNull;
import org.example.springboard.UserUtils;
import org.example.springboard.board.model.BoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService service;


    @GetMapping("/list")
    public void list(Model model) {//request.setAttribute 와 비슷한 역할
        model.addAttribute("list", service.selBoardList());
    }

    @GetMapping("/detail")
    public void detail(Model model, BoardEntity entity) {
        service.updBoardHitsUp(entity);
        model.addAttribute("data", service.selBoard(entity));
    }

    @GetMapping("/write")
    public void write() {}//board/write 로 이동

    @PostMapping("/write")
    public String writeProc(BoardEntity entity, RedirectAttributes reAttr) {
        int result = service.insBoard(entity);
        if (result == 0) {//글쓰기 실패했을때
//            RedirectAttributes 는 redirect 와 관련되어 있다.
//            reAttr.addAttribute("msg", "글 등록에 실패하였습니다."); // addAttribute 는 쿼리스트링 생성
            reAttr.addFlashAttribute("msg", "글 등록에 실패하였습니다.");//객체로 보내지내?(req.setAttribute 같이, request에 담아서 보내준다.)
            reAttr.addFlashAttribute("data", entity);
            return "redirect:/board/write";//다시 글쓰기 창으로 이동
        }
        return "redirect:/board/list";//글쓰기 성공하면 list 로 이동
    }

    @GetMapping("/del")
    public String delProc(BoardEntity entity, RedirectAttributes reAttr) {
        int result = service.delBoard(entity);
        if (result == 0) {//글삭제 실패하면
            reAttr.addFlashAttribute("msg", "글 삭제에 실패하였습니다.");
            reAttr.addAttribute("iboard", entity.getIboard());//쿼리스트링 iboard = pk값
            return "redirect:/board/detail";//삭제 실패한 detail 로 이동
        }
        return "redirect:/board/list";//삭제 성공하면 list 로 이동
    }

    @GetMapping("/mod")
    public void mod(Model model, BoardEntity entity, @NotNull HttpServletRequest res) throws Exception {
        Map<String, ?> map = RequestContextUtils.getInputFlashMap(res);//addFlashAttribute 했는 값 가져오는 방법
        BoardEntity data = map != null ? (BoardEntity)map.get("data") : service.selBoard(entity);
        model.addAttribute("data", data);
    }

    @PostMapping("/mod")
    public String modProc(BoardEntity entity, RedirectAttributes reAttr) {
        int result = service.updBoard(entity);
        if (result == 0) {
            reAttr.addAttribute("iboard", entity.getIboard());
            reAttr.addFlashAttribute("msg", "글 수정에 실패하였습니다.");
            reAttr.addFlashAttribute("data", entity);
            return "redirect:/board/mod";
        }
        return "redirect:/board/detail?iboard=" + entity.getIboard();
    }
}