package com.sedi.service.impl;

import com.sedi.entity.CodeMapDetailEntity;
import com.sedi.entity.CodeMapEntity;
import com.sedi.exception.ObjectNotFoundException;
import com.sedi.repository.CodeMapDetailRepository;
import com.sedi.repository.CodeMapRepository;
import com.sedi.service.CodeMapService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by csw on 2016/11/4.
 */
@Component("codeMapService")
@Scope("prototype")
public class CodeMapServiceImpl extends BaseService implements CodeMapService {

    @Autowired
    private CodeMapRepository codeMapRepository;
    private CodeMapDetailRepository codeMapDetailRepository;

    public CodeMapEntity createCodeMap(CodeMapEntity codeMapEntity) {
        Validate.notNull(codeMapEntity, "The codeMapDetail must not be null, create failure.");
        CodeMapEntity created = codeMapRepository.save(codeMapEntity);
        return created;
    }

    @Transactional
    public CodeMapEntity updateCodeMap(CodeMapEntity codeMapEntity) {
        Validate.notNull(codeMapEntity.getId(), "The id of codeMap must not be null, create failure.");
        Validate.notNull(codeMapEntity, "The codeMap must not be null, create failure.");

        log.info(String.format("update Service receive codeMapDetail'codeMapId is: [%s]", codeMapEntity.getId()));
        CodeMapEntity updated = codeMapRepository.findOne(codeMapEntity.getId());

        if (updated == null) {
            throw new ObjectNotFoundException("内容不存在!");
        }
        updated = updated.changeInfoToUpdated(updated);
        CodeMapEntity saved = codeMapRepository.save(updated);
        return saved;
    }

    @Transactional
    public CodeMapEntity deleteCodeMap(Integer id) {
        Validate.notNull(id, "The id must not be null, create failure.");
        String sql = "select count(*) from codemap_detail where code_map_id =" + id;
        CodeMapEntity deleted = codeMapRepository.findOne(id);
        if (Integer.parseInt(sql) == 0) {
            codeMapRepository.delete(id);
        }
        return deleted;
    }

    public List<CodeMapEntity> findAllCodeMap() {
        return (List<CodeMapEntity>) codeMapRepository.findAll();
    }
}
