package com.example.test11_14.Coltroller;

import com.example.test11_14.Model.BookInfo;
import com.example.test11_14.Model.PageReponse;
import com.example.test11_14.Model.PageRequest;
import com.example.test11_14.Service.BookService;
import com.example.test11_14.enums.BookEnum;
import com.sun.jdi.event.ExceptionEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping("/addBook")
    public String addBook(BookInfo bookInfo){
        return bookService.addNewBook(bookInfo);
    }
    //解决图书列表的问题"
    @RequestMapping("/getListByPage")
    public PageReponse<BookInfo> getListByPage(PageRequest pageRequest) {
        log.info("11111获取图书列表, pageRequest:{}", pageRequest);
         return bookService.getListByPage(pageRequest);
    }
    //更新图书
    @RequestMapping("/queryBookById")
    public BookInfo queryBookById(Integer bookId){
        log.info("获取图书信息, bookId:" + bookId);
        //参数校验, 不能为null, 不能<=0...省略
        //加try catch...
        return bookService.queryBookById(bookId);
    }

    @RequestMapping("/updateBook")
    public String updateBook(BookInfo bookInfo){
        log.info("更新图书, bookInfo: {}", bookInfo);
        try {
            Integer result = bookService.updateBook(bookInfo);
            if (result>0){
                return "";
            }
            return "图书更新失败";
        }catch (Exception e){
            log.error("更新图书失败, e:", e);
            return "数据库操作失败";
        }
    }
    @RequestMapping("/deleteBook")
    public String deleteBook(Integer bookId){
        log.info("更新图书, bookId: {}", bookId);
        try {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(bookId);
            bookInfo.setStatus(BookEnum.DELETED.getCode());
            Integer result = bookService.updateBook(bookInfo);
            if (result>0){
                return "";
            }
            return "图书删除失败";
        }catch (Exception e){
            log.error("删除图书失败, e:", e);
            return "数据库操作失败";
        }
    }
    //批量删除  使用xml的 foreach
    @RequestMapping("/batchDeleteBook")
    public Boolean batchDeleteBook(@RequestParam List<Integer> ids){
        log.info("批量删除图书, ids:{}", ids);
        try {
            //执行SQL
            bookService.batchDeleteBook(ids);
            return true;
        }catch (Exception e){
            log.error("批量删除图书失败, ids:{}", ids);
        }
        return false;

    }
}
