package com.outlook.mails.service;

import com.outlook.mails.model.MisData;
import com.outlook.mails.repository.MisDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MisDataService {

    @Autowired
    private MisDataRepository misDataRepository;

    public void saveMisData(MisData misData){
        misDataRepository.save(misData);
    }


}
