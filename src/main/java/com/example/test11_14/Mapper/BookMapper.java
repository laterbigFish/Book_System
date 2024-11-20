package com.example.test11_14.Mapper;

import com.example.test11_14.Model.BookInfo;
import com.example.test11_14.Model.PageReponse;
import com.example.test11_14.Model.PageRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BookMapper {
    @Insert("insert into book_info(book_name,author,price,publish,status,count) values(#{bookName},#{author},#{price},#{publish},#{status},#{count})")
    void addBook(BookInfo bookInfo);
    @Select("select count(*) from book_info where status!=0")
    Integer count();
    @Select("select * from book_info where status !=0 order by id limit #{offset}, #{pageSize}")
    List<BookInfo> queryBookListByPage(Integer offset,Integer pageSize);

    @Select("select * from book_info where id = #{bookId}")
    BookInfo queryBookById(Integer bookId);
    Integer updateBook(BookInfo bookInfo);

    void batchDeleteBook(List<Integer> ids);
}
