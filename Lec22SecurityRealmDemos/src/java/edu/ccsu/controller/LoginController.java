package edu.ccsu.controller;

import edu.ccsu.model.User;
import edu.ccsu.model.Group;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

@ManagedBean
public class LoginController {

  @PersistenceUnit(unitName = "Lec22SecurityRealmDemosPU")
  private EntityManagerFactory entityManagerFactory;
  @Resource
  private UserTransaction userTransaction;
  @ManagedProperty(value = "#{user}")
  private User user;

  public String createUser() {
    String returnValue = "Error";
    try {
      user.setPassword(Hash(user.getPassword()));
      userTransaction.begin();
      EntityManager em = entityManagerFactory.createEntityManager();
      for (String group : user.getGroupNames()) {
        if (group.length() > 0) {
          Group userGroup = em.find(Group.class, group);
          user.getGroups().add(userGroup);
          userGroup.getUsers().add(user);
        }
      }
      em.persist(user);
      user.getGroups().stream().forEach((group) -> {
        em.persist(group);
      });
      userTransaction.commit();
      em.close();
      returnValue = "UserAdded";
    } catch (Exception e) {
      System.out.println(e.toString());
      e.printStackTrace();
    }
    return returnValue;
  }

  public String Hash(String password) throws NoSuchAlgorithmException {
    MessageDigest msgDigest = MessageDigest.getInstance("MD5");
    byte[] bs;
    msgDigest.reset();
    bs = msgDigest.digest(password.getBytes());
    StringBuilder sBuilder = new StringBuilder();
    for (int i = 0; i < bs.length; i++) {
      String hexVal = Integer.toHexString(0xFF & bs[i]);
      if (hexVal.length() == 1) {
        sBuilder.append("0");
      }
      sBuilder.append(hexVal);
    }
    return sBuilder.toString();
  }

  public LoginController() {

  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
