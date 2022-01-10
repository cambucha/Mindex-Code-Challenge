package com.mindex.challenge;

/*import for parsing through json. using json-simple-1.1.1 ... https://code.google.com/archive/p/json-simple/downloads*/
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*import for working with file*/
import java.io.FileReader;

/*import for catching exceptions*/
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReportingStructure {

    /*instance variables*/
    private String employee;                                                                        //to hold id of employee
    private int numberOfReports;                                                                    //to hold number of reports

    //default constructor
    public ReportingStructure() {}

    //parameterized constructor
    public ReportingStructure(String emp) {
        this.employee = emp;                                                                        //assigning passed in string to instance variable
        this.calculateNumberOfReports();                                                            //calling the method to determine number of reports
    }

    /*standard getters and setters*/
    public String getEmployee() { return employee; }
    public void setEmployee(String employee) { this.employee = employee; }
    public int getNumberOfReports() { return numberOfReports; }


    /*This method with calculate the number of reports for an employee by parsing through the json file*/
    public void calculateNumberOfReports() {
        /*begin parsing through .json elements with json-simple*/
        JSONParser parser = new JSONParser();

        String desiredEmployeeId = this.getEmployee();                                              //local string to hold desired employee
        int desiredEmpIndex = 0;                                                                    //initializing variable to hold index of appropriate json element

        try{

            /*Parsing file into obj which is then typecasted and assigned to a JSONArray for further parsing through json elements*/
            Object obj = parser.parse(new FileReader("/Users/camerongoldberg/Desktop/mindex-java-code-challenge/src/main/resources/static/employee_database.json"));
            JSONArray arr = (JSONArray) obj;

            /*loop to find index with desired employee*/
            for(int i = 0; i < arr.size(); i++){
                JSONObject findDesiredEmpJsonObj = (JSONObject) arr.get(i);
                if(((String) findDesiredEmpJsonObj.get("employeeId")).equals(desiredEmployeeId)){   //if found, assign index to desiredEmpIndex and break loop
                    desiredEmpIndex = i;
                    break;
                }
            }//end for i...finding employee's index

            JSONObject jsonObject = (JSONObject) arr.get(desiredEmpIndex);                          //must assign to JSONObject to access key-value pair

            int reportsCounter = 0;                                                                 //initialize variable to count number of reports
            //String empId = (String) jsonObject.get("employeeId");

            /*Loop through direct reports. directReports is an array that must have elements assigned as JSONObject to get the value from key*/
            if (jsonObject.get("directReports") != null) {
                JSONArray directReportsArr = (JSONArray) jsonObject.get("directReports");           //creating array of directReports
                reportsCounter = reportsCounter + directReportsArr.size();                          //incrementing report size by array size

                for(int j = 0; j < directReportsArr.size(); j++){                                   //looping through direct reports
                    JSONObject reportsJsonObject = (JSONObject) directReportsArr.get(j);            //jsonobject within array
                    String innerReportId = (String) reportsJsonObject.get("employeeId");            //grabbing employeeid to search json and find number of reports

                    /*iterate through json to find this employee and amount of reports if any*/
                    for(int k = 0; k < arr.size(); k++){
                        JSONObject innerJsonObject = (JSONObject) arr.get(k);                       //another object for iterating through json array

                        if(((String)innerJsonObject.get("employeeId")).equals(innerReportId) ){     //find report to see if the have more reports
                            if(innerJsonObject.get("directReports") != null){                       //checking if they have direct reports as above and incrementing count with array size
                                JSONArray innerDirectReportsArr = (JSONArray) innerJsonObject.get("directReports");
                                reportsCounter = reportsCounter + innerDirectReportsArr.size();
                            }

                        }//end if employeeId found

                    }//end inner loop k...looping through json array to find employeeId of direct report

                }//end outer for j...looping direct reports

            }//end if directReports != null

            this.numberOfReports = reportsCounter;                                                  //setting number of reports to calculated value

        }//end try
        catch(FileNotFoundException e){ e.printStackTrace(); } catch(IOException e){ e.printStackTrace(); }
        catch(ParseException e){ e.printStackTrace(); } catch(Exception e){ e.printStackTrace(); }

    }//end calculateNumberOfReports

}//end class Reporting Structure
