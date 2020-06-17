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
    //Service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private IBookService bookService;

    //查询全部书籍，并返回书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> books = bookService.queryAllBook();

        model.addAttribute("list",books);
        return "allBook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }

    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";//重定向到/allBook请求
    }

    //跳转到修改页面
    @RequestMapping("toUpdate")
    public String toUpdatePaper(int id,Model model){
        Books book = bookService.queryBookById(id);
        model.addAttribute("book",book);
        return "updateBook";
    }

    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        //System.out.println("updateBook=>" + books);
        Integer integer = bookService.updateBook(books);
        //System.out.println(integer);
        bookService.queryAllBook();
        return "redirect:/book/allBook";
    }

    //删除书籍
    @RequestMapping("/deleteBook/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id){
        bookService.delBookById(id);
        return "redirect:/book/allBook";
    }

    //根据书名查书
    @RequestMapping("queryBook")
    public String queryBook(String queryBookName,Model model){
        List<Books> books = bookService.queryBookByName(queryBookName);
        if(books.isEmpty()){
            books = bookService.queryAllBook();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("list",books);
        return "allBook";
    }
}
