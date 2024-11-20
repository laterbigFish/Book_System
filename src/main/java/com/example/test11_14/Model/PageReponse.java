package com.example.test11_14.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageReponse<T> {
    private int total;//所有记录数
    private List<T> records; // 当前⻚数据
    private PageRequest request;
}
