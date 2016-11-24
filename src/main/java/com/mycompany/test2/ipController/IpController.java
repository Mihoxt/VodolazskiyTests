/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test2.ipController;

import java.util.ArrayList;
import java.util.List;
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
public class IpController {

    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "ip/showIpsByRange", method = RequestMethod.GET)
    public List<String> showIpsByRange2(String from, String to) {

        String[] ipArayFrom = from.split("\\.");
        String[] ipArayTo = to.split("\\.");
        int biggerOne = Integer.parseInt(ipArayFrom[0]) > Integer.parseInt(ipArayTo[0]) ? Integer.parseInt(ipArayFrom[0]) : Integer.parseInt(ipArayTo[0]);
        int smallerOne = Integer.parseInt(ipArayFrom[0]) < Integer.parseInt(ipArayTo[0]) ? Integer.parseInt(ipArayFrom[0]) : Integer.parseInt(ipArayTo[0]);

        int biggerTwo = Integer.parseInt(ipArayFrom[1]) > Integer.parseInt(ipArayTo[1]) ? Integer.parseInt(ipArayFrom[1]) : Integer.parseInt(ipArayTo[1]);
        int smallerTwo = Integer.parseInt(ipArayFrom[1]) < Integer.parseInt(ipArayTo[1]) ? Integer.parseInt(ipArayFrom[1]) : Integer.parseInt(ipArayTo[1]);

        int biggerThree = Integer.parseInt(ipArayFrom[2]) > Integer.parseInt(ipArayTo[2]) ? Integer.parseInt(ipArayFrom[2]) : Integer.parseInt(ipArayTo[2]);
        int smallerThree = Integer.parseInt(ipArayFrom[2]) < Integer.parseInt(ipArayTo[2]) ? Integer.parseInt(ipArayFrom[2]) : Integer.parseInt(ipArayTo[2]);

        int biggerFour = Integer.parseInt(ipArayFrom[3]) > Integer.parseInt(ipArayTo[3]) ? Integer.parseInt(ipArayFrom[3]) : Integer.parseInt(ipArayTo[3]);
        int smallerFour = Integer.parseInt(ipArayFrom[3]) < Integer.parseInt(ipArayTo[3]) ? Integer.parseInt(ipArayFrom[3]) : Integer.parseInt(ipArayTo[3]);

        boolean oneb = false;
        boolean twob = false;
        boolean threeb = false;
        boolean fourb = false;

        List<Integer> one = new ArrayList<>();
        if (biggerOne == smallerOne) {
            oneb = true;
            one.add(biggerOne);
        }
        else {
            for (int i = smallerOne; i < biggerOne + 1; i++) {
                one.add(i);
            }
        }
        List<Integer> two = new ArrayList<>();
        if (biggerTwo == smallerTwo) {
            twob = true;
            two.add(biggerTwo);
        }
        else {
            for (int i = smallerTwo; i < biggerTwo + 1; i++) {
                two.add(i);
            }
        }
        List<Integer> three = new ArrayList<>();
        if (biggerThree == smallerThree) {
            threeb = true;
            three.add(biggerThree);
        }
        else {
            for (int i = smallerThree; i < biggerThree + 1; i++) {
                three.add(i);
            }
        }
        List<Integer> four = new ArrayList<>();
        if (biggerFour == smallerFour) {
            fourb = true;
            four.add(biggerFour);
        } 
        else {
            for (int i = smallerFour; i < biggerFour + 1; i++) {
                four.add(i);
            }
        }
        List<String> readyArray = new ArrayList<>();
        
        
        if (!(oneb == true && twob == true && threeb == true && fourb == true)) {

            for (Integer oneMirr : one) {
                for (Integer twoMirr : two) {
                    for (Integer threeMirr : three) {
                        for (Integer fourMirr : four) {
                            if (!(oneMirr == Integer.parseInt(ipArayFrom[0]) && twoMirr == Integer.parseInt(ipArayFrom[1])
                                    && threeMirr == Integer.parseInt(ipArayFrom[2]) && fourMirr == Integer.parseInt(ipArayFrom[3]))
                                    && !(oneMirr == Integer.parseInt(ipArayTo[0]) && twoMirr == Integer.parseInt(ipArayTo[1])
                                    && threeMirr == Integer.parseInt(ipArayTo[2]) && fourMirr == Integer.parseInt(ipArayTo[3]))) {
                                StringBuilder readyIp = new StringBuilder();
                                readyArray.add(readyIp.append(oneMirr).append(".").append(twoMirr).append(".").append(threeMirr).append(".").append(fourMirr).toString());
                            }
                        }
                    }
                }
            }
        }

        return readyArray;
    }
}
