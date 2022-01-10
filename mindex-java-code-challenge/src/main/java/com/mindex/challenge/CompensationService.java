package com.mindex.challenge;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class CompensationService {

    private final CompensationRepository compensationRepository;

    /*constructor*/
    public CompensationService(CompensationRepository compensationRepository) {
        this.compensationRepository = compensationRepository;
    }

    public List<Compensation> getAllCompensation(){
        return compensationRepository.findAll();
    }

}
