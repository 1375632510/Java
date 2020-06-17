package com.kuang.controller;

import com.kuang.pojo.Books;
import com.kuang.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //Service��
    @Autowired
    @Qualifier("BookServiceImpl")
    private IBookService bookService;

    //��ѯȫ���鼮���������鼮չʾҳ��
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> books = bookService.queryAllBook();

        model.addAttribute("list",books);
        return "allBook";
    }

    //��ת�������鼮ҳ��
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }

    //����鼮������
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";//�ض���/allBook����
    }

    //��ת���޸�ҳ��
    @RequestMapping("toUpdate")
    public String toUpdatePaper(int id,Model model){
        Books book = bookService.queryBookById(id);
        model.addAttribute("book",book);
        return "updateBook";
    }

    //�޸��鼮
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        //System.out.println("updateBook=>" + books);
        Integer integer = bookService.updateBook(books);
        //System.out.println(integer);
        bookService.queryAllBook();
        return "redirect:/book/allBook";
    }

    //ɾ���鼮
    @RequestMapping("/deleteBook/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id){
        bookService.delBookById(id);
        return "redirect:/book/allBook";
    }

    //������������
    @RequestMapping("queryBook")
    public String queryBook(String queryBookName,Model model){
        List<Books> books = bookService.queryBookByName(queryBookName);
        if(books.isEmpty()){
            books = bookService.queryAllBook();
            model.addAttribute("error","δ�鵽");
        }
        model.addAttribute("list",books);
        return "allBook";
    }
}
