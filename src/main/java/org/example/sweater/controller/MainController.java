package org.example.sweater.controller;

import org.example.sweater.domain.Mtransaction;
import org.example.sweater.repos.MtransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MtransactionRepo mtransactionRepo;

    @GetMapping("/")
    public String greeting(
            Map<String, Object> model
    ) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Mtransaction> mtransactions = mtransactionRepo.findAll();
        model.put("mtransactions", mtransactions);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam Double sum, @RequestParam String currency_shortname, Map<String, Object> model) {
        Mtransaction mtransaction = new Mtransaction(sum, currency_shortname);
        mtransactionRepo.save(mtransaction);
        Iterable<Mtransaction> mtransactions = mtransactionRepo.findAll();
        model.put("mtransactions", mtransactions);
        return "main";

    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Mtransaction> mtransactions;

        if (filter != null && !filter.isEmpty()) {
            mtransactions = mtransactionRepo.findByCurrencyshortname(filter);
        } else {
            mtransactions = mtransactionRepo.findAll();
        }

        model.put("mtransactions", mtransactions);

        return "main";

    }
}