package com.bloomtech.welcomeletter.services;

import com.bloomtech.welcomeletter.fileIO.FileManager;
import com.bloomtech.welcomeletter.models.Employee;

import java.io.IOException;

public class FormLetterService {
    private static final FileManager fileManager = new FileManager();

    public void generateWelcomeLetter(Employee employee) throws IOException {
        //TODO: Get template text from resources
        String template_data = fileManager.getTextFromFile("LetterTemplate");

        //TODO: Replace []ed text with correct info

        String fullname = employee.getFirstname() + employee.getLastname();
        String startdate = String.valueOf(employee.getStartdate());
        String startingsalary = String.valueOf(employee.getSalary());
        String company_starttime = String.valueOf(employee.getCompany()) + " " + startdate;

        String replaced_template_data = template_data
                .replace("[fullname]", fullname)
                .replace("[startdate]", startdate)
                .replace("[startingsalary]", startingsalary)
                .replace("[company starttime]", company_starttime);
        //TODO: Write finalized String to file
        String outputFile = "outputfile";
        fileManager.writeTextToFile(outputFile, replaced_template_data);
    }
}
