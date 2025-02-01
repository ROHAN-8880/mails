//package com.outlook.mails.controller;
//
//import com.outlook.mails.service.OutlookMailsService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class OutlookMailsController {
//
//    private OutlookMailsService outlookMailsService;
//
//    public OutlookMailsController(OutlookMailsService outlookMailsService){
//        this.outlookMailsService = outlookMailsService;
//    }
//
//    @GetMapping("/fetch-mails")
//    public String fetchOutlookMails(){
//        outlookMailsService.fetchEmails();
//        return "Mails fetched and saved successfully!";
//    }
//}
