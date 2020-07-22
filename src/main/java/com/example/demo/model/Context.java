package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Context {
    //主键
    @Id
    @GenericGenerator(name = "user-uuid", strategy = "uuid")
    @GeneratedValue(generator = "user-uuid")
    private String id;

    //文本内容
    private String context_text;

    @OneToMany(mappedBy = "context",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Qas> qasList;

    @GeneratedValue(generator = "user-uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Qas> getQasList() {
        return qasList;
    }

    public void setQasList(List<Qas> qasList) {
        this.qasList = qasList;
    }

    public String getContext_text() {
        return context_text;
    }

    public void setContext_text(String context_text) {
        this.context_text = context_text;
    }
}
