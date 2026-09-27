package com.khoivu.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOIpml implements MemberDAO {
  @Override
  public void addAccount() {
    System.out.println(getClass() + ": ADD MEMBER ACCOUNT");
  }

}
