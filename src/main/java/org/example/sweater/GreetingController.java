package org.example.sweater;

import org.example.sweater.domain.Mtransaction;
import org.example.sweater.repos.MtransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MtransactionRepo mtransactionRepo;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Mtransaction> mtransactions = mtransactionRepo.findAll();
        model.put("mtransactions", mtransactions);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam Double sum, @RequestParam String currency_shortname, Map<String, Object> model) {
        Mtransaction mtransaction = new Mtransaction(sum, currency_shortname);
        mtransactionRepo.save(mtransaction);
        Iterable<Mtransaction> mtransactions = mtransactionRepo.findAll();
        model.put("mtransactions", mtransactions);
        return "main";

    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
       List<Mtransaction> mtransactions = mtransactionRepo.findByCurrencyshortname(filter);
       model.put("mtransactions", mtransactions);
        return "main";

    }
}