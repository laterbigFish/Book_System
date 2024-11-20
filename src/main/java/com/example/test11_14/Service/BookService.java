package com.example.test11_14.Service;

import com.example.test11_14.Mapper.BookMapper;
import com.example.test11_14.Model.BookInfo;
import com.example.test11_14.Model.PageReponse;
import com.example.test11_14.Model.PageRequest;
import com.example.test11_14.enums.BookEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
@Slf4j
@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;


    public String addNewBook(BookInfo bookInfo){
        if(!StringUtils.hasLength(bookInfo.getBookName())
                ||!StringUtils.hasLength(bookInfo.getAuthor())
                ||bookInfo.getPrice()==null
                ||bookInfo.getStatus()==null || bookInfo.getPublish()==null
        ) {
            return "输入参数不合理输入失败";
        }
        //此处也有可能插入失败
        try{
            bookMapper.addBook(bookInfo);
            return "";
        }catch (Exception e){
            log.error("插入失败");
            return e.getMessage();
        }
    }
    public PageReponse<BookInfo> getListByPage(PageRequest pageRequest) {
        //1. 总记录数
        Integer count = bookMapper.count();
        //2. 当前页的记录
        List<BookInfo> bookInfos = bookMapper.queryBookListByPage(pageRequest.getOffset(),pageRequest.getPageSize());

        for (BookInfo bookInfo: bookInfos){
            bookInfo.setStatusCN(BookEnum.getStatusByCode(bookInfo.getStatus()).getDesc());
        }
        return new PageReponse<>(count, bookInfos, pageRequest);

    }
    public BookInfo queryBookById(Integer bookId) {
        return bookMapper.queryBookById(bookId);
    }

    public Integer updateBook(BookInfo bookInfo) {
        log.info("进入添加页面");
        try{
            bookMapper.updateBook(bookInfo);
        }catch (Exception e){
            e.getMessage();
            return 0;
        }
        return 1;
    }

    public void batchDeleteBook(List<Integer> ids) {

        bookMapper.batchDeleteBook(ids);
    }
}
