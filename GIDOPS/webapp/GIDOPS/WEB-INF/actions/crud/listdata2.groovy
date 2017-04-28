import java.util.ArrayList; 
import javolution.util.FastList; 
import org.ofbiz.entity.condition.*;
import org.ofbiz.entity.condition.EntityDateFilterCondition;
import java.text.*;
import java.util.Date;
import org.ofbiz.entity.*;
import org.ofbiz.base.util.*;

    filterBy = parameters.get("myoption");
    list = FastList.newInstance();
    date = new Date();	
	Calendar cal = Calendar.getInstance();
	cal.setTime(date);
	
	//to get the month start date and month end date
	gc = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, 0); 
	gc2 = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1); 
	monthStartDate= new java.util.Date(gc2.getTime().getTime());
	monthEndDate = new java.util.Date(gc.getTime().getTime());	
	
		//to get the week start date 
        Calendar startCal = Calendar.getInstance();
        startCal.setTimeInMillis(cal.getTimeInMillis());
        int dayOfWeek = startCal.get(Calendar.DAY_OF_WEEK);
        startCal.set(Calendar.DAY_OF_MONTH,(startCal.get(Calendar.DAY_OF_MONTH) - dayOfWeek) + 1);
        weekStartDate = new java.util.Date(startCal.getTime().getTime());	
        
        //to get the week end date 
         Calendar endCal = Calendar.getInstance();
         endCal.setTimeInMillis(cal.getTimeInMillis());
         int dayOfWeek2 = endCal.get(Calendar.DAY_OF_WEEK);
         endCal.set(Calendar.DAY_OF_MONTH, endCal.get(Calendar.DAY_OF_MONTH)+ (7 - dayOfWeek2));
         weekEndDate = new java.util.Date(endCal.getTime().getTime());	

        System.out.println("Calculated month start date : " + monthStartDate);
        System.out.println("Calculated month end date : " + monthEndDate);
        System.out.println("Calculated week start date : " + weekStartDate);
        System.out.println("Calculated week end date : " + weekEndDate);
        
        
        //Setting filter conditions
        static EntityCondition filterCondition(field,StartDate, EndDate)
        { 
	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    EntityCondition condition = EntityCondition.makeCondition(EntityOperator.AND,
	    EntityCondition.makeCondition(field,  EntityOperator.GREATER_THAN_EQUAL_TO,UtilDateTime.toSqlDate(sdf.format(StartDate))),
		EntityCondition.makeCondition(field,  EntityOperator.LESS_THAN_EQUAL_TO,UtilDateTime.toSqlDate(sdf.format(EndDate))));		
		return condition;
	    } 	
      //making conditional statement
  if(filterBy == "A")
   { 
       list = delegator.findList("GIDOPSDATA", null, null, null, null, false);
       context.listdatay =list;
   }

    else if(filterBy == "M")
   { 
	try
	{ 
	    condition = EntityCondition.makeCondition(EntityOperator.OR, 
		filterCondition("MVL", monthStartDate, monthEndDate), 
		filterCondition("RWC", monthStartDate, monthEndDate),
		filterCondition("INS", monthStartDate, monthEndDate),
		filterCondition("LGA", monthStartDate, monthEndDate),
		filterCondition("HKNY", monthStartDate, monthEndDate)) 	
	    List<String> sortList=UtilMisc.toList("RegNumber");	
	    data = delegator.findList("GIDOPSDATA",condition,null,sortList,null,true);
	    context.listdatay =data;
	}
	catch(Exception e){System.out.println(e); }   	
   }

   else if(filterBy == "W")
   {
     try
	 { 
	    condition = EntityCondition.makeCondition(EntityOperator.OR, 
		filterCondition("MVL", weekStartDate, weekEndDate), 
		filterCondition("RWC", weekStartDate, weekEndDate),
		filterCondition("INS", weekStartDate, weekEndDate),
		filterCondition("LGA", weekStartDate, weekEndDate),
		filterCondition("HKNY", weekStartDate, weekEndDate)) 	
	    List<String> sortList=UtilMisc.toList("RegNumber");	
	    data = delegator.findList("GIDOPSDATA",condition,null,sortList,null,true);
	    context.listdatay =data;
	}
	catch(Exception e){System.out.println(e); }   	
  }
 

	    	
	
	
