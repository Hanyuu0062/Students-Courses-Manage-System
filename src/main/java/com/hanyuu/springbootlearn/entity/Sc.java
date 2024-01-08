package com.hanyuu.springbootlearn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sc {
    private Integer id;
    private Long sid;
    private Integer cid;
    private Float pts;
}
