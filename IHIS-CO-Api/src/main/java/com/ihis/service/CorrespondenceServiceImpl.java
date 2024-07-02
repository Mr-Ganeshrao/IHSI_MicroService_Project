package com.ihis.service;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ihis.entity.CitizenAppEntity;
import com.ihis.entity.CorrespondenceTriggerEntity;
import com.ihis.entity.EligibilityDtlsEntity;
import com.ihis.repository.CitizenAppRepository;
import com.ihis.repository.CoTriggerRepository;
import com.ihis.repository.EligibilityDtlsRepository;
import com.ihis.utils.EmailUtils;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class CorrespondenceServiceImpl implements CorrespondenceService {

	@Autowired
	CoTriggerRepository coTriggerRepository;
	@Autowired
	EligibilityDtlsRepository eligibilityDtlsRepository;
	@Autowired
	CitizenAppRepository citizenAppRepository;
	@Autowired
	EmailUtils emailUtils;

	@Override
	public Map<String, Integer> generatedNotices() {
		
		Map<String, Integer> statusMap=new HashMap<>();
		Integer success=0;
		Integer failure=0;
		
		List<CorrespondenceTriggerEntity> pendingTrgs = coTriggerRepository.findByTrgStatus("pending");

		for (CorrespondenceTriggerEntity coTrigger : pendingTrgs) {
			try {
				processTrigger(coTrigger);
				success++;
			} catch (Exception e) {
				failure++;
				e.printStackTrace();
				
			}
		}
		
		statusMap.put("TOTAL ELIGIBLE COUNT :-", pendingTrgs.size());
		statusMap.put("SUCCESS COUNT :- ", success);
		statusMap.put("FAILURE COUNT :-", failure);

		return statusMap;
	}

	private void processTrigger(CorrespondenceTriggerEntity coTrigger) throws Exception {

		// get eligibility data
		
		EligibilityDtlsEntity eligData = eligibilityDtlsRepository.findByCaseNum(coTrigger.getCaseNum());
		CitizenAppEntity citizenData = citizenAppRepository.findByCaseNum(coTrigger.getCaseNum());
		
		// generate pdf

		try {
			generatePdf(eligData, citizenData);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		// send pdf to email
		
		sendPdfAsAttachment(citizenData);
		
		// store pdf in db
		// update trigger as completed
		
		byte[] fileData=new byte[1024];
		FileInputStream fis=new FileInputStream(new File(coTrigger.getCaseNum()+".pdf"));
		fis.read(fileData);
		
		coTrigger.setNotice(fileData);
		coTrigger.setTrgStatus("Completed");
		
		coTriggerRepository.save(coTrigger);
	}

	private void sendPdfAsAttachment(CitizenAppEntity citizenData) {
		
		String subject="Your Eligibility notice -IHIS";
		String body="body";
		emailUtils.sendEmail(citizenData.getEmail(), subject, body, new File(citizenData.getCaseNum()+".pdf"));
		
	}

	private void generatePdf(EligibilityDtlsEntity eligData, CitizenAppEntity citizenData) throws Exception {
	
		Document document=new Document();
		
		FileOutputStream fos=new FileOutputStream(new File(eligData.getCaseNum()+".pdf"));
		
		PdfWriter writer=PdfWriter.getInstance(document, fos);
		
		document.open();
		
		Font font=new Font(Font.HELVETICA,16, Font.BOLDITALIC,Color.RED);
		Paragraph para=new Paragraph("Eligibility Details", font);
		document.add(para);
		
		PdfPTable table = new PdfPTable(2);
		
		
		table.addCell("Holder Name");
		table.addCell(citizenData.getFullName());
		
		table.addCell("Holder SSN");
		table.addCell(String.valueOf(citizenData.getZzn()));
		
		table.addCell("Plan Name");
		table.addCell(eligData.getPlanname());
		
		table.addCell("Plan Status");
		table.addCell(eligData.getPlanstatus());
		
		table.addCell("Start Date");
		table.addCell(String.valueOf(eligData.getStartdate()));
		
		table.addCell("End Date");
		table.addCell(String.valueOf(eligData.getEnd_date()));
		
		table.addCell("Benifit Amount");
		table.addCell(String.valueOf(eligData.getBenefitamt()));
		
		table.addCell("Denial Reason");
		table.addCell(eligData.getDenialreason());
		
	
		
		document.add(table);
		document.close();
		writer.close();
		
	}

}
