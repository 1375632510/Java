package com.kuang.dao;

import com.kuang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBookMapper {

    //增加一本书
    Integer addBook(Books books);

    //删除一本书
    Integer delBookById(@Param("bookID") int id);

    //更新一本书
    Integer updateBook(Books books);

    //查询一本书
    Books queryBookById(@Param("bookID")int id);

    //查询全部的书
    List<Books> queryAllBook();

    //
    List<Books> queryBookByName(@Param("bookName")String bookName);
}
