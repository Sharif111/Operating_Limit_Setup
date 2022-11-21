<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/jstl-core.tld" prefix="core"%>
<%@ page import ="java.util.Date"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ibank.ibanking.businessadministration.bo.IndividualOperatingLimitSetUpBO"%>
<html>
<head>
<bean:message key="label.metaDescription"/>
<bean:message key="label.metaKeywords"/>
<bean:message key="label.metaAuthor"/>
<bean:message key="label.metaExpires"/>
<bean:message key="label.metaImagetoolbar"/>
<bean:message key="label.metaRating"/>
<bean:message key="label.metaGenerator"/>
<bean:message key="label.metaCopyright"/>
<bean:message key="label.metaRobots"/>
<bean:message key="label.metaRevisitAfter"/>
<bean:message key="label.metaPragma"/>
<bean:message key="label.metaDocRights"/>
<bean:message key="label.metaMSSmartTagsPreventParsing"/>
<bean:message key="label.metaLanguage"/>
<bean:message key="label.metaContentType"/>
<bean:message key="label.metaContentStyleType"/>
<bean:message key="label.iBankingTitle"/>
<link rel="stylesheet" href="pages/stylesheet/div-table.css" type="text/css">
<link rel="stylesheet" href="pages/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="pages/stylesheet/style.css" type="text/css">
<link rel="stylesheet" href="pages/stylesheet/example.css" type="text/css">
<script language="JavaScript" src="<html:rewrite page='/pages/javascript/tabber.js'/>"></script>
<link rel="stylesheet" href="pages/stylesheet/jquery-ui.css" type="text/css">
<script language="JavaScript" src="<html:rewrite page='/pages/javascript/jquery-1.9.1.js'/>"></script>
<script language="JavaScript" src="<html:rewrite page='/pages/javascript/jquery-ui.js'/>"></script>
<link rel="stylesheet" href="pages/stylesheet/1.12.1themesbasejquery-ui.css" type="text/css">

<link rel="stylesheet" href="pages/stylesheet/bootstrap.min.3.4.0.css" type="text/css"/>
<script language="JavaScript" src="<html:rewrite page='/pages/javascript/jquery-3.3.1.min.js'/>"></script>
<script language="JavaScript" src="<html:rewrite page='/pages/js/bootstrap.min.3.4.0.js'/>"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script language="JavaScript">var cal = new CalendarPopup();</script>
<script language="javascript" type="text/javascript">
	function   setBodyProperty() {
  		document.oncontextmenu = function(){return false};
  		document.oncut = function(){return false};
		document.ondragstart = function(){return false};
  		document.ondrag = function(){return false};
		var OperationType= document.individualOperatingLimitSetUpForm.operationType.value;
		if(OperationType == "MOB" || OperationType =="DES" || OperationType =="DPD" || OperationType =="BRE" || OperationType =="WAS" ){
		 	document.getElementById("limitLabelID").innerHTML="Sub Type";
		 	$("#highLimitID").show();	
		 }
		 else{
	 	    document.getElementById("limitLabelID").innerHTML="Sub Type";
		 	$("#highLimitID").hide();	
	    }
		
		
		
   	}	
 		
 $(document).ready(
                    /* This is the function that will get executed after the DOM is fully loaded */
	function () {
	
			$("#datepicker1").datepicker({
				dateFormat: 'dd/mm/yy',//this option for formatting a Date
				changeMonth: true, //this option for allowing user to select month
				changeYear: true, //this option for allowing user to select from year range
				yearRange: "-50:+50"
			});
			
			$("#datepicker2").datepicker({
				dateFormat: 'dd/mm/yy',//this option for formatting a Date
				changeMonth: true, //this option for allowing user to select month
				changeYear: true, //this option for allowing user to select from year range
				yearRange: "-50:+50"
			});	
			
			
			var OperationType= document.individualOperatingLimitSetUpForm.operationType.value;
			if(OperationType == "MOB" || OperationType =="DES" || OperationType =="DPD" || OperationType =="BRE" || OperationType =="WAS" ){
			 	document.getElementById("limitLabelID").innerHTML="Sub Type";
			 	$("#highLimitID").show();	
			 }
			 else{
		 	    document.getElementById("limitLabelID").innerHTML="Sub Type";
			 	$("#highLimitID").hide();	
		    }
			
			
						
		   }
		);
 
 
    function doReadOnly(){
		var OperationType= document.individualOperatingLimitSetUpForm.operationType.value;
		if(OperationType == "MOB" || OperationType =="DES" || OperationType =="DPD" || OperationType =="BRE" || OperationType =="WAS" ){
			document.getElementById("limitLabelID").innerHTML="Sub Type";
			$("#highLimitID").show();	
		}
		else{
			document.getElementById("limitLabelID").innerHTML="Sub Type";
			$("#highLimitID").hide();	
		}
			
	}
		

	function doMainMenu(f){
		f.action="/ibanking/indCancelOperatingLimitSetUp.do";
		f.submit();
	}
	function doLogOut(){
		var f = document.individualOperatingLimitSetUpForm;	
			f.action="/ibanking/logOutIBanking.do";
			f.submit();		
	}	
	function doUserDetails(f){
		f.action="/ibanking/indShowDataOperatingLimitSetUp.do?";
		f.submit();	
	}
	
	function doExecute(f){
		if(document.individualOperatingLimitSetUpForm.editFlag.value == "Y"){
			document.individualOperatingLimitSetUpForm.operationMode.value="M";
			f.action="/ibanking/indExecuteOperatingLimitSetUp.do";
			f.submit();
		}
		else{
			document.individualOperatingLimitSetUpForm.operationMode.value="A";
			f.action="/ibanking/indExecuteOperatingLimitSetUp.do";
			f.submit();
		}
	}
		
	
	function doClear(f){
		f.action="/ibanking/individualOperatingLimitSetUp.do";
		f.submit();
	}	
	
	
	function doEdit(f,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12){				
		document.individualOperatingLimitSetUpForm.operationMode.value = "M";
		document.individualOperatingLimitSetUpForm.editFlag.value = "Y";
		document.individualOperatingLimitSetUpForm.serialNo.value=v1;
		document.individualOperatingLimitSetUpForm.userId.value=v2;
		document.individualOperatingLimitSetUpForm.sanctionID.value=v3;
		document.individualOperatingLimitSetUpForm.sanctionDate.value=v4;
		document.individualOperatingLimitSetUpForm.subType.value=v5;
		document.individualOperatingLimitSetUpForm.limitType.value=v6;
		document.individualOperatingLimitSetUpForm.transactionFrequency.value=v7;
		document.individualOperatingLimitSetUpForm.lowLimit.value=v8;
		document.individualOperatingLimitSetUpForm.highLimit.value=v9;
		document.individualOperatingLimitSetUpForm.dailyTranLimit.value=v10;		
		document.individualOperatingLimitSetUpForm.remarks.value=v11;		
		document.individualOperatingLimitSetUpForm.status.value=v12;		
			
	}	
	
	
                
 	
</script>

<style type="text/css">
.labelID{
color:#000000;
 font-size : 10pt; 
 font-family: Verdana,Tahoma,Arial,Helvetica,Sans-serif,sans-serif;
}
.hiddenDiv {
	display: none;
}
.visibleDiv {
	display: block;
}
.show {
	display: compact;
}
.hideRow {
	display: none;
}
tr.spaceUnder>td {
	padding-bottom: 0.3em !important;
}
.ui-datepicker {
	background: #94A3DC;
	border: 1px solid #555;
	color: #EEE;
}
#table_box {
	width: 100%;
	font-size: 13px;
	border-collapse: collapse;
	text-align: center;
}
#table_box th {
	padding: 7px;
	color: #292929;
}
#table_box td {
	padding: 4px 0 4px 0;
	color: #464646;
	border: 1px solid #CCCCCC;
}
.maintb th {
	background-color: #174797;
	color: #FFF!important;
	text-align: center;
}
#table_box tr:nth-child(odd) {
	background-color: #ffffff
} /*odd*/
#table_box tr:nth-child(even) {
	background-color: #e6e6e6
} /* even*/
#table_box tr:hover {
	background-color: #fffbae;
} /* hovering */

.tabletrtd {
 cellpadding= 3;
 cellspacing= 1;
}
.modelul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	border: 1px solid black;
}
.modelli {
	float: left;
}
.modelli {
	display: block;
	color: #000;
	padding: 16px;
	text-decoration: none;
}
.modalHeight {
	padding-top: 60px !important;
}
.modal-header {
	background-color: #103370 !important;
	color: #FFF !important;
}
.body-clr {
	background-color: #e6e6e6 !important;
}
#modal-terms-label {
	color: #FFF;
}
div.tableContainer {
	clear: both;
	border: 1px solid #CCC;
	height: 285px;
	overflow: auto;
	width: 100%;
}
div.tableContainer table {
	float: left;
	width: 100%;
}
div.tableContainer1 {
	clear: both;
	border: 0;
	height: 135px;
	overflow: auto;
	width: 100%;
}
div.tableContainer1 table {
	float: left;
	width: 100%;
}
.headDiv {
	width: 100%;
	height: 20px;
	background-color: #3366FF;
	color: #FFF;
	vertical-align: text-top;
	text-align: center;
	font-family: Verdana, Geneva, sans-serif;
	font-size: 14px;
	font-weight: bolder;
}

</style>

</head>

<body onLoad="setBodyProperty()">
<html:form action="/individualOperatingLimitSetUp" enctype="multipart/form-data" style="margin: 0">
  <table style="width: 100%; height: 100%" border: "0">
    <tr>
       <html:hidden property="serialNo"/>
       <html:hidden property="operationMode"/>
        <html:hidden property="sanctionID"/>
         <html:hidden property="sanctionDate"/>
        <html:hidden property="editFlag"/>   
      
      <td style="height: 50"><table style="width: 100%; border: 0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="8%" valign="top"><bean:message key="label.myBankHeaderLogo"/></td>
                  <td width="92%" class="myBankHeader"><table width="100%" border="0" cellspacing="3" cellpadding="0">
                      <tr>
                        <td width="7%" align="left" valign="top" class="usr-6">&nbsp;</td>
                        <td width="70%" align="center" valign="top" class="usr-6"><%out.print(session.getAttribute("GSCompanyName"));%></td>
                        <td width="16%" align="right" valign="top"><font class="usr-5"> Operation ID : </font></td>
                        <td width="7%" align="left" valign="top"><font class="usr-1">
                          <%out.print(session.getAttribute("GSTellerID"));%>
                          </font></td>
                      </tr>
                      <tr>
                        <td  align="left" valign="top" class="usr-4">&nbsp;</td>
                        <td align="center" valign="top"><font class="usr-4"><span id="BranchName"></span></font></td>
                        <td align="right" valign="top"><font class="usr-5"> Open Date : </font></td>
                        <td align="left" valign="top"><font class="usr-1">
                          <%out.print(session.getAttribute("GSBranchOpenDateDDFormat"));%>
                          </font></td>
                      </tr>
                      <tr>
                        <td height="21" align="left" valign="top">&nbsp;</td>
                        <td align="center" valign="top"><font class="usr-6">System Admin</font><font class="usr-1">
                          <bean:message key="label.-"/>
                          </font>Individual Operating Limit Set Up</td>
                        <td colspan="2" align="right" valign="top"><a href="#" onClick="doMainMenu(individualOperatingLimitSetUpForm)"><font class="usr-5">
                          <bean:message key="label.mainMenu"/>
                          </font></a> <font class="usr-1">
                          <bean:message key="label.|"/>
                          </font> <a href="#"  onClick="doLogOut(individualOperatingLimitSetUpForm)" ><font class="usr-5">
                          <bean:message key="label.signOut"/>
                          </font></a></td>
                      </tr>
                    </table></td>
                </tr>
              </table></td>
          </tr>
          <tr>
            <td colspan="2" valign="top"><a href="#" ><font class="btn"> </font></a> <font class="usr-1"> </font><a href="#" > <font class="btn"> </font></a></td>
          </tr>
          <tr>
            <td colspan="3"><table style="width: 100%; border: 0">
                <tr>
                  <td width="1%">&nbsp;</td>
                  <td width="98%"><table style="width: 100%; border: 0" cellpadding="3" cellspacing="1" >
                      <tr>
                        <td rowspan="3" align="center" class="msg-00"><strong>
                          <%out.print(session.getAttribute("oOperatingLimitSetUpMessageBO"));%>
                          </strong></td>
                      </tr>
                    </table></td>
                  <td width="1%">&nbsp;</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
    </tr>
    <tr><td>&nbsp;</td></tr>
    <tr><td>&nbsp;</td></tr>
    <tr>
      <td valign="top"><table style="width: 100%;border:0;height:100%">
          <tr>
            <td width="31%" valign="top"><div id="tableContainer" class="tableContainer" style="height:400px;">
                <div class="headDiv">User Limit Set Up </div>
                <table width="100%" style="width: 100%;border:0">
                  <tr>
                    <td width="40%"></td>
                    <td width="6%">&nbsp;</td>
                    <td width="54%">&nbsp;</td>
                  </tr>
                  <tr class="spaceUnder">
                    <td align="right" class="lbl-n">User Id</td>
                    <td>&nbsp;</td>
                    <td><html:text property="userId" styleClass="txt-n"  style="width:210px;text-align:right"/></td>
                  </tr>
                   <tr class="spaceUnder">
                    <td align="right" class="lbl-n">Operation Type</td>
                    <td>&nbsp;</td>
                    <td onKeyPress="doUserDetails(individualOperatingLimitSetUpForm)"><html:select property="operationType"  style="width:210px;" onchange="doUserDetails(individualOperatingLimitSetUpForm)">
                        <html:option value="" styleClass="lbl-n">
                          <bean:message key="label.pleaseSelectOne"/>
                        </html:option>
                        <html:options property="operationTypeList" styleClass="txt-n" labelProperty="operationTypeNameList"/>
                      </html:select></td>
                  </tr>
                   <tr class="spaceUnder"  id="highLimitID">
                    <td align="right"><label id="limitLabelID"  class="labelID">Sub Type</label></td>
                    <td>&nbsp;</td>
                    <td><html:select property="subType"  style="width:210px;" >
                        <html:option value="" styleClass="lbl-n">
                          <bean:message key="label.pleaseSelectOne"/>
                        </html:option>
                        <html:options property="subTypeList" styleClass="txt-n" labelProperty="subTypeNameList"/>
                      </html:select></td>
                  </tr>
                  
                  <tr class="spaceUnder">
                    <td align="right" class="lbl-n">Limit Type</td>
                    <td>&nbsp;</td>
                    <td onKeyPress="doReadOnly()"><html:select property="limitType"  style="width:210px;" onchange="doReadOnly()">
                        <html:option value="" styleClass="lbl-n">
                          <bean:message key="label.pleaseSelectOne"/>
                        </html:option>
                        <html:options property="limitTypeList" styleClass="txt-n" labelProperty="limitTypeNameList"/>
                      </html:select></td>
                  </tr>
                  <tr class="spaceUnder">
                    <td align="right" class="lbl-n">Transaction Frequency</td>
                    <td>&nbsp;</td>
                    <td><html:text property="transactionFrequency" styleClass="txt-n"  style="width:210px"/></td>
                  </tr>
                  <tr class="spaceUnder">
                    <td align="right" class="lbl-n">Low Limit</td>
                    <td>&nbsp;</td>
                    <td><html:text property="lowLimit" styleClass="txt-n"  style="width:210px;text-align:right"/></td>
                  </tr>
                    <tr class="spaceUnder">
                      <td align="right" class="lbl-n">High Limit</td>
                    <td>&nbsp;</td>
                    <td><html:text property="highLimit" styleClass="txt-n"  style="width:210px;text-align:right"/></td>
                  </tr>
                  <tr class="spaceUnder">
                    <td align="right" class="lbl-n">Daily Transaction Limit</td>
                    <td>&nbsp;</td>
                    <td><html:text property="dailyTranLimit" styleClass="txt-n"  style="width:210px"/></td>
                  </tr>                                
                  <tr class="spaceUnder">
                    <td align="right" class="lbl-n">Status</td>
                    <td>&nbsp;</td>
                    <td><html:select property="status"  style="width:210px;">
                        <html:option value="" styleClass="lbl-n">
                          <bean:message key="label.pleaseSelectOne"/>
                        </html:option>
                        <html:options property="statusList" styleClass="txt-n" labelProperty="statusNameList"/>
                      </html:select></td>
                  </tr>
                  <tr class="spaceUnder">
                    <td align="right" class="lbl-n">Remarks</td>
                    <td>&nbsp;</td>
                    <td rowspan="4"><html:textarea property="remarks" styleClass="txt-n"  style="width:210px" cols="3" rows="3"/></td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td colspan="3">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="42" align="center" valign="top" class="lbl-n">&nbsp;</td>
                    <td valign="top" class="lbl-n" align="center">&nbsp;</td>
                    <td valign="top" class="lbl-n" align="left"><div style="width:210px;text-align:center;vertical-align:middle">
                        <p>                  
                          <input type="button" value="Submit" onClick="doExecute(individualOperatingLimitSetUpForm)"   style="width:67px;text-align:center;color:#0000ff; font-size : 10pt;font-weight:bold"/>
                          <input type="button" value="Clear"  onClick="doClear(individualOperatingLimitSetUpForm)" style="width:67px;text-align:center;color:#0000ff; font-size : 10pt;font-weight:bold"/>
                        </p>
                        
                    </div></td>
                  </tr>
                  <tr>
                    <td height="16" colspan="3"></td>
                  </tr>
                </table>
              </div></td>
            <td width="2%">&nbsp;</td>
            <td width="67%" valign="top"><div id="tableContainer" class="tableContainer" style="height:400px;">
                <div class="headDiv">User Limit Set Up Details</div>
                <table style="width: 100%" border="1" align="center" cellpadding="3" cellspacing="3" id="table_box" class="maintb">
                  <tr bgcolor="#99CCCC">
                    <th valign="middle" width="5%" style="height: 35" class="lbl-b-08" align="center">Srl #</th>
                    <th valign="middle" width="15%" class="lbl-b-08" align="center">User ID</th>
                    <th valign="middle" width="9%" class="lbl-b-08" align="center">Sanction ID</th>
                    <th valign="middle" width="9%" class="lbl-b-08" align="center">Sanction Date</th>
                    <th valign="middle" width="5%" class="lbl-b-08" align="left">Sub Type</th>
                    <th valign="middle" width="6%" class="lbl-b-08" align="left">Limit Type</th>
                    <th valign="middle" width="5%" class="lbl-b-08" align="left">Tr. Frq</th>                  
                    <th valign="middle" width="6%" class="lbl-b-08" align="center">Low Limit</th>
                     <th valign="middle" width="6%" class="lbl-b-08" align="center">High Limit</th>
                    <th valign="middle" width="8%" class="lbl-b-08" align="center">Daily Tran Limit</th>                   
                    <th valign="middle" width="21%" class="lbl-b-08" align="center">Remarks</th>
                    <th valign="middle" width="6%" class="lbl-b-08" align="center">Status</th>
                    <th valign="middle" width="5%" class="lbl-b-08" align="center">Edit</th>
                  </tr>
                  <%
				  
				 	 
					if(session.getAttribute("oIndividualOperatingLimitSetUpBO")!=null){
					IndividualOperatingLimitSetUpBO mainBO=(IndividualOperatingLimitSetUpBO)session.getAttribute("oIndividualOperatingLimitSetUpBO");
					ArrayList aDestinationBankList=mainBO.getUserLimitList();
					if(aDestinationBankList==null)aDestinationBankList=new ArrayList();
					for(int i=0;i<aDestinationBankList.size();i++){
					IndividualOperatingLimitSetUpBO bo=(IndividualOperatingLimitSetUpBO)aDestinationBankList.get(i);
					String sSerialNo = bo.getSerialNo();
					String sUserId = bo.getUserId();
					String sSanctionID = bo.getSanctionID();
					String sSanctionDate = bo.getSanctionDate();
					String sCurrencyCode = bo.getCurrencyCode();
					String sLimitType = bo.getLimitType();
					String sTransactionFrequency= bo.getTransactionFrequency();										
					String sHighLimit = bo.getHighLimit();
				 	String sLowLimit = bo.getLowLimit();
				 	String sDailyTranLimit=bo.getDailyTranLimit();					
					String sSubType = bo.getSubType();
					String sRemarks = bo.getRemarks();
					String sStatusFlag = bo.getStatusFlag();	
					String sStatus = bo.getStatus();						
					String  sEdit = "Edit";						
					%>
                  <tr bgcolor="#99CCFF">
                    <td valign="top" class="lbl-08" align="center"><%=sSerialNo%></td>
                    <td align="center" valign="top" class="lbl-08"><%=sUserId%></td>
                    <td align="center" valign="top" class="lbl-08"><%=sSanctionID%></td>
                    <td align="center" valign="top" class="lbl-08"><%=sSanctionDate%></td>
                    <td align="center" valign="top" class="lbl-08"><%=sSubType%></td>
                    <td align="center" valign="top" class="lbl-08"><%=sLimitType%></td>
                    <td align="center" valign="top" class="lbl-08"><%=sTransactionFrequency%></td>
                    <td align="right" valign="top" class="lbl-08"><%=sLowLimit%></td>
                    <td align="right" valign="top" class="lbl-08"><%=sHighLimit%></td>
                    <td align="center" valign="top" class="lbl-08"><%=sDailyTranLimit%></td>                   
                    <td align="left" valign="top" class="lbl-08"><%=sRemarks%></td>
                    <td align="center" valign="top" class="lbl-08"><%=sStatus%></td>
                    <td colspan="6" align="center" valign="top"><a href="#" onClick="doEdit(individualOperatingLimitSetUpForm,'<%=sSerialNo%>','<%=sUserId%>','<%=sSanctionID%>','<%=sSanctionDate%>','<%=sSubType%>',
                    '<%=sLimitType%>','<%=sTransactionFrequency%>','<%=sLowLimit%>','<%=sHighLimit%>','<%=sDailyTranLimit%>','<%=sRemarks%>','<%=sStatusFlag%>')"> <font class="link-b-08"><%=sEdit%></font></a></td>
                  </tr>
                  <%         
			  }
		      }
		    %>
                </table>
              </div></td>
          </tr>
        </table></td>
    </tr>
    <div class="modal fade" id="confirm-submit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-sm">
        <div class="modal-content">
          <div class="modal-header" style="background-color:#FFF; font-weight:bold"> Wait ! </div>
          <div class="modal-body"> Are you sure you want to Reverse? </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            <a href="#" onClick="doExecute(individualOperatingLimitSetUpForm)" class="btn btn-success success">Submit</a> </div>
        </div>
      </div>
    </div>
    <div class="modal fade" id="confirm-logout" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-sm">
        <div class="modal-content">
          <div class="modal-header"> Wait ! </div>
          <div class="modal-body"> Are you sure? If you confirm press Log Out button </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            <a href="#" onClick="doLogOut()" class="btn btn-success success">Log Out</a> </div>
        </div>
      </div>
    </div>
    <tr>
      <td><table style="width: 100%; border: 0">
          <tr>
            <td colspan="2" valign="middle" class="lbl-cb" align="center"><bean:message key="label.copyright"/></td>
          </tr>
        </table></td>
    </tr>
  </table>
</html:form>
<script src="pages/assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
