package com.ibank.ibanking.businessadministration.action;
import com.ibank.ibanking.businessadministration.bo.IndividualOperatingLimitSetUpBO;
import com.ibank.ibanking.businessadministration.dao.IndividualOperatingLimitSetUpDAO;
import com.ibank.ibanking.businessadministration.formbean.IndividualOperatingLimitSetUpForm;
import com.ibank.utility.RemoveNullValue;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class IndividualOperatingLimitSetUpAction extends Action {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
      new IndividualOperatingLimitSetUpBO();
      IndividualOperatingLimitSetUpDAO oIndividualOperatingLimitSetUpDAO = new IndividualOperatingLimitSetUpDAO();
      IndividualOperatingLimitSetUpForm oIndividualOperatingLimitSetUpForm = (IndividualOperatingLimitSetUpForm)form;
      new IndividualOperatingLimitSetUpBO();
      RemoveNullValue oRemoveNullValue = new RemoveNullValue();
      oRemoveNullValue.removeNullValue(oIndividualOperatingLimitSetUpForm);
      String sActionPath = "";
      sActionPath = mapping.getPath();
      HttpSession session = request.getSession(true);
      String sSuccessAction = "success";
      String sFailureAction = "failure";
      String sFatalErrorAction = "fatalError";
      String sSessionExpireAction = "sessionExpire";
      String sSessionMyBankMenuAction = "sessionMyBankMenu";
      String sSuccess = sFatalErrorAction;
      String sActionPathName = "";
      String gsUserID = (String)session.getAttribute("GSUserID");
      String gsUserTitle = (String)session.getAttribute("GSUserTitle");
      String gsLastLogInDate = (String)session.getAttribute("GSLastLogInDate");
      String gsLogInUserID = (String)session.getAttribute("GSLogInUserID");
      String gsSessionID = (String)session.getAttribute("GSSessionID");
      String gsInternalCardID = (String)session.getAttribute("GSInternalCardID");
      String gsHeaderName = (String)session.getAttribute("GSHeaderName");
      String gsHeaderLogIn = (String)session.getAttribute("GSHeaderLogIn");
      String gsCompanyID = (String)session.getAttribute("GSCompanyCode");
      String gsBranchID = (String)session.getAttribute("GSBranchCode");
      String gsBranchName = (String)session.getAttribute("GSBranchName");
      String gsTellerID = (String)session.getAttribute("GSTellerID");
      String gsCompanyName = (String)session.getAttribute("GSCompanyName");
      String gsBranchOpenDateDDFormat = (String)session.getAttribute("GSBranchOpenDateDDFormat");
      new SimpleDateFormat("dd/MM/yyyy");
      String OperatingLimitSetUpMessageBO="";  
      String sBranchActionPathName = "/ibanking/individualOperatingLimitSetUp.do";
      IndividualOperatingLimitSetUpBO oIndividualOperatingLimitSetUpBO;
      if (sActionPath.equals("/individualOperatingLimitSetUp")) {
			session.setAttribute("oOperatingLimitSetUpMessageBO"," ");
			clearForm(oIndividualOperatingLimitSetUpForm);
			clearSession(session);
			oIndividualOperatingLimitSetUpBO = oIndividualOperatingLimitSetUpDAO.getOperatingLimitSetUpList();
	        this.populateOperatingLimitSetUpListData(oIndividualOperatingLimitSetUpForm, oIndividualOperatingLimitSetUpBO);
	        oIndividualOperatingLimitSetUpForm.setFromDate(gsBranchOpenDateDDFormat);
	        oIndividualOperatingLimitSetUpForm.setStatus("Y");	       
			sSuccess = sSuccessAction;
		}
      else if (sActionPath.equals("/indShowDataOperatingLimitSetUp")) {
			session.setAttribute("oOperatingLimitSetUpMessageBO"," ");
			session.setAttribute("oIndividualOperatingLimitSetUpBO", " ");
			 oIndividualOperatingLimitSetUpBO = oIndividualOperatingLimitSetUpDAO.getOperatingLimitSetUpInfoPro(gsUserID, gsSessionID, gsCompanyID, "S", oIndividualOperatingLimitSetUpForm.getOperationType());

			 if (oIndividualOperatingLimitSetUpBO.getErrorCode().equals("0")) {
	               oIndividualOperatingLimitSetUpBO = oIndividualOperatingLimitSetUpDAO.getOperatingLimitSetUpInfoData(gsUserID, gsSessionID);
	               session.setAttribute("oIndividualOperatingLimitSetUpBO", oIndividualOperatingLimitSetUpBO);
	               sSuccess = sSuccessAction;
	            } else if (oIndividualOperatingLimitSetUpBO.getErrorCode().equals("1")) {
	               OperatingLimitSetUpMessageBO = oIndividualOperatingLimitSetUpBO.getErrorMessage();
	               session.setAttribute("oOperatingLimitSetUpMessageBO", OperatingLimitSetUpMessageBO);
	               sSuccess = sFailureAction;
	            } else if (oIndividualOperatingLimitSetUpBO.getErrorCode().equals("2")) {
	               this.clearSession(session);
	               sSuccess = sSessionExpireAction;
	            } else if (oIndividualOperatingLimitSetUpBO.getErrorCode().equals("3")) {
	               this.clearSession(session);
	               sSuccess = sSessionMyBankMenuAction;
	            } else {
	               this.clearSession(session);
	               sSuccess = sFatalErrorAction;
	            }
      }
          else if (sActionPath.equals("/indExecuteOperatingLimitSetUp")) {
            session.setAttribute("oOperatingLimitSetUpMessageBO", " ");
            session.setAttribute("oIndividualOperatingLimitSetUpBO", " ");
            oIndividualOperatingLimitSetUpBO = oIndividualOperatingLimitSetUpDAO.getExecutePro("WEBADMIN",
            		request.getRemoteAddr(),
            		gsUserID, gsSessionID,
            		oIndividualOperatingLimitSetUpForm.getUserId(),
            		gsCompanyID,
            		oIndividualOperatingLimitSetUpForm.getOperationMode(),
            		oIndividualOperatingLimitSetUpForm.getOperationType(),
            		oIndividualOperatingLimitSetUpForm.getSanctionID(),
            		oIndividualOperatingLimitSetUpForm.getLimitType(),
            		oIndividualOperatingLimitSetUpForm.getTransactionFrequency(),
            		oIndividualOperatingLimitSetUpForm.getLowLimit(), 
            		oIndividualOperatingLimitSetUpForm.getHighLimit(),
            		oIndividualOperatingLimitSetUpForm.getDailyTranLimit(),
            		oIndividualOperatingLimitSetUpForm.getStatus(),
            		oIndividualOperatingLimitSetUpForm.getSubType(),
            		oIndividualOperatingLimitSetUpForm.getRemarks());
            if (oIndividualOperatingLimitSetUpBO.getErrorCode().equals("0")) {
               OperatingLimitSetUpMessageBO = oIndividualOperatingLimitSetUpBO.getErrorMessage();
               session.setAttribute("oOperatingLimitSetUpMessageBO", OperatingLimitSetUpMessageBO);
               session.setAttribute("oIndividualOperatingLimitSetUpBO", oIndividualOperatingLimitSetUpBO);
               oIndividualOperatingLimitSetUpBO = oIndividualOperatingLimitSetUpDAO.getOperatingLimitSetUpInfoPro(gsUserID, gsSessionID, gsCompanyID, "S", oIndividualOperatingLimitSetUpForm.getOperationType());    
               if (oIndividualOperatingLimitSetUpBO.getErrorCode().equals("0")) {                  
                  oIndividualOperatingLimitSetUpBO = oIndividualOperatingLimitSetUpDAO.getOperatingLimitSetUpInfoData(gsUserID, gsSessionID);
                  session.setAttribute("oIndividualOperatingLimitSetUpBO", oIndividualOperatingLimitSetUpBO);               
                  oIndividualOperatingLimitSetUpForm.setEditFlag("");
                  session.setAttribute("oOperatingLimitSetUpMessageBO", OperatingLimitSetUpMessageBO);
                  sSuccess = sSuccessAction;
               } else if (oIndividualOperatingLimitSetUpBO.getErrorCode().equals("1")) {
            	   String OperatingLimitSetUpMessageBO2="";
                  OperatingLimitSetUpMessageBO2 = oIndividualOperatingLimitSetUpBO.getErrorMessage();
                  session.setAttribute("oOperatingLimitSetUpMessageBO", OperatingLimitSetUpMessageBO2);
                  sSuccess = sFailureAction;
               } else if (oIndividualOperatingLimitSetUpBO.getErrorCode().equals("2")) {
                  this.clearSession(session);
                  sSuccess = sSessionExpireAction;
               } else if (oIndividualOperatingLimitSetUpBO.getErrorCode().equals("3")) {
                  this.clearSession(session);
                  sSuccess = sSessionMyBankMenuAction;
               } else {
                  this.clearSession(session);
                  sSuccess = sFatalErrorAction;
               }
            } else if (oIndividualOperatingLimitSetUpBO.getErrorCode().equals("1")) {
               OperatingLimitSetUpMessageBO = oIndividualOperatingLimitSetUpBO.getErrorMessage();
               session.setAttribute("oOperatingLimitSetUpMessageBO", OperatingLimitSetUpMessageBO);
               sSuccess = sFailureAction;
            } else if (oIndividualOperatingLimitSetUpBO.getErrorCode().equals("2")) {
               this.clearSession(session);
               sSuccess = sSessionExpireAction;
            } else if (oIndividualOperatingLimitSetUpBO.getErrorCode().equals("3")) {
               this.clearSession(session);
               sSuccess = sSessionMyBankMenuAction;
            } else {
               this.clearSession(session);
               sSuccess = sFatalErrorAction;
            }
         } else if (sActionPath.equals("/indCancelOperatingLimitSetUp")) {
            session.setAttribute("oOperatingLimitSetUpMessageBO", (Object)null);
            oIndividualOperatingLimitSetUpBO = oIndividualOperatingLimitSetUpDAO.getMenuCheckPro(gsUserID, gsSessionID, gsCompanyID, gsBranchID, request.getRemoteAddr(), sBranchActionPathName);
            if (oIndividualOperatingLimitSetUpBO.getErrorCode().equals("0")) {
               this.clearSession(session);
               OperatingLimitSetUpMessageBO = oIndividualOperatingLimitSetUpBO.getErrorMessage();
               session.setAttribute("oOperatingLimitSetUpMessageBO", OperatingLimitSetUpMessageBO);
               sSuccess = sSuccessAction;
            } else if (oIndividualOperatingLimitSetUpBO.getErrorCode().equals("1")) {
               OperatingLimitSetUpMessageBO = oIndividualOperatingLimitSetUpBO.getErrorMessage();
               session.setAttribute("oOperatingLimitSetUpMessageBO", OperatingLimitSetUpMessageBO);
               sSuccess = sFailureAction;
            } else if (oIndividualOperatingLimitSetUpBO.getErrorCode().equals("2")) {
               this.clearSession(session);
               sSuccess = sSessionExpireAction;
            } else if (oIndividualOperatingLimitSetUpBO.getErrorCode().equals("3")) {
               this.clearSession(session);
               sSuccess = sSessionMyBankMenuAction;
            } else {
               this.clearSession(session);
               sSuccess = sFatalErrorAction;
            }
         }
      

      return mapping.findForward(sSuccess);
   }

   private void populateOperatingLimitSetUpListData(IndividualOperatingLimitSetUpForm oIndividualOperatingLimitSetUpForm, IndividualOperatingLimitSetUpBO oIndividualOperatingLimitSetUpBO) {
      oIndividualOperatingLimitSetUpForm.setLimitTypeList(oIndividualOperatingLimitSetUpBO.getLimitTypeList());
      oIndividualOperatingLimitSetUpForm.setLimitTypeNameList(oIndividualOperatingLimitSetUpBO.getLimitTypeNameList());
      oIndividualOperatingLimitSetUpForm.setStatusList(oIndividualOperatingLimitSetUpBO.getStatusList());
      oIndividualOperatingLimitSetUpForm.setStatusNameList(oIndividualOperatingLimitSetUpBO.getStatusNameList());
      oIndividualOperatingLimitSetUpForm.setOperationTypeList(oIndividualOperatingLimitSetUpBO.getOperationTypeList());
      oIndividualOperatingLimitSetUpForm.setOperationTypeNameList(oIndividualOperatingLimitSetUpBO.getOperationTypeNameList());
      oIndividualOperatingLimitSetUpForm.setSubTypeList(oIndividualOperatingLimitSetUpBO.getSubTypeList());
      oIndividualOperatingLimitSetUpForm.setSubTypeNameList(oIndividualOperatingLimitSetUpBO.getSubTypeNameList());
      
   }

   public void populateMenu(IndividualOperatingLimitSetUpForm oIndividualOperatingLimitSetUpForm, IndividualOperatingLimitSetUpBO oIndividualOperatingLimitSetUpBO) {
      oIndividualOperatingLimitSetUpForm.setMenuList(oIndividualOperatingLimitSetUpBO.getMenuList());
      oIndividualOperatingLimitSetUpForm.setMenuNameList(oIndividualOperatingLimitSetUpBO.getMenuNameList());
   }

   public void populateMessage(IndividualOperatingLimitSetUpForm oIndividualOperatingLimitSetUpForm, IndividualOperatingLimitSetUpBO oIndividualOperatingLimitSetUpBO) {
      oIndividualOperatingLimitSetUpForm.setList(oIndividualOperatingLimitSetUpBO.getList());
   }

   private void clearForm(IndividualOperatingLimitSetUpForm oIndividualOperatingLimitSetUpForm) {
      oIndividualOperatingLimitSetUpForm.setUserID("");
      oIndividualOperatingLimitSetUpForm.setUserId("");
      oIndividualOperatingLimitSetUpForm.setSanctionID("");
      oIndividualOperatingLimitSetUpForm.setSanctionDate("");
      oIndividualOperatingLimitSetUpForm.setCurrencyCode("");
      oIndividualOperatingLimitSetUpForm.setLimitType("");
      oIndividualOperatingLimitSetUpForm.setTransactionFrequency("");
      oIndividualOperatingLimitSetUpForm.setLowLimit("");
      oIndividualOperatingLimitSetUpForm.setHighLimit("");
      oIndividualOperatingLimitSetUpForm.setDailyTranLimit("");
      oIndividualOperatingLimitSetUpForm.setFromDate("");
      oIndividualOperatingLimitSetUpForm.setToDate("");
      oIndividualOperatingLimitSetUpForm.setStatusFlag("");
      oIndividualOperatingLimitSetUpForm.setStatus("");
      oIndividualOperatingLimitSetUpForm.setSubType("");
      oIndividualOperatingLimitSetUpForm.setRemarks("");
      oIndividualOperatingLimitSetUpForm.setOperationMode("");
      oIndividualOperatingLimitSetUpForm.setOperationType("");
      oIndividualOperatingLimitSetUpForm.setSerialNo("");
      oIndividualOperatingLimitSetUpForm.setErrorCode("");
      oIndividualOperatingLimitSetUpForm.setErrorMessage("");
      oIndividualOperatingLimitSetUpForm.setMenu("");
      oIndividualOperatingLimitSetUpForm.setEditFlag("");
   }

   private void clearSession(HttpSession session) {
      session.setAttribute("oIndividualOperatingLimitSetUpBO", " ");
      session.setAttribute("oOperatingLimitSetUpMessageBO", " ");
   }
}

