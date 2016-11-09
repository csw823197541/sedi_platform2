package com.sedi.service.impl;

import com.sedi.entity.CodeMapDetailEntity;
import com.sedi.exception.ObjectNotFoundException;
import com.sedi.repository.CodeMapDetailRepository;
import com.sedi.service.CodeMapDetailService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by csw on 2016/11/4.
 */
@Component("codeMapDetailService")
@Scope("prototype")
public class CodeMapDetailServiceImpl extends BaseService implements CodeMapDetailService {
    @Autowired

    private CodeMapDetailRepository codeMapDetailRepository;

    public CodeMapDetailEntity createCodeMapDetail(CodeMapDetailEntity codeMapDetailEntity){
        Validate.notNull(codeMapDetailEntity,"The codeMapDetail must not be null, create failure.");
        CodeMapDetailEntity created = codeMapDetailRepository.save(codeMapDetailEntity);
        return created;
    }

    @Transactional

    public CodeMapDetailEntity updateCodeMapDetail(CodeMapDetailEntity codeMapDetailEntity){
        Validate.notNull(codeMapDetailEntity.getId(),"The id of mailBox must not be null, create failure.");
        Validate.notNull(codeMapDetailEntity,"The codeMapDetail must not be null, create failure.");

        log.info(String.format("update Service receive codeMapDetail'codeMapDetaillId is: [%s]", codeMapDetailEntity.getId()));
        CodeMapDetailEntity updated = codeMapDetailRepository.findOne(codeMapDetailEntity.getId());
        if (updated == null){
            throw new ObjectNotFoundException("内容不存在!");
        }
        updated = updated.changeInfoToUpdated(updated);
        CodeMapDetailEntity saved = codeMapDetailRepository.save(updated);
        return saved;
    }

    @Transactional

    public CodeMapDetailEntity deleteCodeMapDetail(Integer id){
        Validate.notNull(id,"The id must not be null, create failure.");
        CodeMapDetailEntity deleted = codeMapDetailRepository.findOne(id);
        if (deleted == null){
            throw new ObjectNotFoundException("内容不存在！");
        }
        codeMapDetailRepository.delete(id);
        return deleted;
    }
    public List<CodeMapDetailEntity> findAllCodeMapDetail(){return (List<CodeMapDetailEntity>) codeMapDetailRepository.findAll();}
}
