package com.ibank.ibanking.businessadministration.bo;
import java.io.Serializable;
import java.util.ArrayList;

public class IndividualOperatingLimitSetUpBO implements Serializable {
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
   private String sUserId = "";
   
   
   public String getUserId() {
		return sUserId;
	}

	public void setUserId(String userId) {
		this.sUserId = userId;
	}
	   
	   
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

	   public void setUserID(String userId) {
	      this.sUserID = userId;
	   }

	   public String getLimitType() {
	      return this.sLimitType;
	   }

	   public void setLimitType(String limitType) {
	      this.sLimitType = limitType;
	   }

	   public ArrayList getLimitTypeList() {
	      return this.aLimitTypeList;
	   }

	   public void setLimitTypeList(ArrayList limitTypeList) {
	      this.aLimitTypeList = limitTypeList;
	   }

	   public ArrayList getLimitTypeNameList() {
	      return this.aLimitTypeNameList;
	   }

	   public void setLimitTypeNameList(ArrayList limitTypeNameList) {
	      this.aLimitTypeNameList = limitTypeNameList;
	   }

	   public String getTransactionFrequency() {
	      return this.sTransactionFrequency;
	   }

	   public void setTransactionFrequency(String transactionFrequency) {
	      this.sTransactionFrequency = transactionFrequency;
	   }

	   public String getFromDate() {
	      return this.sFromDate;
	   }

	   public void setFromDate(String fromDate) {
	      this.sFromDate = fromDate;
	   }

	   public String getToDate() {
	      return this.sToDate;
	   }

	   public void setToDate(String toDate) {
	      this.sToDate = toDate;
	   }

	   public String getStatus() {
	      return this.sStatus;
	   }

	   public void setStatus(String status) {
	      this.sStatus = status;
	   }

	   public ArrayList getStatusList() {
	      return this.aStatusList;
	   }

	   public void setStatusList(ArrayList statusList) {
	      this.aStatusList = statusList;
	   }

	   public ArrayList getStatusNameList() {
	      return this.aStatusNameList;
	   }

	   public void setStatusNameList(ArrayList statusNameList) {
	      this.aStatusNameList = statusNameList;
	   }

	   public String getRemarks() {
	      return this.sRemarks;
	   }

	   public void setRemarks(String remarks) {
	      this.sRemarks = remarks;
	   }

	   public ArrayList getUserLimitList() {
	      return this.aUserLimitList;
	   }

	   public void setUserLimitList(ArrayList userLimitList) {
	      this.aUserLimitList = userLimitList;
	   }

	   public String getSerialNo() {
	      return this.sSerialNo;
	   }

	   public void setSerialNo(String serialNo) {
	      this.sSerialNo = serialNo;
	   }

	   public String getErrorCode() {
	      return this.sErrorCode;
	   }

	   public void setErrorCode(String errorCode) {
	      this.sErrorCode = errorCode;
	   }

	   public String getErrorMessage() {
	      return this.sErrorMessage;
	   }

	   public void setErrorMessage(String errorMessage) {
	      this.sErrorMessage = errorMessage;
	   }

	   public ArrayList getList() {
	      return this.aList;
	   }

	   public void setList(ArrayList list) {
	      this.aList = list;
	   }

	   public String getMenu() {
	      return this.sMenu;
	   }

	   public void setMenu(String menu) {
	      this.sMenu = menu;
	   }

	   public ArrayList getMenuList() {
	      return this.aMenuList;
	   }

	   public void setMenuList(ArrayList menuList) {
	      this.aMenuList = menuList;
	   }

	   public ArrayList getMenuNameList() {
	      return this.aMenuNameList;
	   }

	   public void setMenuNameList(ArrayList menuNameList) {
	      this.aMenuNameList = menuNameList;
	   }

	   public String getSanctionID() {
	      return this.sSanctionID;
	   }

	   public void setSanctionID(String sanctionID) {
	      this.sSanctionID = sanctionID;
	   }

	   public String getOperationMode() {
	      return this.sOperationMode;
	   }

	   public void setOperationMode(String operationMode) {
	      this.sOperationMode = operationMode;
	   }

	   public String getSanctionDate() {
	      return this.sSanctionDate;
	   }

	   public void setSanctionDate(String sanctionDate) {
	      this.sSanctionDate = sanctionDate;
	   }

	   public String getCurrencyCode() {
	      return this.sCurrencyCode;
	   }

	   public void setCurrencyCode(String currencyCode) {
	      this.sCurrencyCode = currencyCode;
	   }

	   public String getStatusFlag() {
	      return this.sStatusFlag;
	   }

	   public void setStatusFlag(String statusFlag) {
	      this.sStatusFlag = statusFlag;
	   }

	   public String getLowLimit() {
	      return this.sLowLimit;
	   }

	   public void setLowLimit(String lowLimit) {
	      this.sLowLimit = lowLimit;
	   }

	   public String getHighLimit() {
	      return this.sHighLimit;
	   }

	   public void setHighLimit(String highLimit) {
	      this.sHighLimit = highLimit;
	   }

	   public String getOperationType() {
	      return this.sOperationType;
	   }

	   public void setOperationType(String operationType) {
	      this.sOperationType = operationType;
	   }

	   public ArrayList getOperationTypeList() {
	      return this.aOperationTypeList;
	   }

	   public void setOperationTypeList(ArrayList operationTypeList) {
	      this.aOperationTypeList = operationTypeList;
	   }

	   public ArrayList getOperationTypeNameList() {
	      return this.aOperationTypeNameList;
	   }

	   public void setOperationTypeNameList(ArrayList operationTypeNameList) {
	      this.aOperationTypeNameList = operationTypeNameList;
	   }
}

