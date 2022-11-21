/* Decompiler 91ms, total 358ms, lines 207 */
package com.ibank.ibanking.businessadministration.action;
import com.ibank.ibanking.businessadministration.bo.OperatingLimitSetUpBO;
import com.ibank.ibanking.businessadministration.dao.OperatingLimitSetUpDAO;
import com.ibank.ibanking.businessadministration.formbean.OperatingLimitSetUpForm;
import com.ibank.utility.RemoveNullValue;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class OperatingLimitSetUpAction extends Action {
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
      new OperatingLimitSetUpBO();
      OperatingLimitSetUpDAO oOperatingLimitSetUpDAO = new OperatingLimitSetUpDAO();
      OperatingLimitSetUpForm oOperatingLimitSetUpForm = (OperatingLimitSetUpForm)form;
      new OperatingLimitSetUpBO();
      RemoveNullValue oRemoveNullValue = new RemoveNullValue();
      oRemoveNullValue.removeNullValue(oOperatingLimitSetUpForm);
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
      String sBranchActionPathName = "/ibanking/operatingLimitSetUp.do";
      OperatingLimitSetUpBO oOperatingLimitSetUpBO;
      if (sActionPath.equals("/operatingLimitSetUp")) {
			session.setAttribute("oOperatingLimitSetUpMessageBO"," ");
			clearForm(oOperatingLimitSetUpForm);
			clearSession(session);
			oOperatingLimitSetUpBO = oOperatingLimitSetUpDAO.getOperatingLimitSetUpList();
	        this.populateOperatingLimitSetUpListData(oOperatingLimitSetUpForm, oOperatingLimitSetUpBO);
	        oOperatingLimitSetUpForm.setFromDate(gsBranchOpenDateDDFormat);
	        oOperatingLimitSetUpForm.setStatus("Y");	       
			sSuccess = sSuccessAction;
		}
      else if (sActionPath.equals("/showDataOperatingLimitSetUp")) {
			session.setAttribute("oOperatingLimitSetUpMessageBO"," ");
			session.setAttribute("oOperatingLimitSetUpBO", " ");
			 oOperatingLimitSetUpBO = oOperatingLimitSetUpDAO.getOperatingLimitSetUpInfoPro(gsUserID, gsSessionID, gsCompanyID, "S", oOperatingLimitSetUpForm.getOperationType());

			 if (oOperatingLimitSetUpBO.getErrorCode().equals("0")) {
	               oOperatingLimitSetUpBO = oOperatingLimitSetUpDAO.getOperatingLimitSetUpInfoData(gsUserID, gsSessionID);
	               session.setAttribute("oOperatingLimitSetUpBO", oOperatingLimitSetUpBO);
	               sSuccess = sSuccessAction;
	            } else if (oOperatingLimitSetUpBO.getErrorCode().equals("1")) {
	               OperatingLimitSetUpMessageBO = oOperatingLimitSetUpBO.getErrorMessage();
	               session.setAttribute("oOperatingLimitSetUpMessageBO", OperatingLimitSetUpMessageBO);
	               sSuccess = sFailureAction;
	            } else if (oOperatingLimitSetUpBO.getErrorCode().equals("2")) {
	               this.clearSession(session);
	               sSuccess = sSessionExpireAction;
	            } else if (oOperatingLimitSetUpBO.getErrorCode().equals("3")) {
	               this.clearSession(session);
	               sSuccess = sSessionMyBankMenuAction;
	            } else {
	               this.clearSession(session);
	               sSuccess = sFatalErrorAction;
	            }
      }
          else if (sActionPath.equals("/executeOperatingLimitSetUp")) {
            session.setAttribute("oOperatingLimitSetUpMessageBO", " ");
            session.setAttribute("oOperatingLimitSetUpBO", " ");
            oOperatingLimitSetUpBO = oOperatingLimitSetUpDAO.getExecutePro("WEBADMIN",
            		request.getRemoteAddr(),
            		gsUserID, gsSessionID, 
            		gsCompanyID,
            		oOperatingLimitSetUpForm.getOperationMode(),
            		oOperatingLimitSetUpForm.getOperationType(),
            		oOperatingLimitSetUpForm.getSanctionID(),
            		oOperatingLimitSetUpForm.getLimitType(),
            		oOperatingLimitSetUpForm.getTransactionFrequency(),
            		oOperatingLimitSetUpForm.getLowLimit(), 
            		oOperatingLimitSetUpForm.getHighLimit(),
            		oOperatingLimitSetUpForm.getDailyTranLimit(),
            		oOperatingLimitSetUpForm.getFromDate(),
            		oOperatingLimitSetUpForm.getToDate(),
            		oOperatingLimitSetUpForm.getStatus(),
            		oOperatingLimitSetUpForm.getSubType(),
            		oOperatingLimitSetUpForm.getRemarks());
            if (oOperatingLimitSetUpBO.getErrorCode().equals("0")) {
               OperatingLimitSetUpMessageBO = oOperatingLimitSetUpBO.getErrorMessage();
               session.setAttribute("oOperatingLimitSetUpMessageBO", OperatingLimitSetUpMessageBO);
               session.setAttribute("oOperatingLimitSetUpBO", oOperatingLimitSetUpBO);
               oOperatingLimitSetUpBO = oOperatingLimitSetUpDAO.getOperatingLimitSetUpInfoPro(gsUserID, gsSessionID, gsCompanyID, "S", oOperatingLimitSetUpForm.getOperationType());    
               if (oOperatingLimitSetUpBO.getErrorCode().equals("0")) {                  
                  oOperatingLimitSetUpBO = oOperatingLimitSetUpDAO.getOperatingLimitSetUpInfoData(gsUserID, gsSessionID);
                  session.setAttribute("oOperatingLimitSetUpBO", oOperatingLimitSetUpBO);               
                  oOperatingLimitSetUpForm.setEditFlag("");
                  session.setAttribute("oOperatingLimitSetUpMessageBO", OperatingLimitSetUpMessageBO);
                  sSuccess = sSuccessAction;
               } else if (oOperatingLimitSetUpBO.getErrorCode().equals("1")) {
            	   String OperatingLimitSetUpMessageBO2="";
                  OperatingLimitSetUpMessageBO2 = oOperatingLimitSetUpBO.getErrorMessage();
                  session.setAttribute("oOperatingLimitSetUpMessageBO", OperatingLimitSetUpMessageBO2);
                  sSuccess = sFailureAction;
               } else if (oOperatingLimitSetUpBO.getErrorCode().equals("2")) {
                  this.clearSession(session);
                  sSuccess = sSessionExpireAction;
               } else if (oOperatingLimitSetUpBO.getErrorCode().equals("3")) {
                  this.clearSession(session);
                  sSuccess = sSessionMyBankMenuAction;
               } else {
                  this.clearSession(session);
                  sSuccess = sFatalErrorAction;
               }
            } else if (oOperatingLimitSetUpBO.getErrorCode().equals("1")) {
               OperatingLimitSetUpMessageBO = oOperatingLimitSetUpBO.getErrorMessage();
               session.setAttribute("oOperatingLimitSetUpMessageBO", OperatingLimitSetUpMessageBO);
               sSuccess = sFailureAction;
            } else if (oOperatingLimitSetUpBO.getErrorCode().equals("2")) {
               this.clearSession(session);
               sSuccess = sSessionExpireAction;
            } else if (oOperatingLimitSetUpBO.getErrorCode().equals("3")) {
               this.clearSession(session);
               sSuccess = sSessionMyBankMenuAction;
            } else {
               this.clearSession(session);
               sSuccess = sFatalErrorAction;
            }
         } else if (sActionPath.equals("/cancelOperatingLimitSetUp")) {
            session.setAttribute("oOperatingLimitSetUpMessageBO", (Object)null);
            oOperatingLimitSetUpBO = oOperatingLimitSetUpDAO.getMenuCheckPro(gsUserID, gsSessionID, gsCompanyID, gsBranchID, request.getRemoteAddr(), sBranchActionPathName);
            if (oOperatingLimitSetUpBO.getErrorCode().equals("0")) {
               this.clearSession(session);
               OperatingLimitSetUpMessageBO = oOperatingLimitSetUpBO.getErrorMessage();
               session.setAttribute("oOperatingLimitSetUpMessageBO", OperatingLimitSetUpMessageBO);
               sSuccess = sSuccessAction;
            } else if (oOperatingLimitSetUpBO.getErrorCode().equals("1")) {
               OperatingLimitSetUpMessageBO = oOperatingLimitSetUpBO.getErrorMessage();
               session.setAttribute("oOperatingLimitSetUpMessageBO", OperatingLimitSetUpMessageBO);
               sSuccess = sFailureAction;
            } else if (oOperatingLimitSetUpBO.getErrorCode().equals("2")) {
               this.clearSession(session);
               sSuccess = sSessionExpireAction;
            } else if (oOperatingLimitSetUpBO.getErrorCode().equals("3")) {
               this.clearSession(session);
               sSuccess = sSessionMyBankMenuAction;
            } else {
               this.clearSession(session);
               sSuccess = sFatalErrorAction;
            }
         }
      

      return mapping.findForward(sSuccess);
   }

   private void populateOperatingLimitSetUpListData(OperatingLimitSetUpForm oOperatingLimitSetUpForm, OperatingLimitSetUpBO oOperatingLimitSetUpBO) {
      oOperatingLimitSetUpForm.setLimitTypeList(oOperatingLimitSetUpBO.getLimitTypeList());
      oOperatingLimitSetUpForm.setLimitTypeNameList(oOperatingLimitSetUpBO.getLimitTypeNameList());
      oOperatingLimitSetUpForm.setStatusList(oOperatingLimitSetUpBO.getStatusList());
      oOperatingLimitSetUpForm.setStatusNameList(oOperatingLimitSetUpBO.getStatusNameList());
      oOperatingLimitSetUpForm.setOperationTypeList(oOperatingLimitSetUpBO.getOperationTypeList());
      oOperatingLimitSetUpForm.setOperationTypeNameList(oOperatingLimitSetUpBO.getOperationTypeNameList());
      oOperatingLimitSetUpForm.setSubTypeList(oOperatingLimitSetUpBO.getSubTypeList());
      oOperatingLimitSetUpForm.setSubTypeNameList(oOperatingLimitSetUpBO.getSubTypeNameList());
      
   }

   public void populateMenu(OperatingLimitSetUpForm oOperatingLimitSetUpForm, OperatingLimitSetUpBO oOperatingLimitSetUpBO) {
      oOperatingLimitSetUpForm.setMenuList(oOperatingLimitSetUpBO.getMenuList());
      oOperatingLimitSetUpForm.setMenuNameList(oOperatingLimitSetUpBO.getMenuNameList());
   }

   public void populateMessage(OperatingLimitSetUpForm oOperatingLimitSetUpForm, OperatingLimitSetUpBO oOperatingLimitSetUpBO) {
      oOperatingLimitSetUpForm.setList(oOperatingLimitSetUpBO.getList());
   }

   private void clearForm(OperatingLimitSetUpForm oOperatingLimitSetUpForm) {
      oOperatingLimitSetUpForm.setUserID("");
      oOperatingLimitSetUpForm.setSanctionID("");
      oOperatingLimitSetUpForm.setSanctionDate("");
      oOperatingLimitSetUpForm.setCurrencyCode("");
      oOperatingLimitSetUpForm.setLimitType("");
      oOperatingLimitSetUpForm.setTransactionFrequency("");
      oOperatingLimitSetUpForm.setLowLimit("");
      oOperatingLimitSetUpForm.setHighLimit("");
      oOperatingLimitSetUpForm.setDailyTranLimit("");
      oOperatingLimitSetUpForm.setFromDate("");
      oOperatingLimitSetUpForm.setToDate("");
      oOperatingLimitSetUpForm.setStatusFlag("");
      oOperatingLimitSetUpForm.setStatus("");
      oOperatingLimitSetUpForm.setSubType("");
      oOperatingLimitSetUpForm.setRemarks("");
      oOperatingLimitSetUpForm.setOperationMode("");
      oOperatingLimitSetUpForm.setSerialNo("");
      oOperatingLimitSetUpForm.setErrorCode("");
      oOperatingLimitSetUpForm.setErrorMessage("");
      oOperatingLimitSetUpForm.setMenu("");
      oOperatingLimitSetUpForm.setEditFlag("");
   }

   private void clearSession(HttpSession session) {
      session.setAttribute("oOperatingLimitSetUpBO", " ");
      session.setAttribute("oOperatingLimitSetUpMessageBO", " ");
   }
}
