//package com.gidops.getitdonedata.events;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.ofbiz.base.util.Debug;
//import org.ofbiz.base.util.UtilDateTime;
//import org.ofbiz.base.util.UtilMisc;
//import org.ofbiz.base.util.UtilValidate;
//import org.ofbiz.entity.Delegator;
//import org.ofbiz.entity.GenericValue;
//import org.ofbiz.service.GenericServiceException;
//import org.ofbiz.service.LocalDispatcher;
//
//import javolution.util.*;
//
//import java.sql.Date;
//import java.text.*;
//import org.ofbiz.base.util.*;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.*;
//public class filterevent{
//
//	public static final String module = filterevent.class.getName();
//	public static String createfilterEvent(HttpServletRequest request, HttpServletResponse response) {
//		Delegator delegator = (Delegator) request.getAttribute("delegator");
//		LocalDispatcher dispatcher = (LocalDispatcher) request.getAttribute("dispatcher");
//		GenericValue userLogin = (GenericValue) request.getSession().getAttribute("userLogin");
//		String filterby = request.getParameter("myoption");
//		List<GenericValue> listIt2 = FastList.newInstance();
//		try {
//			
//			listIt2 = delegator.findAll("GIDOPSDATA",false);
//			
//
//		request.setAttribute("_EVENT_MESSAGE_", "DATA filtered succesfully.");
//		return "success";
//		} catch(Exception ex){
//			
//			Debug.logError(ex, module);
//			return "error";
//		}
//		}
//	}