package com.example.test11_14.Model;

import lombok.Data;
import org.springframework.context.annotation.Primary;
@Data
public class PageRequest {
    private  Integer currentPage = 1;
    private  Integer pageSize = 10;
    private  Integer offset = 0;
    public Integer getOffset() {
        return (currentPage-1)*pageSize;
    }
}
