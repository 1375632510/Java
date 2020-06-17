package com.kuang.dao;

import com.kuang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBookMapper {

    //����һ����
    Integer addBook(Books books);

    //ɾ��һ����
    Integer delBookById(@Param("bookID") int id);

    //����һ����
    Integer updateBook(Books books);

    //��ѯһ����
    Books queryBookById(@Param("bookID")int id);

    //��ѯȫ������
    List<Books> queryAllBook();

    //
    List<Books> queryBookByName(@Param("bookName")String bookName);
}
