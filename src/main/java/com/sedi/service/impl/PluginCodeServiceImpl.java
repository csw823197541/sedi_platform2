package com.sedi.service.impl;

import com.sedi.entity.PluginCodeEntity;
import com.sedi.exception.ObjectNotFoundException;
import com.sedi.repository.PluginCodeRepository;
import com.sedi.service.PluginCodeService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by csw on 2016/11/4.
 */
@Component("pluginCodeService")
@Scope("prototype")
public class PluginCodeServiceImpl extends BaseService implements PluginCodeService {
    @Autowired
    private PluginCodeRepository pluginCodeRepository;

    public PluginCodeEntity createPluginCode(PluginCodeEntity pluginCodeEntity) {
        Validate.notNull(pluginCodeEntity, "The pluginCode must not be null, create failure.");
        PluginCodeEntity saved = pluginCodeRepository.save(pluginCodeEntity);

        return saved;
    }

    @Transactional
    public PluginCodeEntity updatePluginCode(PluginCodeEntity pluginCodeEntity) {
        Validate.notNull(pluginCodeEntity, "The pluginCode must not be null, create failure.");
        Validate.notNull(pluginCodeEntity.getId(), "The id of pluginCode must not be null, create failure.");

        log.info(String.format("update Service receive pluginCode'pluginCodeId is: [%s]", pluginCodeEntity.getId()));
        PluginCodeEntity updated = pluginCodeRepository.findOne(pluginCodeEntity.getId());
        if (updated == null) {
            throw new ObjectNotFoundException("用户不存在!");
        }
        updated = updated.changeInfoToUpdated(updated);
        PluginCodeEntity saved = pluginCodeRepository.save(updated);
        return saved;
    }

    @Transactional
    public PluginCodeEntity deletePluginCode(Integer id) {
        Validate.notNull(id, "The id must not be null, create failure.");
        PluginCodeEntity deleted = pluginCodeRepository.findOne(id);
        if (deleted == null) {
            throw new ObjectNotFoundException("用户不存在!");
        }
        pluginCodeRepository.delete(id);
        return deleted;
    }

    public List<PluginCodeEntity> findAllPluginCode() {
        return (List<PluginCodeEntity>) pluginCodeRepository.findAll();
    }

}
