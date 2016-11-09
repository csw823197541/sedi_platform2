package com.sedi.controller;

import com.sedi.entity.CodeMapDetailEntity;
import com.sedi.service.CodeMapDetailService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by csw on 2016/11/4.
 */
@RestController
@RequestMapping("/api/CodeMap_Deatil")
public class CodeMapDetailController extends BaseController {

    @Autowired
    private CodeMapDetailService codeMapDetailService;

    @RequestMapping(method = RequestMethod.GET)
            public List<CodeMapDetailEntity> getAll() {
             return codeMapDetailService.findAllCodeMapDetail();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public CodeMapDetailEntity create(@RequestBody(required = true) CodeMapDetailEntity codeMapDetailEntity){
        Validate.notNull(codeMapDetailEntity,"The codeMapDetail must not be null, create failure.");
        Validate.notNull(codeMapDetailEntity.getId(),"The id of codeMapDetail must not be null, create failure.");

        log.info(String.format("Controller receive codeMap'codeMapDetailId is: [%s]", codeMapDetailEntity.getId()));
        CodeMapDetailEntity created = codeMapDetailService.createCodeMapDetail(codeMapDetailEntity);
        return  created;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public CodeMapDetailEntity update(@PathVariable Integer id,
                                      @RequestBody CodeMapDetailEntity codeMapDetailEntity){
        Validate.notNull(codeMapDetailEntity,"The codeMapDetail must not be null, create failure.");
        Validate.notNull(id,"The id must not be null, create failure.");

        log.info(String.format("Controller receive codeMapDetail'codeMapDetailId is: [%s]", codeMapDetailEntity.getId()));
        codeMapDetailEntity.setId(id);
        CodeMapDetailEntity updated = codeMapDetailService.updateCodeMapDetail(codeMapDetailEntity);
        return updated;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public CodeMapDetailEntity delete(@PathVariable Integer id){
        Validate.notNull(id,"The id must not be null, create failure.");
        return codeMapDetailService.deleteCodeMapDetail(id);
    }
}
