package com.mindex.challenge;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportingStructureController {

    /*This allows someone to interact with the api*/
    @GetMapping("/reportingstructure")
    public ReportingStructure reportingStructure(@RequestParam(value = "employee",
            defaultValue = "16a596ae-edd3-4847-99fe-c4518e82c86f") String employee){
        return new ReportingStructure(employee);
    }

}// end ReportingStructureController
