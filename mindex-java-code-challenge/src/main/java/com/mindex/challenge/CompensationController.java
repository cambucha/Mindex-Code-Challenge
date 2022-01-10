package com.mindex.challenge;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/compensation")
public class CompensationController {

    private final CompensationService compensationService;

    /*constructor*/
    public CompensationController(CompensationService compensationService) {
        this.compensationService = compensationService;
    }

    @GetMapping
    public List<Compensation> fetchAllCompensation(){ return compensationService.getAllCompensation(); }

}
