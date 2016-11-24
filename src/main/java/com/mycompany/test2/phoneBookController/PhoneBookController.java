/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test2.phoneBookController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author kir
 */
@Controller
public class PhoneBookController {

    public static List<String> phonesIvanov;
    public static List<String> phonesPetrov;
    public static List<String> phonesSidorov;
    public static List<String> phonesSmirnov;
    public static HashMap phoneBook;

    @PostConstruct
    public void initialize() {
        phoneBook = new HashMap();
        phonesIvanov = new ArrayList<>();
        phonesPetrov = new ArrayList<>();
        phonesSidorov = new ArrayList<>();
        phonesSmirnov = new ArrayList<>();

        phonesIvanov.add("+8 800 2000 500");
        phonesIvanov.add("+8 800 200 600");

        phonesPetrov.add("+8 800 2000 700");

        phonesSidorov.add("+8 800 2000 800");
        phonesSidorov.add("+8 800 2000 900");
        phonesSidorov.add("+8 800 2000 000");

        phoneBook.put("Иванов И.И.", phonesIvanov);
        phoneBook.put("Петров П.П.", phonesPetrov);
        phoneBook.put("Сидоров С.С.", phonesSidorov);
        phoneBook.put("Смирнов С.С.(Без номеров)", phonesSmirnov);
        System.out.println("phoneBook:" + phoneBook);
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "phoneBook/showNames", method = RequestMethod.GET)
    public List<String> showNames(String subStr) {
        List<String> names = new ArrayList<>();

        Set<Map.Entry<String, List<String>>> set = phoneBook.entrySet();

        for (Map.Entry<String, List<String>> item : set) {
            String name = item.getKey();
            if (name.toLowerCase().contains(subStr.toLowerCase())) {
                names.add(name);
            }
        }

        return names;
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "phoneBook/getAllPhonesByName", method = RequestMethod.GET)
    public Object getAllPhonesByName(String nameStr) {
        System.out.println("here");
        List<String> phones = new ArrayList<>();
        boolean findName=false;
        Set<Map.Entry<String, List<String>>> set = phoneBook.entrySet();
        for (Map.Entry<String, List<String>> item : set) {
            String name = item.getKey();
            if (name.toLowerCase().contains(nameStr.toLowerCase())) {
                findName=true;
                for (String phone : item.getValue()) {
                    phones.add(phone);
                }
            }
        }
        Map results = new HashMap();
        results.put("phones", phones);
        results.put("findName", findName);
        
        return results;
    }

}
