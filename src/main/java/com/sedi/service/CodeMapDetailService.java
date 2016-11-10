package com.sedi.service;

import com.sedi.entity.CodeMapDetailEntity;

import java.util.List;

/**
 * Created by csw on 2016/11/4.
 */
public interface CodeMapDetailService {
    CodeMapDetailEntity createCodeMapDetail(CodeMapDetailEntity codeMapDetailEntity);

    CodeMapDetailEntity updateCodeMapDetail(CodeMapDetailEntity codeMapDetailEntity);

    CodeMapDetailEntity deleteCodeMapDetail(Integer id);

    List<CodeMapDetailEntity> findAllCodeMapDetail();
}
