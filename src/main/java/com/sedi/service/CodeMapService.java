package com.sedi.service;

import com.sedi.entity.CodeMapEntity;

import java.util.List;

/**
 * Created by csw on 2016/11/4.
 */
public interface CodeMapService {
    CodeMapEntity createCodeMap(CodeMapEntity codeMapEntity);

    CodeMapEntity updateCodeMap(CodeMapEntity codeMapEntity);

    CodeMapEntity deleteCodeMap(Integer id);

    List<CodeMapEntity> findAllCodeMap();
}
