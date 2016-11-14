package com.sedi.entity;

import javax.persistence.*;

/**
 * Created by csw on 2016/11/2 21:32.
 * Explain:
 */
@Entity
@Table(name = "codemap_detail")
public class CodeMapDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "code_Key")
    private String codeKey;//映射原

    @Column(name = "code_Value")
    private String codeValue;//映射值

    @Column(name = "notes")
    private String notes;

    //被参考对象,是many
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeMapId")
    private CodeMapEntity codeMapEntity;

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

    public CodeMapEntity getCodeMapEntity() {
        return codeMapEntity;
    }

    public void setCodeMapEntity(CodeMapEntity codeMapEntity) {
        this.codeMapEntity = codeMapEntity;
    }

    public CodeMapDetailEntity changeInfoToUpdated(CodeMapDetailEntity updated) {
        if (updated != null) {
            updated.setNotes(this.notes);
            updated.setCodeKey(this.codeKey);
            updated.setCodeMapEntity(this.codeMapEntity);
            updated.setCodeValue(this.codeValue);
        }
        return updated;
    }
}
