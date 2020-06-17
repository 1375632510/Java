package com.kuang.service.impl;

import com.kuang.dao.IBookMapper;
import com.kuang.pojo.Books;
import com.kuang.service.IBookService;

import java.util.List;

public class BookServiceImpl implements IBookService {

    //service²ãµ÷Dao²ã£¬×éºÏDao
    private IBookMapper bookMapper;

    public void setBookMapper(IBookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public Integer addBook(Books books) {
        return bookMapper.addBook(books);
    }


    public Integer delBookById(int id) {
        return bookMapper.delBookById(id);
    }


    public Integer updateBook(Books books) {
        return bookMapper.updateBook(books);
    }


    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }


    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }


    public List<Books> queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }
}
