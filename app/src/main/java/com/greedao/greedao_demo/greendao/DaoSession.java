package com.greedao.greedao_demo.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.greedao.greedao_demo.Employee;
import com.greedao.greedao_demo.IDCard;
import com.greedao.greedao_demo.Leader;
import com.greedao.greedao_demo.LeaderJoinEmployee;

import com.greedao.greedao_demo.greendao.EmployeeDao;
import com.greedao.greedao_demo.greendao.IDCardDao;
import com.greedao.greedao_demo.greendao.LeaderDao;
import com.greedao.greedao_demo.greendao.LeaderJoinEmployeeDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig employeeDaoConfig;
    private final DaoConfig iDCardDaoConfig;
    private final DaoConfig leaderDaoConfig;
    private final DaoConfig leaderJoinEmployeeDaoConfig;

    private final EmployeeDao employeeDao;
    private final IDCardDao iDCardDao;
    private final LeaderDao leaderDao;
    private final LeaderJoinEmployeeDao leaderJoinEmployeeDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        employeeDaoConfig = daoConfigMap.get(EmployeeDao.class).clone();
        employeeDaoConfig.initIdentityScope(type);

        iDCardDaoConfig = daoConfigMap.get(IDCardDao.class).clone();
        iDCardDaoConfig.initIdentityScope(type);

        leaderDaoConfig = daoConfigMap.get(LeaderDao.class).clone();
        leaderDaoConfig.initIdentityScope(type);

        leaderJoinEmployeeDaoConfig = daoConfigMap.get(LeaderJoinEmployeeDao.class).clone();
        leaderJoinEmployeeDaoConfig.initIdentityScope(type);

        employeeDao = new EmployeeDao(employeeDaoConfig, this);
        iDCardDao = new IDCardDao(iDCardDaoConfig, this);
        leaderDao = new LeaderDao(leaderDaoConfig, this);
        leaderJoinEmployeeDao = new LeaderJoinEmployeeDao(leaderJoinEmployeeDaoConfig, this);

        registerDao(Employee.class, employeeDao);
        registerDao(IDCard.class, iDCardDao);
        registerDao(Leader.class, leaderDao);
        registerDao(LeaderJoinEmployee.class, leaderJoinEmployeeDao);
    }
    
    public void clear() {
        employeeDaoConfig.clearIdentityScope();
        iDCardDaoConfig.clearIdentityScope();
        leaderDaoConfig.clearIdentityScope();
        leaderJoinEmployeeDaoConfig.clearIdentityScope();
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public IDCardDao getIDCardDao() {
        return iDCardDao;
    }

    public LeaderDao getLeaderDao() {
        return leaderDao;
    }

    public LeaderJoinEmployeeDao getLeaderJoinEmployeeDao() {
        return leaderJoinEmployeeDao;
    }

}