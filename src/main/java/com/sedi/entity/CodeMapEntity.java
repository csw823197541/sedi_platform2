package com.sedi.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by csw on 2016/11/2 21:30.
 * Explain:
 */
@Entity
@Table(name = "code_map")
public class CodeMapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "codeMap_Id", nullable = false)
    private String codeMapId;//映射关系Id

    @Column(unique = true)
    private String codeMapName;//映射类型名,一般与映射关系Id

    @Column(name = "note")
    private String note;//

    //参考对象,OneToMany,这个对象是one
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "codeMapEntity")
    private Set<CodeMapDetailEntity> codeMapDetailEntitys;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeMapId() {
        return codeMapId;
    }

    public void setCodeMapId(String codeMapId) {
        this.codeMapId = codeMapId;
    }

    public String getCodeMapName() {
        return codeMapName;
    }

    public void setCodeMapName(String codeMapName) {
        this.codeMapName = codeMapName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<CodeMapDetailEntity> getCodeMapDetailEntitys() {
        return codeMapDetailEntitys;
    }

    public void setCodeMapDetailEntitys(Set<CodeMapDetailEntity> codeMapDetailEntitys) {
        this.codeMapDetailEntitys = codeMapDetailEntitys;
    }

    public CodeMapEntity changeInfoToUpdated(CodeMapEntity updated) {
        if (updated != null) {
            updated.setNote(this.note);
            updated.setCodeMapId(this.codeMapId);
            updated.setCodeMapName(this.codeMapName);
            updated.setCodeMapDetailEntitys(this.getCodeMapDetailEntitys());
        }
        return updated;
    }

}
