package com.sedi.entity;

import javax.persistence.*;

/**
 * Created by csw on 2016/11/2 21:36.
 * Explain:
 */
@Entity
@Table(name = "mail_box")
public class MailBoxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    private String mailBoxName;//信箱名称

    @Column(nullable = false)
    private String className;//处理发送报文的groovy类名
    private String notes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMailBoxName() {
        return mailBoxName;
    }

    public void setMailBoxName(String mailBoxName) {
        this.mailBoxName = mailBoxName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public MailBoxEntity changeInfoToUpdated(MailBoxEntity updated) {
        if (updated != null) {
            updated.setClassName(this.className);
            updated.setNotes(this.notes);
            updated.setMailBoxName(this.mailBoxName);

        }
        return updated;
    }

}
