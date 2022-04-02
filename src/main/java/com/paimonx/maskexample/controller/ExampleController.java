package com.paimonx.maskexample.controller;

import com.paimonx.maskexample.entity.Address;
import com.paimonx.maskexample.entity.AlternateContact;
import com.paimonx.maskexample.entity.Degree;
import com.paimonx.maskexample.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author xu
 * @date 2022/4/2
 */
@RestController
public class ExampleController {

    private static final User USER = new User();

    private static final Address ADDRESS = new Address();

    static {
        USER.setIdNo("13052519971008129X");
        USER.setName("刘赵煦");
        USER.setOnceName(new String[]{"赵旭", "刘旭"});
        USER.setPhone(18801179637L);
        AlternateContact alternateContact = new AlternateContact();
        alternateContact.setNickName("贾先生");
        alternateContact.setPhone("18801179639");
        USER.setAlternateContact(alternateContact);
        USER.setGender("男");
        USER.setProfession("学生");
        USER.setAge(26);
        USER.setBirthday(new Date());

        ADDRESS.setCountry("中国");
        ADDRESS.setProvince("北京市");
        ADDRESS.setCity("北京市");
        ADDRESS.setArea("朝阳区");
        ADDRESS.setDetailed("哈哈哈小区18号楼1单元905");
        USER.setAddress(ADDRESS);

        USER.setHeight(new BigDecimal("70"));
        USER.setWeight(new BigDecimal("180"));
        USER.setMaritalStatus("未婚");

        HashSet<Degree> set = new HashSet<>();
        Degree university = new Degree();
        university.setSchoolName("理工大学");
        university.setStart(2015);
        university.setEnd(2019);
        ArrayList<String> list = new ArrayList<>();
        for (int j = 1; j < 4; j++) {
            list.add(j + "等奖");
        }
        university.setHonor(list);
        Degree highSchool = new Degree();
        highSchool.setSchoolName("石家庄市第二中学");
        highSchool.setStart(2012);
        highSchool.setEnd(2015);
        set.add(university);
        set.add(highSchool);
        USER.setEducational(set);

        USER.setCertificateValidity("2035-10-25");
        ArrayList<String> likes = new ArrayList<>();
        likes.add("eating");
        likes.add("watch tv");
        USER.setLikes(likes);
    }

    /**
     * 普通对象
     * @return
     */
    @GetMapping("/mask/address")
    public Address maskAddress(){
        return ADDRESS;
    }

    /**
     * 嵌套对象
     * @return
     */
    @GetMapping("/mask/user")
    public User maskUser(){
        return USER;
    }

    /**
     * skipUri
     * @return
     */
    @GetMapping("/not/user")
    public User notUser(){
        return USER;
    }


    /**
     * uriType
     * @return
     */
    @GetMapping("/uriType")
    public List<String> uriType(){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(UUID.randomUUID().toString());
        }
        return list;
    }

}
