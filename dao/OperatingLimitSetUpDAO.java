/* Decompiler 43ms, total 309ms, lines 430 */
package com.ibank.ibanking.businessadministration.dao;

import com.ibank.dbconnection.application.DBCPNewConnection;
import com.ibank.ibanking.businessadministration.bo.OperatingLimitSetUpBO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class OperatingLimitSetUpDAO {
   SimpleDateFormat sSimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

   public OperatingLimitSetUpBO getPermissionCheckPro(String sUserID, String sSessionID, String sCompanyID, String sBranchID, String sIPAddress, String sBranchActionPath) throws Exception {
      Connection oConn = null;
      oConn = DBCPNewConnection.getConnection();
      OperatingLimitSetUpBO oOperatingLimitSetUpBO = new OperatingLimitSetUpBO();
      CallableStatement oStmt = oConn.prepareCall("{call MyBank.DPR_MYBANK_BANK_USER_CHECK(?,?,?,?,?,?,?)}");
      oStmt.setString(1, sUserID);
      oStmt.setString(2, sSessionID);
      oStmt.setString(3, sCompanyID);
      oStmt.setString(4, sBranchID);
      oStmt.setString(5, sIPAddress);
      oStmt.setString(6, sBranchActionPath);
      oStmt.registerOutParameter(7, 4);

      try {
         oStmt.execute();
         oOperatingLimitSetUpBO.setErrorCode("" + oStmt.getInt(7));
      } catch (Exception var17) {
         var17.printStackTrace();

         try {
            oConn.rollback();
         } catch (Exception var16) {
         }
      } finally {
         if (oStmt != null) {
            oStmt.close();
         }

         DBCPNewConnection.releaseConnection(oConn);
      }

      return oOperatingLimitSetUpBO;
   }

   public OperatingLimitSetUpBO getMenuCheckPro(String sUserID, String sSessionID, String sCompanyID, String sBranchID, String sRemoteIPAddress, String sActionPath) throws Exception {
      Connection oConn = null;
      oConn = DBCPNewConnection.getConnection();
      OperatingLimitSetUpBO oOperatingLimitSetUpBO = new OperatingLimitSetUpBO();
      CallableStatement oStmt = oConn.prepareCall("{call IBANKING.dpr_ibk_main_menu_check(?,?,?,?,?,?,?,?)}");
      oStmt.setString(1, sUserID);
      oStmt.setString(2, sSessionID);
      oStmt.setString(3, sCompanyID);
      oStmt.setString(4, sBranchID);
      oStmt.setString(5, sRemoteIPAddress);
      oStmt.setString(6, sActionPath);
      oStmt.registerOutParameter(7, 4);
      oStmt.registerOutParameter(8, 12);

      try {
         oStmt.execute();
         oOperatingLimitSetUpBO.setErrorCode("" + oStmt.getInt(7));
         oOperatingLimitSetUpBO.setErrorMessage(oStmt.getString(8));
      } catch (Exception var17) {
         var17.printStackTrace();

         try {
            oConn.rollback();
         } catch (Exception var16) {
         }
      } finally {
         DBCPNewConnection.releaseConnection(oConn);
      }

      return oOperatingLimitSetUpBO;
   }

   public OperatingLimitSetUpBO getSessionCheckPro(String sUserID, String sSessionID, String sCompanyID, String sBranchID) throws Exception {
      Connection oConn = null;
      oConn = DBCPNewConnection.getConnection();
      OperatingLimitSetUpBO oOperatingLimitSetUpBO = new OperatingLimitSetUpBO();
      CallableStatement oStmt = oConn.prepareCall("{CALL MYBANK.DPR_SESSION_VERIFY(?,?,?,?,?)}");
      oStmt.setString(1, sUserID);
      oStmt.setString(2, sSessionID);
      oStmt.setString(3, sCompanyID);
      oStmt.setString(4, sBranchID);
      oStmt.registerOutParameter(5, 4);

      try {
         oStmt.execute();
         oOperatingLimitSetUpBO.setErrorCode("" + oStmt.getInt(5));
      } catch (Exception var15) {
         var15.printStackTrace();

         try {
            oConn.rollback();
         } catch (Exception var14) {
         }
      } finally {
         if (oStmt != null) {
            oStmt.close();
         }

         DBCPNewConnection.releaseConnection(oConn);
      }

      return oOperatingLimitSetUpBO;
   }

   public OperatingLimitSetUpBO getMessageInformation(String sUserID, String sSessionID) throws Exception {
      Connection oConn = null;
      Statement oStmt = null;
      ResultSet oRs = null;
      ArrayList aTmpList = new ArrayList();
      oConn = DBCPNewConnection.getConnection();
      oStmt = oConn.createStatement();
      new StringBuffer();
      OperatingLimitSetUpBO oOperatingLimitSetUpBO = new OperatingLimitSetUpBO();

      try {
         StringBuffer sql = new StringBuffer();
         sql.append("SELECT NVL(ERRMSG,' ')");
         sql.append("FROM MyBank.SY_MESSAGE ");
         sql.append("WHERE MAILID = '");
         sql.append(sUserID);
         sql.append("' AND SESSIONID = '");
         sql.append(sSessionID);
         sql.append("' ORDER BY SERNUM ");
         oRs = oStmt.executeQuery(sql.toString());

         while(oRs.next()) {
            OperatingLimitSetUpBO oLoanDisbursementListBO = new OperatingLimitSetUpBO();
            oLoanDisbursementListBO.setErrorMessage(oRs.getString(1));
            aTmpList.add(oLoanDisbursementListBO);
         }

         oOperatingLimitSetUpBO.setList(aTmpList);
      } catch (Exception var13) {
         var13.printStackTrace();
      } finally {
         if (oRs != null) {
            oRs.close();
         }

         if (oStmt != null) {
            oStmt.close();
         }

         DBCPNewConnection.releaseConnection(oConn);
      }

      return oOperatingLimitSetUpBO;
   }

   public OperatingLimitSetUpBO getMenuList(String sUserID, String sSessionID) throws Exception {
      OperatingLimitSetUpBO oOperatingLimitSetUpBO = new OperatingLimitSetUpBO();
      Connection oConn = null;
      Statement oStmt = null;
      oConn = DBCPNewConnection.getConnection();
      oStmt = oConn.createStatement();
      ArrayList aMenuList = new ArrayList();
      ArrayList aMenuNameList = new ArrayList();
      ResultSet oRs = null;
      new StringBuffer();

      try {
         StringBuffer sql = new StringBuffer();
         sql.append("SELECT NVL(URL,' '), NVL(NODENAME,' ')");
         sql.append("FROM MyBank.SY_FAVORITES ");
         sql.append("WHERE MAILID = '");
         sql.append(sUserID);
         sql.append("' AND SESSIONID = '");
         sql.append(sSessionID);
         sql.append("' ORDER BY SERNUM ");
         oRs = oStmt.executeQuery(sql.toString());

         while(oRs.next()) {
            aMenuList.add(oRs.getString(1));
            aMenuNameList.add(oRs.getString(2));
         }

         oOperatingLimitSetUpBO.setMenuList(aMenuList);
         oOperatingLimitSetUpBO.setMenuNameList(aMenuNameList);
      } catch (Exception var17) {
         var17.printStackTrace();

         try {
            oConn.rollback();
         } catch (Exception var16) {
         }
      } finally {
         if (oStmt != null) {
            oStmt.close();
         }

         if (oRs != null) {
            oRs.close();
         }

         DBCPNewConnection.releaseConnection(oConn);
      }

      return oOperatingLimitSetUpBO;
   }

   public OperatingLimitSetUpBO getOperatingLimitSetUpList() throws Exception {
      OperatingLimitSetUpBO oOperatingLimitSetUpBO = new OperatingLimitSetUpBO();
      Connection oConn = null;
      Statement oStmt = null;
      oConn = DBCPNewConnection.getConnection();
      oStmt = oConn.createStatement();
      ArrayList aLimitTypeList = new ArrayList();
      ArrayList aLimitTypeNameList = new ArrayList();
      ArrayList aStatusList = new ArrayList();
      ArrayList aStatusNameList = new ArrayList();
      ArrayList aOperationTypeList = new ArrayList();
      ArrayList aOperationTypeNameList = new ArrayList();
      ArrayList aSubTypeList = new ArrayList();
      ArrayList aSubTypeNameList = new ArrayList();
      
      ResultSet oRs = null;
      new StringBuffer();

      try {
         StringBuffer sql = new StringBuffer();
         sql.append("SELECT NVL(ACTYPE,' '), NVL(ACDESC,' ') FROM IBANKING.LK_PARAMETER WHERE ACTCOD='LIMIT_UNIT'");
         oRs = oStmt.executeQuery(sql.toString());

         while(oRs.next()) {
            aLimitTypeList.add(oRs.getString(1));
            aLimitTypeNameList.add(oRs.getString(2));
         }

         oOperatingLimitSetUpBO.setLimitTypeList(aLimitTypeList);
         oOperatingLimitSetUpBO.setLimitTypeNameList(aLimitTypeNameList);
         
         
         sql = new StringBuffer();
         sql.append("SELECT NVL(ACTYPE,' '), NVL(ACDESC,' ') FROM IBANKING.LK_PARAMETER WHERE ACTCOD='STATUS'");
         oRs = oStmt.executeQuery(sql.toString());

         while(oRs.next()) {
            aStatusList.add(oRs.getString(1));
            aStatusNameList.add(oRs.getString(2));
         }

         oOperatingLimitSetUpBO.setStatusList(aStatusList);
         oOperatingLimitSetUpBO.setStatusNameList(aStatusNameList);
         
         
         sql = new StringBuffer();
         sql.append("SELECT NVL(ACTYPE,' '), NVL(ACDESC,' ') FROM IBANKING.LK_PARAMETER WHERE ACTCOD='OPR_SUB_TYPE'");
         oRs = oStmt.executeQuery(sql.toString());

         while(oRs.next()) {
        	 aSubTypeList.add(oRs.getString(1));
        	 aSubTypeNameList.add(oRs.getString(2));
         }

         oOperatingLimitSetUpBO.setSubTypeList(aSubTypeList);
         oOperatingLimitSetUpBO.setSubTypeNameList(aSubTypeNameList);
         sql = new StringBuffer();
         sql.append("SELECT NVL(ACTYPE,' '), NVL(ACDESC,' ') FROM IBANKING.LK_PARAMETER WHERE ACTCOD='USER_LIMIT_SETUP'");
         oRs = oStmt.executeQuery(sql.toString());

         while(oRs.next()) {
            aOperationTypeList.add(oRs.getString(1));
            aOperationTypeNameList.add(oRs.getString(2));
         }

         oOperatingLimitSetUpBO.setOperationTypeList(aOperationTypeList);
         oOperatingLimitSetUpBO.setOperationTypeNameList(aOperationTypeNameList);
      } catch (Exception var19) {
         var19.printStackTrace();

         try {
            oConn.rollback();
         } catch (Exception var18) {
         }
      } finally {
         if (oStmt != null) {
            oStmt.close();
         }

         if (oRs != null) {
            oRs.close();
         }

         DBCPNewConnection.releaseConnection(oConn);
      }

      return oOperatingLimitSetUpBO;
   }

   public OperatingLimitSetUpBO getOperatingLimitSetUpInfoPro(String sUserID, String sSessionID, String sCompanyID, String sOperationMode, String sOperationType) throws Exception {
      Connection oConn = null;
      oConn = DBCPNewConnection.getConnection();
      OperatingLimitSetUpBO oOperatingLimitSetUpBO = new OperatingLimitSetUpBO();
      CallableStatement oStmt = oConn.prepareCall("{call IBANKING.DPR_BP_GLB_LIMIT_INF(?,?,?,?,?,?,?)}");
      oStmt.setString(1, sUserID);
      oStmt.setString(2, sSessionID);
      oStmt.setString(3, sCompanyID);
      oStmt.setString(4, sOperationMode);
      oStmt.setString(5, sOperationType);
      oStmt.registerOutParameter(6, 4);
      oStmt.registerOutParameter(7, 12);

      try {
         oStmt.execute();
         oOperatingLimitSetUpBO.setErrorCode("" + oStmt.getInt(6));
         oOperatingLimitSetUpBO.setErrorMessage(oStmt.getString(7));
      } catch (Exception var16) {
         var16.printStackTrace();

         try {
            oConn.rollback();
         } catch (Exception var15) {
         }
      } finally {
         if (oStmt != null) {
            oStmt.close();
         }

         DBCPNewConnection.releaseConnection(oConn);
      }

      return oOperatingLimitSetUpBO;
   }

   public OperatingLimitSetUpBO getOperatingLimitSetUpInfoData(String sUserID, String sSessionID) throws Exception {
      Connection oConn = null;
      Statement oStmt = null;
      ResultSet oRs = null;
      ArrayList aTmpList = new ArrayList();
      oConn = DBCPNewConnection.getConnection();
      oStmt = oConn.createStatement();
      new StringBuffer();
      OperatingLimitSetUpBO oOperatingLimitSetUpBO = new OperatingLimitSetUpBO();

      try {
         StringBuffer sql = new StringBuffer();
         sql.append("SELECT SERNUM,");
         sql.append("NVL(REQTYPE,' ') SANID,");
         sql.append("NVL(REQNO,' ') SANDATE,");
         sql.append("NVL(SRCBRANCHROUTINGNO,' ') CURCDE,");
         sql.append("NVL(SRCACCARDNO,' ') LIMTTYPE,");
         sql.append("NVL(SRCACCARDTITLE,' ') TRNFREQ,");
         sql.append("NVL(REQDATE,'') LOW_LIMIT,");
         sql.append("NVL(DESTBRANCHROUTINGNO,'') HIGH_LIMIT,");
         sql.append("NVL(TRNAMT,'') DAILYTRANLIMIT, ");
         sql.append("NVL(DESTACCNO,' ') FROMDATE,");
         sql.append("NVL(DESTACCOUNTTITLE,' ') DATETO,");
         sql.append("NVL(CURCDE,' ') REMARKS,");
         sql.append("NVL(AMOUNT,' ') ACTFLG,");
         sql.append("NVL(DESTBANKCD,' ') SUBTYPE,");
         sql.append("NVL(TRANFLG,' ') STATUS  ");
         sql.append("FROM IBANKING.DT_IBTRANREQ  ");
         sql.append("WHERE MAILID = '");
         sql.append(sUserID);
         sql.append("' AND SESSIONID = '");
         sql.append(sSessionID);
         sql.append("' ORDER BY SERNUM ");
         oRs = oStmt.executeQuery(sql.toString());

         while(oRs.next()) {
            OperatingLimitSetUpBO oOperatingLimitSetUpLimitListBO = new OperatingLimitSetUpBO();
            oOperatingLimitSetUpLimitListBO.setSerialNo(oRs.getString(1));
            oOperatingLimitSetUpLimitListBO.setSanctionID(oRs.getString(2));
            oOperatingLimitSetUpLimitListBO.setSanctionDate(oRs.getString(3));
            oOperatingLimitSetUpLimitListBO.setCurrencyCode(oRs.getString(4));
            oOperatingLimitSetUpLimitListBO.setLimitType(oRs.getString(5));
            oOperatingLimitSetUpLimitListBO.setTransactionFrequency(oRs.getString(6));
            oOperatingLimitSetUpLimitListBO.setLowLimit(oRs.getString(7));
            oOperatingLimitSetUpLimitListBO.setHighLimit(oRs.getString(8));
            oOperatingLimitSetUpLimitListBO.setDailyTranLimit(oRs.getString(9));
            oOperatingLimitSetUpLimitListBO.setFromDate(oRs.getString(10));
            oOperatingLimitSetUpLimitListBO.setToDate(oRs.getString(11));
            oOperatingLimitSetUpLimitListBO.setRemarks(oRs.getString(12));
            oOperatingLimitSetUpLimitListBO.setStatusFlag(oRs.getString(13));
            oOperatingLimitSetUpLimitListBO.setSubType(oRs.getString(14));
            oOperatingLimitSetUpLimitListBO.setStatus(oRs.getString(15));
            aTmpList.add(oOperatingLimitSetUpLimitListBO);
         }

         oOperatingLimitSetUpBO.setUserLimitList(aTmpList);
      } catch (Exception var13) {
         var13.printStackTrace();
      } finally {
         if (oRs != null) {
            oRs.close();
         }

         if (oStmt != null) {
            oStmt.close();
         }

         DBCPNewConnection.releaseConnection(oConn);
      }

      return oOperatingLimitSetUpBO;
   }

   public OperatingLimitSetUpBO getExecutePro(String sTerminalID, 
		   String sIMENo,
		   String sMailID, 
		   String sSessionID,
		   String sCompanyID,
		   String sOperationMode,
		   String sOperationType, 
		   String sSanctionID, 
		   String sLimitType, 
		   String sTransactionFrequency,
		   String sLowLimit, 
		   String sHighLimit,
		   String sDailyTranLimit,
		   String sFromDate,
		   String sToDate,
		   String sStatus,
		   String sSubType,
		   String sRemarks) throws Exception {
      Connection oConn = null;
      oConn = DBCPNewConnection.getConnection();
      OperatingLimitSetUpBO oOperatingLimitSetUpBO = new OperatingLimitSetUpBO();
      CallableStatement oStmt = oConn.prepareCall("{call IBANKING.DPR_BP_GLB_LIMIT_EXE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
      oStmt.setString(1, sTerminalID);
      oStmt.setString(2, sIMENo);
      oStmt.setString(3, sMailID);
      oStmt.setString(4, sSessionID);
      oStmt.setString(5, sCompanyID);
      oStmt.setString(6, sOperationMode);
      oStmt.setString(7, sOperationType);
      oStmt.setString(8, sSanctionID);
      oStmt.setString(9, sLimitType);
      oStmt.setString(10, sTransactionFrequency);
      oStmt.setString(11, sLowLimit);
      oStmt.setString(12, sHighLimit);
      oStmt.setString(13, sDailyTranLimit);
      oStmt.setString(14, sFromDate);
      oStmt.setString(15, sToDate);
      oStmt.setString(16, sStatus);
      oStmt.setString(17, sSubType);
      oStmt.setString(18, sRemarks);
      oStmt.registerOutParameter(19, java.sql.Types.INTEGER);
	  oStmt.registerOutParameter(20, java.sql.Types.VARCHAR);

      try {
         oStmt.execute();
         oOperatingLimitSetUpBO.setErrorCode("" + oStmt.getInt(19));
         oOperatingLimitSetUpBO.setErrorMessage(oStmt.getString(20));
      } catch (Exception var27) {
         var27.printStackTrace();

         try {
            oConn.rollback();
         } catch (Exception var26) {
         }
      } finally {
         if (oStmt != null) {
            oStmt.close();
         }

         DBCPNewConnection.releaseConnection(oConn);
      }

      return oOperatingLimitSetUpBO;
   }
}
