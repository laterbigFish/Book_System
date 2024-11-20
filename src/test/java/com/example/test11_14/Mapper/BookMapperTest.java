package com.example.test11_14.Mapper;

import com.example.test11_14.Model.BookInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.print.Book;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookMapperTest {
   @Autowired
   private BookMapper bookMapper;

   @Test
   void updateBook() {
      BookInfo bookInfo = new BookInfo();
      bookInfo.setId(1);
      bookInfo.setBookName("活着2");
      bookInfo.setAuthor("雨花");
      bookInfo.setStatus(1);
      bookInfo.setPublish("黄河出版社");
      bookInfo.setCount(100);

      System.out.println(bookMapper.updateBook(bookInfo));
   }

   @Test
   void queryBookById() {
      BookInfo bookInfo = new BookInfo();
      bookInfo.setId(1);
      System.out.println(bookMapper.queryBookById(1));
   }
}