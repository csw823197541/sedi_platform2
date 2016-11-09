package com.sedi.controller;

import com.sedi.entity.PluginCodeEntity;
import com.sedi.service.PluginCodeService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by csw on 2016/11/4.
 */
@RestController
@RequestMapping("/api/PluginCode")

public class PluginCodeController extends BaseController {
    @Autowired
    private PluginCodeService pluginCodeService;

    @RequestMapping(method = RequestMethod.GET)
    List<PluginCodeEntity> getAll(){return pluginCodeService.findAllPluginCode();}

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)

    public PluginCodeEntity create(@RequestBody(required = true) PluginCodeEntity pluginCodeEntity ){
        Validate.notNull(pluginCodeEntity,"The pluginCode must not be null, create failure.");
        Validate.notNull(pluginCodeEntity.getId(),"The id of pluginCode must not be null, create failure.");

        log.info(String.format("Controller receive pluginCode'pluginCodeId is: [%s]", pluginCodeEntity.getId()));

        PluginCodeEntity created = pluginCodeService.createPluginCode(pluginCodeEntity);
        return created;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.RESET_CONTENT)

    public PluginCodeEntity update(@PathVariable Integer id,
                                   @RequestBody PluginCodeEntity pluginCodeEntity){
        Validate.notNull(pluginCodeEntity,"The pluginCode must not be null, create failure.");
        Validate.notNull(pluginCodeEntity.getId(),"The id of pluginCode must not be null, create failure.");

        log.info(String.format("Controller receive pluginCode'pluginCodeId is: [%s]", pluginCodeEntity.getId()));
        pluginCodeEntity.setId(id);
        PluginCodeEntity updated = pluginCodeService.createPluginCode(pluginCodeEntity);
        return updated;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)

    public PluginCodeEntity Delete(@PathVariable Integer id){
        Validate.notNull(id,"The id must not be null, delete failure.");

        return pluginCodeService.deletePluginCode(id);
    }
}
