package com.sedi.controller;

import com.sedi.entity.CodeMapEntity;
import com.sedi.service.CodeMapService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by csw on 2016/11/4.
 */
@RestController
@RequestMapping("/api/CodeMap")
public class CodeMapController extends BaseController{
    @Autowired
    private CodeMapService codeMapService;

    @RequestMapping(method = RequestMethod.GET)
    public List<CodeMapEntity> getAll(){return codeMapService.findAllCodeMap();}

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)

    public CodeMapEntity create(@RequestBody(required = true) CodeMapEntity codeMapEntity){
        Validate.notNull(codeMapEntity,"The codeMap must not be null, create failure.");
        Validate.notNull(codeMapEntity.getId(),"The id of codeMap must not be null, create failure.");

        log.info(String.format("Controller receive codeMap'codeMapId is: [%s]", codeMapEntity.getId()));

        CodeMapEntity created = codeMapService.createCodeMap(codeMapEntity);
        return created;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.RESET_CONTENT)

    public CodeMapEntity update(@PathVariable Integer id,
                                @RequestBody CodeMapEntity codeMapEntity){
        Validate.notNull(codeMapEntity,"The codeMap must not be null, create failure.");
        Validate.notNull(id,"The id of codeMap must not be null, create failure.");

        log.info(String.format("Controller receive codeMap'codeMapDetailId is: [%s]", codeMapEntity.getId()));
        codeMapEntity.setId(id);
        CodeMapEntity updated = codeMapService.updateCodeMap(codeMapEntity);

        return updated;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)

    public CodeMapEntity delete(@PathVariable Integer id){
        Validate.notNull(id,"The id of codeMap must not be null, create failure.");
        return codeMapService.deleteCodeMap(id);
    }
}
