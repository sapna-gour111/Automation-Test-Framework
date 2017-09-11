package com.servicenow.utils;

import java.io.File;

import com.google.common.collect.ImmutableList;

/**
 * This class has a collection of all common final variables types in framework.
 * 
 * @author Sapna Gour
 *
 */
public class Constants {

	public static final String RESOURCES_PATH = ToolUtils.getCurrentDir() + File.separator + "src" + File.separator
			+ "main" + File.separator + "resources" + File.separator;

	public static final String DRIVEREXEs_PATH = RESOURCES_PATH + "driverExe" + File.separator;

	public static final String PROPERTY_FILE_PATH = System.getProperty("user.dir") + "\\Test Data\\TestData";

	public static final String PROPERTY_FILE_PATH5 = System.getProperty("user.dir") + "\\Test Data\\TestData_Ja";

	public static final String PROPERTY_FILE_PATH2 = System.getProperty("user.dir") + "\\Test Data\\TestData2";
	public static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "\\config\\Config.properties";

	public static final ImmutableList<String> CLASSIFICATION_OPTIONS = ImmutableList.of("-- None --",
			"Business Applications (ITD)", "Connectivity", "EDI", "Files/Folders", "GPM-Business", "GPM-System", "HCDB",
			"HRGBO Cornerstone (LMS)", "HRGBO Taleo (H2i)", "HRGBO Workday (GHRIS)", "Internet Access",
			"Laptop/Desktop", "Outlook email", "Printer", "Remote Access Token", "Remote connection/VPN", "SAP",
			"ServiceNow", "Sharepoint", "Smartphone/Tablet", "Virus", "VoiceMail", "Web Conference", "Other");

	public static final ImmutableList<String> EXPLAINATION_PHRASES = ImmutableList.of("Can't access systems/Internet",
			"Slow perfomance", "Up and down connection", "Wireless failure", "Other");

	public static final String CREATENEWFAST = "Create New - Fast";
	public static final String ASSIGNEDTOMEFAST = "Assigned to me - Fast";
	public static final String OPENFAST = "Open - Fast";
	public static final String OPENUNASSIGNEDFAST = "Open - Unassigned - Fast";
	public static final String MYGROUPSFAST = "My Groups - Fast";
	public static final String MYGROUPSUNASSIGNEDFAST = "My Groups - Unassigned - Fast";
	public static final String RESOLVEDFAST = "Resolved - Fast";
	public static final String CLOSEDFAST = "Closed - Fast";
	public static final String ALLFAST = "All - Fast";
	public static final String CREATENEWFULL = "Create New - Full";
	public static final String ASSIGNEDTOMEFULL = "Assigned to me - Full";
	public static final String OPENFULL = "Open - Full";
	public static final String OPENUNASSIGNEDFULL = "Open - Unassigned - Full";
	public static final String MYGROUPSFULL = "My Groups - Full";
	public static final String MYGROUPSUNASSIGNEDFULL = "My Groups - Unassigned - Full";
	public static final String RESOLVEDFULL = "Resolved - Full";
	public static final String CLOSEDFULL = "Closed - Full";
	public static final String ALLFULL = "All - Full";

}