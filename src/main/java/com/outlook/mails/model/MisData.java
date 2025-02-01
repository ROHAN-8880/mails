package com.outlook.mails.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class MisData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String jobREF;
    private String customerName;
    private String SILP;
    private Long customerCount;
    private Long numberOfPages;
    private Long numberOfSheets;
    private String artWork;
    private String sizeOfTheStationery;
    private String prePrintingWithColour;
    private String sizeOfTheEnvelop;
    private String modeOfPrinting;
    private String folding;
    private String stuffingAndIlc;
    private String ilc;
    private String blankStationery;
    private String registeredPostAckCard;
    private String registeredPost;
    private String speedPost;
    private String ilcRegisteredPost;
    private LocalDate dateOfReceipt;
    private String approvalReceived;
    private LocalDate dateOfCompletion;
    private String jobHandedOverTo;
    private String deliveryChallan$DocketNo;
    private String invoicedOn;
    private String remarks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobREF() {
        return jobREF;
    }

    public void setJobREF(String jobREF) {
        this.jobREF = jobREF;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSILP() {
        return SILP;
    }

    public void setSILP(String SILP) {
        this.SILP = SILP;
    }

    public Long getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(Long customerCount) {
        this.customerCount = customerCount;
    }

    public Long getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Long numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Long getNumberOfSheets() {
        return numberOfSheets;
    }

    public void setNumberOfSheets(Long numberOfSheets) {
        this.numberOfSheets = numberOfSheets;
    }

    public String getArtWork() {
        return artWork;
    }

    public void setArtWork(String artWork) {
        this.artWork = artWork;
    }

    public String getSizeOfTheStationery() {
        return sizeOfTheStationery;
    }

    public void setSizeOfTheStationery(String sizeOfTheStationery) {
        this.sizeOfTheStationery = sizeOfTheStationery;
    }

    public String getPrePrintingWithColour() {
        return prePrintingWithColour;
    }

    public void setPrePrintingWithColour(String prePrintingWithColour) {
        this.prePrintingWithColour = prePrintingWithColour;
    }

    public String getSizeOfTheEnvelop() {
        return sizeOfTheEnvelop;
    }

    public void setSizeOfTheEnvelop(String sizeOfTheEnvelop) {
        this.sizeOfTheEnvelop = sizeOfTheEnvelop;
    }

    public String getModeOfPrinting() {
        return modeOfPrinting;
    }

    public void setModeOfPrinting(String modeOfPrinting) {
        this.modeOfPrinting = modeOfPrinting;
    }

    public String getFolding() {
        return folding;
    }

    public void setFolding(String folding) {
        this.folding = folding;
    }

    public String getStuffingAndIlc() {
        return stuffingAndIlc;
    }

    public void setStuffingAndIlc(String stuffingAndIlc) {
        this.stuffingAndIlc = stuffingAndIlc;
    }

    public String getIlc() {
        return ilc;
    }

    public void setIlc(String ilc) {
        this.ilc = ilc;
    }

    public String getBlankStationery() {
        return blankStationery;
    }

    public void setBlankStationery(String blankStationery) {
        this.blankStationery = blankStationery;
    }

    public String getRegisteredPostAckCard() {
        return registeredPostAckCard;
    }

    public void setRegisteredPostAckCard(String registeredPostAckCard) {
        this.registeredPostAckCard = registeredPostAckCard;
    }

    public String getRegisteredPost() {
        return registeredPost;
    }

    public void setRegisteredPost(String registeredPost) {
        this.registeredPost = registeredPost;
    }

    public String getSpeedPost() {
        return speedPost;
    }

    public void setSpeedPost(String speedPost) {
        this.speedPost = speedPost;
    }

    public String getIlcRegisteredPost() {
        return ilcRegisteredPost;
    }

    public void setIlcRegisteredPost(String ilcRegisteredPost) {
        this.ilcRegisteredPost = ilcRegisteredPost;
    }

    public LocalDate getDateOfReceipt() {
        return dateOfReceipt;
    }

    public void setDateOfReceipt(LocalDate dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }

    public String getApprovalReceived() {
        return approvalReceived;
    }

    public void setApprovalReceived(String approvalReceived) {
        this.approvalReceived = approvalReceived;
    }

    public LocalDate getDateOfCompletion() {
        return dateOfCompletion;
    }

    public void setDateOfCompletion(LocalDate dateOfCompletion) {
        this.dateOfCompletion = dateOfCompletion;
    }

    public String getJobHandedOverTo() {
        return jobHandedOverTo;
    }

    public void setJobHandedOverTo(String jobHandedOverTo) {
        this.jobHandedOverTo = jobHandedOverTo;
    }

    public String getDeliveryChallan$DocketNo() {
        return deliveryChallan$DocketNo;
    }

    public void setDeliveryChallan$DocketNo(String deliveryChallan$DocketNo) {
        this.deliveryChallan$DocketNo = deliveryChallan$DocketNo;
    }

    public String getInvoicedOn() {
        return invoicedOn;
    }

    public void setInvoicedOn(String invoicedOn) {
        this.invoicedOn = invoicedOn;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}