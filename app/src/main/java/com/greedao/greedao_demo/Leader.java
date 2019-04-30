package com.greedao.greedao_demo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;

import java.util.List;
import org.greenrobot.greendao.DaoException;
import com.greedao.greedao_demo.greendao.DaoSession;
import com.greedao.greedao_demo.greendao.EmployeeDao;
import com.greedao.greedao_demo.greendao.IDCardDao;
import com.greedao.greedao_demo.greendao.LeaderDao;

/**
 * by zhouk
 */
@Entity
public class Leader {
    @Id//(autoincrement = true)//自增长
    Long id;//主键
    String sex;//性别
    int age;//年龄
    @ToOne(joinProperty = "id")
    IDCard idcard;
    @ToMany
    @JoinEntity(entity = LeaderJoinEmployee.class,
            sourceProperty = "lId",
            targetProperty = "eId")
    List<Employee> employeeList;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1059963727)
    private transient LeaderDao myDao;
    @Generated(hash = 1214250264)
    public Leader(Long id, String sex, int age) {
        this.id = id;
        this.sex = sex;
        this.age = age;
    }
    @Generated(hash = 10771711)
    public Leader() {
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
    @Generated(hash = 870433351)
    private transient Long idcard__resolvedKey;
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 786335772)
    public List<Employee> getEmployeeList() {
        if (employeeList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EmployeeDao targetDao = daoSession.getEmployeeDao();
            List<Employee> employeeListNew = targetDao
                    ._queryLeader_EmployeeList(id);
            synchronized (this) {
                if (employeeList == null) {
                    employeeList = employeeListNew;
                }
            }
        }
        return employeeList;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 738888862)
    public synchronized void resetEmployeeList() {
        employeeList = null;
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
    @Generated(hash = 333449767)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getLeaderDao() : null;
    }
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 343001353)
    public IDCard getIdcard() {
        Long __key = this.id;
        if (idcard__resolvedKey == null || !idcard__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            IDCardDao targetDao = daoSession.getIDCardDao();
            IDCard idcardNew = targetDao.load(__key);
            synchronized (this) {
                idcard = idcardNew;
                idcard__resolvedKey = __key;
            }
        }
        return idcard;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2119055661)
    public void setIdcard(IDCard idcard) {
        synchronized (this) {
            this.idcard = idcard;
            id = idcard == null ? null : idcard.getId();
            idcard__resolvedKey = id;
        }
    }
    }
