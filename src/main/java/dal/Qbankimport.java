package dal;
import java.io.File;  
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import modal.AddQuestion;  

public class Qbankimport {
	QuestionSheetDAL dal=new QuestionSheetDAL();
	AddQuestion ques=new AddQuestion();
int Count=0;
	
	public String Qimport(InputStream fis,String subject,String std, String setid,String Tid)
	{
	try  
	{  
	//File file = new File("C:\\Users\\DELL\\Documents\\Qsheet.xlsx");   //creating a new file instance  
	//FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
	//creating Workbook instance that refers to .xlsx file  
		
		//var Declare
		String Question="";
		String OpA="";
		String OpB="";
		String OpC="";
		String OpD="";
		String MARKS="";
		String ANS="";

		//upto
		
	XSSFWorkbook wb = new XSSFWorkbook(fis);   
	XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
	Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
	while (itr.hasNext())                 
	{  
	Row row = itr.next();  
	Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column 
	int i=1;
	while (cellIterator.hasNext())   
	{  
	Cell cell = cellIterator.next();  
	System.out.print(i+" - "+cell.getStringCellValue() + "\t\t\t"); 
	 
	
	switch (cell.getCellType())               
	{  
	case Cell.CELL_TYPE_STRING:  
		 
		break;
 

	case Cell.CELL_TYPE_NUMERIC:  
	 
		break;

	case Cell.CELL_TYPE_BLANK:  
		return "Excel sheet in Cell Value is Blank Found "	;
			 
		
	case Cell.CELL_TYPE_ERROR:  
	return "Excel sheet in error cell found"	;
		 
	}
	
	
	switch (cell.getCellType())               
	{  
	case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
	
	
	switch (cell.getStringCellValue().toUpperCase().trim())               
	{
		case "QUESTIONS":    
		Question=cell.getStringCellValue();
		break;
	case "OPTION A":    
		OpA=cell.getStringCellValue();
		break;
	case "OPTION B":    
		OpB=cell.getStringCellValue();
		break;
	case "OPTION C":    
		OpC=cell.getStringCellValue();
		break;
	case "OPTION D":    
		OpD=cell.getStringCellValue();
		break;
	
		
	case "ANSWER":    
		ANS=cell.getStringCellValue();
		break;
		
	case "MARKS":    
		MARKS=cell.getStringCellValue();
		break;
		}
	
	//System.out.print(cell.getStringCellValue() + "\t\t\t");  
	break;  
	case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
	switch (cell.getStringCellValue().toUpperCase().trim())               
		{
	case "MARKS":    
		MARKS=cell.getStringCellValue();
		break;
		}
		
	break;  
	default:  
	}  
	
	
	
	
	System.out.println("");  

	}
	break;
	}
	//validate
	System.out.println("  "+ Question+"  "+OpA+"  "+OpB+"  "+ OpC+"  "+ OpD+" "+ANS+""+MARKS); 
	if(!Question.trim().equalsIgnoreCase("QUESTIONS"))
		return "Questions column Not Found in(First Row And First Column position)";

		if(!OpA.toUpperCase().trim().equalsIgnoreCase("OPTION A"))
		return "Option A Not Found";

		if(!OpB.toUpperCase().trim().equalsIgnoreCase("OPTION B"))
		return "Option B Not Found";

		if(!OpC.toUpperCase().trim().equalsIgnoreCase("OPTION C"))
		return "Option C Not Found";

		if(!OpD.toUpperCase().trim().equalsIgnoreCase("OPTION D"))
		return "Option D Not Found";
		
		if(!ANS.toUpperCase().trim().equalsIgnoreCase("ANSWER"))
			return "ANSWER COLUMNS NOT FOUND";

		if(!MARKS.toUpperCase().trim().equalsIgnoreCase("MARKS"))
		return "MARKS COLUMNS NOT FOUND";

	
	//validate up to..
	/////Data Insert
		boolean isSring=false;
		boolean isNumeric=false;
	  		
		
	while (itr.hasNext())                 
	{  
		if(Count==0) {
			Count++;
			continue;
		}
		
	Row row = itr.next();  
	Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
	int j=1;
	while (cellIterator.hasNext())   
	{  
	Cell cell = cellIterator.next();  
	
	


switch (cell.getCellType())               
{  
case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
	switch (j++)               
	{  
	case 1:  
		Question=cell.getStringCellValue();
		break;
	case 2:     
		OpA=cell.getStringCellValue(); 
		break;
	case 3:     
		OpB=cell.getStringCellValue(); 
		break;
	case 4:     
		OpC=cell.getStringCellValue(); 
		break;
	case 5:    

	OpD=cell.getStringCellValue(); 
		break;
	case 6:     
		ANS=cell.getStringCellValue(); 
		 System.out.println("Raj"+(cell.getStringCellValue()));
		break; 
	case 7:    
		MARKS=cell.getStringCellValue(); 
		break; 
	}  
break;  
case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
	switch (j++)               
	{  
	case 1: 
		 			Question=String.valueOf(cell.getNumericCellValue());
		break;
	case 2:    
		 			OpA=String.valueOf(cell.getNumericCellValue());
		break;
	case 3:    
		 			OpB=String.valueOf(cell.getNumericCellValue());
		break;
	case 4:    
		 			OpC=String.valueOf(cell.getNumericCellValue());
		break;
	case 5:    
		 			OpD=String.valueOf(cell.getNumericCellValue());
		break;
	case 6:    
		 			ANS=String.valueOf(cell.getNumericCellValue());
		 			 System.out.println("Raj"+String.valueOf(cell.getNumericCellValue()));
		break;
		
	case 7:   
		 			MARKS=String.valueOf(cell.getNumericCellValue());
		break;
		}    
break;  
default:  
}  
}  
		
	{ 
		
		 
		   System.out.println("Que No-"+Question); 
		   System.out.println("OpA-"+OpA); 
		   System.out.println("OpB-"+OpB); 
		   System.out.println("OpC-"+OpC); 
		   System.out.println("OpD-"+OpD); 
		   System.out.println("ANS-"+ANS); 
		   System.out.println("subject-"+subject);
		   System.out.println("std-"+std);
		   System.out.println("setid-"+setid);
		   System.out.println("Tid-"+Tid);
		   System.out.println("Marks-"+MARKS);
		   
	  }
	 
	
	System.out.println(""); 
	Count++;
	ques.setQUESTION(Question);
	ques.setA(OpA);
	ques.setB(OpB);
	ques.setC(OpC);
	ques.setD(OpD);
	ques.setANS(ANS);
	ques.setSUBID(subject);//subject,std,setid
	ques.setSTDID(std);
	ques.setCLASSID(std);
	ques.setSETID(setid);	
	ques.setTID(Tid);
	ques.setMarks(MARKS);
	
	 String retval=dal.insertQues(ques);
	  if(retval.toUpperCase().equals("SUCCESS"))
	  { 
		   System.out.println("Que No:-"); 
	  } 
	} 
	
	return "Question Bank Imported Successfully. Total Questions:"+Count;
	}  
	catch(Exception e)  
	{  
	e.printStackTrace(); 
	return e.getMessage();
	}  
}
}


