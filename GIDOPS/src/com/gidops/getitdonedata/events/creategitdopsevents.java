package com.gidops.getitdonedata.events;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ofbiz.base.util.Debug;
import org.ofbiz.base.util.UtilDateTime;
import org.ofbiz.base.util.UtilMisc;
import org.ofbiz.base.util.UtilValidate;
import org.ofbiz.entity.Delegator;
import org.ofbiz.entity.GenericValue;
import org.ofbiz.service.GenericServiceException;
import org.ofbiz.service.LocalDispatcher;
import java.sql.Date;
import java.text.*;
import org.ofbiz.base.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
public class creategitdopsevents{
	public static final String module = creategitdopsevents.class.getName();
	public static String creategidopsEvent(HttpServletRequest request, HttpServletResponse response) {
		Delegator delegator = (Delegator) request.getAttribute("delegator");
		LocalDispatcher dispatcher = (LocalDispatcher) request.getAttribute("dispatcher");
		GenericValue userLogin = (GenericValue) request.getSession().getAttribute("userLogin");
		String customername = request.getParameter("CustomerNametxt");
		String regnumber = request.getParameter("RegNumbertxt");
		String vehmakemodel = request.getParameter("VehMakeModeltxt");
		String engcapacity = request.getParameter("EngCapacitytxt");
		String fDate = request.getParameter("MVLtxt");
		String fDate2 = request.getParameter("RWCtxt");
		String fDate3 = request.getParameter("INStxt");
		String fDate4 = request.getParameter("HKNYtxt");
		String fDate5 = request.getParameter("LGAtxt");
		Debug.logInfo("GIDPOS Form Data: " + fDate+ fDate2 + fDate3 + fDate4 + fDate5 , module);
		DateFormat f1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date date1 = (java.util.Date) f1.parse(fDate);
			java.util.Date date2 = (java.util.Date) f1.parse(fDate2);
			java.util.Date date3 = (java.util.Date) f1.parse(fDate3);
			java.util.Date date4 = (java.util.Date) f1.parse(fDate4);
			java.util.Date date5 = (java.util.Date) f1.parse(fDate5);
			SimpleDateFormat f2 = new SimpleDateFormat("MM/dd/yyyy");
			String datestring2 = f2.format(date1);
			String datestring3 = f2.format(date2);
			String datestring4 = f2.format(date3);
			String datestring5 = f2.format(date4);
			String datestring6 = f2.format(date5);
			Debug.logInfo("Formatted Date String: " + datestring2 + datestring3 + datestring4 + datestring5 + datestring6, module);
			Date datey = UtilDateTime.toSqlDate(datestring2);
			Date datey2 = UtilDateTime.toSqlDate(datestring3);
			Date datey3 = UtilDateTime.toSqlDate(datestring4);
			Date datey4 = UtilDateTime.toSqlDate(datestring5);
			Date datey5 = UtilDateTime.toSqlDate(datestring6);
			Debug.logInfo("SqlDate: " + datey.toString() + datey2.toString() + datey3.toString() + datey4.toString() + datey5.toString(), module);
			if (UtilValidate.isNotEmpty(customername) && UtilValidate.isNotEmpty(regnumber)) 
			{
				String reggy = regnumber.toUpperCase();
				Debug.logInfo("=======Creating Get it done record=========",module);
				HashMap mappy = new HashMap();
				mappy.put("CustomerName", customername);
				mappy.put("RegNumber", reggy);
				mappy.put("VehMakeModel", vehmakemodel);
				mappy.put("EngCapacity", engcapacity);
				mappy.put("MVL", datey);
				mappy.put("RWC", datey2);
				mappy.put("INS", datey3);
				mappy.put("HKNY", datey4);
				mappy.put("LGA", datey5);
				mappy.put("userLogin", userLogin);
				dispatcher.runSync("CreateGetItDone", mappy);
			} 
			else
			{
				String errMsg = "Customer name or registration number are required fields on the form and can't be empty.";
				request.setAttribute("_ERROR_MESSAGE_", errMsg);
				return "error";
			}

		} catch (ParseException pex) {
			Debug.logInfo(pex.getMessage(), module);
			pex.printStackTrace();
		} catch (GenericServiceException e) {
			String errMsg = "Unable to create new records in GIDOPSDATA Entity: " + e.toString();
			request.setAttribute("_ERROR_MESSAGE_", errMsg);
			return "error";
		}
		request.setAttribute("_EVENT_MESSAGE_", "DATA Added succesfully.");
		return "success";
	}
}