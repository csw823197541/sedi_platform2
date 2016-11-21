package com.sedi.entity;

import javax.persistence.*;

/**
 * Created by csw on 2016/11/2 21:32.
 * Explain:
 */
@Entity
@Table(name = "code_map_detail")
public class CodeMapDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "code_key")
    private String codeKey;//映射原

    @Column(name = "code_value")
    private String codeValue;//映射值

    @Column(name = "notes")
    private String notes;

    //被参考对象,是many
    @Column(name = "code_map_id")
    private Integer codeMapId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeKey() {
        return codeKey;
    }

    public void setCodeKey(String codeKey) {
        this.codeKey = codeKey;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getCodeMapId() {
        return codeMapId;
    }

    public void setCodeMapId(Integer codeMapId) {
        this.codeMapId = codeMapId;
    }

    public CodeMapDetailEntity changeInfoToUpdated(CodeMapDetailEntity updated) {
        if (updated != null) {
            updated.setNotes(this.notes);
            updated.setCodeKey(this.codeKey);
            updated.setCodeMapId(this.codeMapId);
            updated.setCodeValue(this.codeValue);
        }
        return updated;
    }
}
