package com.greedao.greedao_demo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.greedao.greedao_demo.greendao.DaoSession;
import com.greedao.greedao_demo.greendao.IDCardDao;
import com.greedao.greedao_demo.greendao.EmployeeDao;

import java.util.List;
import com.greedao.greedao_demo.greendao.LeaderDao;

/**
 * by zhouk
 */
@Entity
public class Employee {
    @Id(autoincrement = true)//自增长
    Long id;//主键
    String sex;//性别
    int age;//年龄
    @ToOne(joinProperty = "id")
    IDCard idCard;
    @ToMany
    @JoinEntity(entity = LeaderJoinEmployee.class,
            sourceProperty = "eId",
            targetProperty = "lId")
    List<Leader> leaderList;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 694547204)
    private transient EmployeeDao myDao;
    @Generated(hash = 388797615)
    public Employee(Long id, String sex, int age) {
        this.id = id;
        this.sex = sex;
        this.age = age;
    }
    @Generated(hash = 202356944)
    public Employee() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Generated(hash = 602561657)
    private transient Long idCard__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 327600324)
    public IDCard getIdCard() {
        Long __key = this.id;
        if (idCard__resolvedKey == null || !idCard__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            IDCardDao targetDao = daoSession.getIDCardDao();
            IDCard idCardNew = targetDao.load(__key);
            synchronized (this) {
                idCard = idCardNew;
                idCard__resolvedKey = __key;
            }
        }
        return idCard;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2061272925)
    public void setIdCard(IDCard idCard) {
        synchronized (this) {
            this.idCard = idCard;
            id = idCard == null ? null : idCard.getId();
            idCard__resolvedKey = id;
        }
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 329529396)
    public List<Leader> getLeaderList() {
        if (leaderList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            LeaderDao targetDao = daoSession.getLeaderDao();
            List<Leader> leaderListNew = targetDao._queryEmployee_LeaderList(id);
            synchronized (this) {
                if (leaderList == null) {
                    leaderList = leaderListNew;
                }
            }
        }
        return leaderList;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 395409256)
    public synchronized void resetLeaderList() {
        leaderList = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 671679171)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getEmployeeDao() : null;
    }
   }
