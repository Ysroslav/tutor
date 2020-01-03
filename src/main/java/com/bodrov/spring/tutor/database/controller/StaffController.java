package com.bodrov.spring.tutor.database.controller;

import com.bodrov.spring.tutor.database.entity.Poll;
import com.bodrov.spring.tutor.database.entity.Result;
import com.bodrov.spring.tutor.database.entity.Staff;
import com.bodrov.spring.tutor.database.repository.PollRepository;
import com.bodrov.spring.tutor.database.repository.ResultRepository;
import com.bodrov.spring.tutor.database.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class StaffController {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private ResultRepository resultRepository;


   @RequestMapping(value = "/staff-card",method = RequestMethod.GET)
    public String openCard(@RequestParam("id") String staffId, Map<String, Object> model){
       final Staff staff = staffRepository.findById(staffId).get();
       model.put("staff", staff);
       model.put("polls", pollRepository.findAll());
       final List<Poll> pollsOff = new ArrayList<>();
       final List<Result> results = resultRepository.findAllByStaff(staff);
       for(int i=0;i<results.size();i++) pollsOff.add(results.get(i).getPoll());
       model.put("pollsOff", pollsOff);
       return "staff-card";
   }



}
