/* Decompiler 28ms, total 298ms, lines 269 */
package com.ibank.ibanking.businessadministration.bo;

import java.io.Serializable;
import java.util.ArrayList;

public class OperatingLimitSetUpBO implements Serializable {
   private String sUserID = "";
   private String sSanctionID = "";
   private String sSanctionDate = "";
   private String sCurrencyCode = "";
   private String sLimitType = "";
   private ArrayList aLimitTypeList = new ArrayList();
   private ArrayList aLimitTypeNameList = new ArrayList();
   private String sTransactionFrequency = "";
   private String sLowLimit = "";
   private String sHighLimit = "";
   private String sFromDate = "";
   private String sToDate = "";
   private String sStatusFlag = "";
   private String sStatus = "";
   private ArrayList aStatusList = new ArrayList();
   private ArrayList aStatusNameList = new ArrayList();
   private String sRemarks = "";
   private String sOperationMode = "";
   private ArrayList aUserLimitList = new ArrayList();
   private String sOperationType = "";
   private ArrayList aOperationTypeList = new ArrayList();
   private ArrayList aOperationTypeNameList = new ArrayList();
   private String sSerialNo = "";
   private String sErrorCode = "";
   private String sErrorMessage = "";
   private ArrayList aList = new ArrayList();
   private String sMenu = "";
   private ArrayList aMenuList = new ArrayList();
   private ArrayList aMenuNameList = new ArrayList();
   private String sDailyTranLimit = "";
   private String sEditFlag = "";
   private String sSubType="";
   private ArrayList aSubTypeList = new ArrayList();
   private ArrayList aSubTypeNameList = new ArrayList();
   
   
   public String getSubType() {
	return sSubType;
}

public void setSubType(String subType) {
	this.sSubType = subType;
}

public ArrayList getSubTypeList() {
	return aSubTypeList;
}

public void setSubTypeList(ArrayList subTypeList) {
	this.aSubTypeList = subTypeList;
}

public ArrayList getSubTypeNameList() {
	return aSubTypeNameList;
}

public void setSubTypeNameList(ArrayList subTypeNameList) {
	this.aSubTypeNameList = subTypeNameList;
}

  
	
	
	public String getEditFlag() {
		return sEditFlag;
	}

	public void setEditFlag(String editFlag) {
		this.sEditFlag = editFlag;
	}

   public String getDailyTranLimit() {
	return sDailyTranLimit;
}

public void setDailyTranLimit(String dailyTranLimit) {
	this.sDailyTranLimit = dailyTranLimit;
}

public String getUserID() {
      return this.sUserID;
   }

   public void setUserID(String sUserID) {
      this.sUserID = sUserID;
   }

   public String getLimitType() {
      return this.sLimitType;
   }

   public void setLimitType(String sLimitType) {
      this.sLimitType = sLimitType;
   }

   public ArrayList getLimitTypeList() {
      return this.aLimitTypeList;
   }

   public void setLimitTypeList(ArrayList aLimitTypeList) {
      this.aLimitTypeList = aLimitTypeList;
   }

   public ArrayList getLimitTypeNameList() {
      return this.aLimitTypeNameList;
   }

   public void setLimitTypeNameList(ArrayList aLimitTypeNameList) {
      this.aLimitTypeNameList = aLimitTypeNameList;
   }

   public String getTransactionFrequency() {
      return this.sTransactionFrequency;
   }

   public void setTransactionFrequency(String sTransactionFrequency) {
      this.sTransactionFrequency = sTransactionFrequency;
   }

   public String getFromDate() {
      return this.sFromDate;
   }

   public void setFromDate(String sFromDate) {
      this.sFromDate = sFromDate;
   }

   public String getToDate() {
      return this.sToDate;
   }

   public void setToDate(String sToDate) {
      this.sToDate = sToDate;
   }

   public String getStatus() {
      return this.sStatus;
   }

   public void setStatus(String sStatus) {
      this.sStatus = sStatus;
   }

   public ArrayList getStatusList() {
      return this.aStatusList;
   }

   public void setStatusList(ArrayList aStatusList) {
      this.aStatusList = aStatusList;
   }

   public ArrayList getStatusNameList() {
      return this.aStatusNameList;
   }

   public void setStatusNameList(ArrayList aStatusNameList) {
      this.aStatusNameList = aStatusNameList;
   }

   public String getRemarks() {
      return this.sRemarks;
   }

   public void setRemarks(String sRemarks) {
      this.sRemarks = sRemarks;
   }

   public ArrayList getUserLimitList() {
      return this.aUserLimitList;
   }

   public void setUserLimitList(ArrayList aUserLimitList) {
      this.aUserLimitList = aUserLimitList;
   }

   public String getSerialNo() {
      return this.sSerialNo;
   }

   public void setSerialNo(String sSerialNo) {
      this.sSerialNo = sSerialNo;
   }

   public String getErrorCode() {
      return this.sErrorCode;
   }

   public void setErrorCode(String sErrorCode) {
      this.sErrorCode = sErrorCode;
   }

   public String getErrorMessage() {
      return this.sErrorMessage;
   }

   public void setErrorMessage(String sErrorMessage) {
      this.sErrorMessage = sErrorMessage;
   }

   public ArrayList getList() {
      return this.aList;
   }

   public void setList(ArrayList aList) {
      this.aList = aList;
   }

   public String getMenu() {
      return this.sMenu;
   }

   public void setMenu(String sMenu) {
      this.sMenu = sMenu;
   }

   public ArrayList getMenuList() {
      return this.aMenuList;
   }

   public void setMenuList(ArrayList aMenuList) {
      this.aMenuList = aMenuList;
   }

   public ArrayList getMenuNameList() {
      return this.aMenuNameList;
   }

   public void setMenuNameList(ArrayList aMenuNameList) {
      this.aMenuNameList = aMenuNameList;
   }

   public String getSanctionID() {
      return this.sSanctionID;
   }

   public void setSanctionID(String sSanctionID) {
      this.sSanctionID = sSanctionID;
   }

   public String getOperationMode() {
      return this.sOperationMode;
   }

   public void setOperationMode(String sOperationMode) {
      this.sOperationMode = sOperationMode;
   }

   public String getSanctionDate() {
      return this.sSanctionDate;
   }

   public void setSanctionDate(String sSanctionDate) {
      this.sSanctionDate = sSanctionDate;
   }

   public String getCurrencyCode() {
      return this.sCurrencyCode;
   }

   public void setCurrencyCode(String sCurrencyCode) {
      this.sCurrencyCode = sCurrencyCode;
   }

   public String getStatusFlag() {
      return this.sStatusFlag;
   }

   public void setStatusFlag(String sStatusFlag) {
      this.sStatusFlag = sStatusFlag;
   }

   public String getLowLimit() {
      return this.sLowLimit;
   }

   public void setLowLimit(String sLowLimit) {
      this.sLowLimit = sLowLimit;
   }

   public String getHighLimit() {
      return this.sHighLimit;
   }

   public void setHighLimit(String sHighLimit) {
      this.sHighLimit = sHighLimit;
   }

   public String getOperationType() {
      return this.sOperationType;
   }

   public void setOperationType(String sOperationType) {
      this.sOperationType = sOperationType;
   }

   public ArrayList getOperationTypeList() {
      return this.aOperationTypeList;
   }

   public void setOperationTypeList(ArrayList aOperationTypeList) {
      this.aOperationTypeList = aOperationTypeList;
   }

   public ArrayList getOperationTypeNameList() {
      return this.aOperationTypeNameList;
   }

   public void setOperationTypeNameList(ArrayList aOperationTypeNameList) {
      this.aOperationTypeNameList = aOperationTypeNameList;
   }
}
