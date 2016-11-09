package com.sedi.service;

import com.sedi.entity.PluginCodeEntity;

import java.util.List;

/**
 * Created by csw on 2016/11/4.
 */
public interface PluginCodeService {
    PluginCodeEntity createPluginCode(PluginCodeEntity pluginCodeEntity);
    PluginCodeEntity updatePluginCode(PluginCodeEntity pluginCode);
    PluginCodeEntity deletePluginCode(Integer id);

    List<PluginCodeEntity> findAllPluginCode();


}
