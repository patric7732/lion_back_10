package org.example.boardmvc.controller;

import org.example.boardmvc.domain.Board;
import org.example.boardmvc.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public String listBoards(Model model,
                             @RequestParam(defaultValue = "1") int page,
                             @RequestParam(defaultValue = "5") int size) {
        List<Board> boards = boardService.findPaginated(page, size);
        int totalBoards = boardService.getTotalBoardCount();
        int totalPages = (int) Math.ceil((double) totalBoards / size);

        model.addAttribute("boards", boards);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);

        return "board/list";
    }

    @GetMapping("/view")
    public String viewBoard(@RequestParam("id") Long id,
                            @RequestParam(value = "page", defaultValue = "1") int page,
                            Model model) {
        Optional<Board> board = boardService.findById(id);
        board.ifPresent(b -> {
            model.addAttribute("board", b);
            model.addAttribute("currentPage", page); // Pass the page to the view
        });
        return "board/view";
    }

    @GetMapping("/deleteform")
    public String deleteForm(@RequestParam("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "board/deleteform";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id, @RequestParam("password") String password) {
        if (boardService.verifyPassword(id, password)) {
            boardService.deleteById(id);
            return "redirect:/list";
        }
        return "redirect:/deleteform?id=" + id + "&error=true";
    }

    @GetMapping("/writeform")
    public String writeForm(Model model) {
        model.addAttribute("board", new Board());
        return "board/writeform";
    }

    @PostMapping("/write")
    public String write(Board board) {
        boardService.saveBoard(board);
        return "redirect:/list";
    }

    @GetMapping("/updateform")
    public String updateForm(@RequestParam("id") Long id, Model model) {
        Board board = boardService.findById(id).orElse(null);
        model.addAttribute("board", board);
        return "board/updateform";
    }

    @PostMapping("/update")
    public String update(Board board) {
        boardService.update(board);
        return "redirect:/view?id=" + board.getId();
    }
}