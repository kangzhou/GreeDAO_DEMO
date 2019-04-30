package com.greedao.greedao_demo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.greedao.greedao_demo.base.MyApplication;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.insertBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
        findViewById(R.id.getdataBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getList();
            }
        });
        findViewById(R.id.updataBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void getList(){
        List<Employee> employeeList = MyApplication.getDaoSession().queryBuilder(Employee.class).list();
        for (int i = 0; i < employeeList.size(); i++) {
            for (int j = 0; j < employeeList.get(i).getLeaderList().size(); j++) {
                Log.e("Tag","职员： ("+employeeList.get(i).getIdCard().getEmployeeNo()+")"+employeeList.get(j).getIdCard().getName()+"  的领导是：("+employeeList.get(i).getLeaderList().get(j).getIdcard().getEmployeeNo()+")"+employeeList.get(i).getLeaderList().get(j).getIdcard().getName());
            }
        }
        List<Leader> leaderList = MyApplication.getDaoSession().queryBuilder(Leader.class).list();
        for (int i = 0; i < leaderList.size(); i++) {
            for (int j = 0; j < leaderList.get(i).getEmployeeList().size(); j++) {
                Log.e("Tag","领导：("+leaderList.get(i).getIdcard().getEmployeeNo()+")"+leaderList.get(i).getIdcard().getName()+"手下的员工有：("+leaderList.get(i).getEmployeeList().get(j).getIdCard().getEmployeeNo()+")"+leaderList.get(i).getEmployeeList().get(j).getIdCard().getName());
            }
        }
    }
    private void insertData(){
        IDCard idCard1 = new IDCard(null,"Tom","N111111");
        Long id1 = MyApplication.getDaoSession().getIDCardDao().insertOrReplace(idCard1);
        Employee employee1 = new Employee(id1,"男",23);
        employee1.setIdCard(idCard1);


        IDCard idCard2 = new IDCard(null,"Jack","N2222222");
        Long id2 = MyApplication.getDaoSession().getIDCardDao().insertOrReplace(idCard2);
        Employee employee2 = new Employee(id2,"男",24);
        employee2.setIdCard(idCard2);

        IDCard idCard3 = new IDCard(null,"Lucy","N3333333");
        Long id3 = MyApplication.getDaoSession().getIDCardDao().insertOrReplace(idCard3);
        Employee employee3 = new Employee(id3,"女",25);
        employee3.setIdCard(idCard3);

        IDCard idCard4 = new IDCard(null,"Jame","N4444444");
        Long id4 = MyApplication.getDaoSession().getIDCardDao().insertOrReplace(idCard4);
        Employee employee4 = new Employee(id4,"男",26);
        employee4.setIdCard(idCard4);

        IDCard idCard5 = new IDCard(null,"领导1","L1111111");
        Long id5 = MyApplication.getDaoSession().getIDCardDao().insertOrReplace(idCard5);
        Leader leader1 = new Leader(id5,"女",32);
        leader1.setIdcard(idCard5);

        IDCard idCard6 = new IDCard(null,"领导2","L2222222");
        Long id6 = MyApplication.getDaoSession().getIDCardDao().insertOrReplace(idCard6);
        Leader leader2 = new Leader(id6,"女",33);
        leader2.setIdcard(idCard6);

        IDCard idCard7 = new IDCard(null,"领导3","L3333333");
        Long id7 = MyApplication.getDaoSession().getIDCardDao().insertOrReplace(idCard7);
        Leader leader3 = new Leader(id7,"女",34);
        leader3.setIdcard(idCard7);


        //插入四个职员入表
        MyApplication.getDaoSession().getEmployeeDao().insertOrReplace(employee1);
        MyApplication.getDaoSession().getEmployeeDao().insertOrReplace(employee2);
        MyApplication.getDaoSession().getEmployeeDao().insertOrReplace(employee3);
        MyApplication.getDaoSession().getEmployeeDao().insertOrReplace(employee4);
        //插入三个领导入表
        MyApplication.getDaoSession().getLeaderDao().insertOrReplace(leader1);
        MyApplication.getDaoSession().getLeaderDao().insertOrReplace(leader2);
        MyApplication.getDaoSession().getLeaderDao().insertOrReplace(leader3);
        //关联领导跟职员的关系
        List<LeaderJoinEmployee> leaderJoinEmployeeList = new ArrayList<>();
        //领导1有1.2.3号职员
        LeaderJoinEmployee leaderJoinEmployee1 = new LeaderJoinEmployee(null,5L,1L);
        LeaderJoinEmployee leaderJoinEmployee2 = new LeaderJoinEmployee(null,5L,2L);
        LeaderJoinEmployee leaderJoinEmployee3 = new LeaderJoinEmployee(null,5L,3L);
        leaderJoinEmployeeList.add(leaderJoinEmployee1);
        leaderJoinEmployeeList.add(leaderJoinEmployee2);
        leaderJoinEmployeeList.add(leaderJoinEmployee3);
        //领导2有124号职员
        LeaderJoinEmployee leaderJoinEmployee4 = new LeaderJoinEmployee(null,6L,1L);
        LeaderJoinEmployee leaderJoinEmployee5 = new LeaderJoinEmployee(null,6L,2L);
        LeaderJoinEmployee leaderJoinEmployee6 = new LeaderJoinEmployee(null,6L,4L);
        leaderJoinEmployeeList.add(leaderJoinEmployee4);
        leaderJoinEmployeeList.add(leaderJoinEmployee5);
        leaderJoinEmployeeList.add(leaderJoinEmployee6);

        //领导3有134号职员
        LeaderJoinEmployee leaderJoinEmployee7 = new LeaderJoinEmployee(null,7L,1L);
        LeaderJoinEmployee leaderJoinEmployee8 = new LeaderJoinEmployee(null,7L,3L);
        LeaderJoinEmployee leaderJoinEmployee9 = new LeaderJoinEmployee(null,7L,4L);
        leaderJoinEmployeeList.add(leaderJoinEmployee7);
        leaderJoinEmployeeList.add(leaderJoinEmployee8);
        leaderJoinEmployeeList.add(leaderJoinEmployee9);

        MyApplication.getDaoSession().getLeaderJoinEmployeeDao().insertInTx(leaderJoinEmployeeList);
    }
}
