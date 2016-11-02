package com.sedi.entity;

import javax.persistence.Column;

/**
 * Created by csw on 2016/11/2 21:30.
 * Explain:
 */
public class CodeMapEntity {

    private Integer id;

    private String codeMapId;//映射关系Id

    @Column(unique = true)
    private String codeMapName;//映射类型名,一般与映射关系Id

    private String note;//

    //参考对象,OneToMany,这个对象是one
}
