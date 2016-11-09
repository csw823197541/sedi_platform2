package com.sedi.entity;

import javax.persistence.*;

/**
 * Created by csw on 2016/11/2 10:03.
 * Explain:
 */
@Entity
@Table(name = "plugin_code")
public class PluginCodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;//key
    private String description;//接收receive、发送send
    private String className;//处理报文对应的groovy插件类名
    private String code;//groovy代码内容


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public PluginCodeEntity changeInfoToUpdated(PluginCodeEntity updated){
        if (updated != null){
            updated.setClassName(this.className);
            updated.setCode(this.code);
            updated.setDescription(this.description);
        }
        return updated;
    }
}
