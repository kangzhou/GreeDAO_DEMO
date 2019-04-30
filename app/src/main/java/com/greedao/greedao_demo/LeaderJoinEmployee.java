package com.greedao.greedao_demo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class LeaderJoinEmployee {
    @Id
    private Long id;
    private Long lId;
    private Long eId;
    @Generated(hash = 1302089704)
    public LeaderJoinEmployee(Long id, Long lId, Long eId) {
        this.id = id;
        this.lId = lId;
        this.eId = eId;
    }
    @Generated(hash = 1514440294)
    public LeaderJoinEmployee() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getLId() {
        return this.lId;
    }
    public void setLId(Long lId) {
        this.lId = lId;
    }
    public Long getEId() {
        return this.eId;
    }
    public void setEId(Long eId) {
        this.eId = eId;
    }
}
