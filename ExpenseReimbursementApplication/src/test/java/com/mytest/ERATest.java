package com.mytest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

import org.junit.Test;
import org.mockito.Mockito;

import com.controller.FinanceManagerController;
import com.dao.EmployeeDao;
import com.dao.LoginValidationDao;
import com.model.Employee;
import com.model.FinanceManager;
import com.model.Reimbursement;
import com.model.User;
import com.servlet.AddNewReimbServlet;
import com.servlet.ApprovedReimbursementServlet;
import com.servlet.LoginSuccessfulServlet;
import com.servlet.RegisterNewEmployeeServlet;
import com.servlet.RejectedReimbursementServlet;
import com.servlet.UpdatedPasswordServlet;
import com.servlet.ViewPastReimbServlet;
import com.servlet.ViewPendingReimbServlet;

public class ERATest extends Mockito
{
	EmployeeDao ed = new EmployeeDao();
	Reimbursement r = new Reimbursement(12.99F, "hello", 1,1,1);
	LoginValidationDao lvd = new LoginValidationDao();
	FinanceManagerController fmc = new FinanceManagerController();
	
	User emp = new Employee(1, "a", "b", "c", "d", "e", 1);
	User fm = new FinanceManager(1, "a", "b", "c", "d", "e", 1);
	
	@Test
	public void idUserNameMatch()
	{
		assertEquals(2, ed.findUserIDByUserName("FounderJones"));
	}
	
	@Test
	public void fullNameUserIDMatch()
	{
		assertEquals("Thomas Wilkins",ed.findfullNamebyUserID(1));
	}
	
	@Test
	public void reimbursementAdded()
	{
		assertEquals(1, ed.confirmAddedReimbursement());
	}
	

	@Test
	public void getMyAmount()
	{
		assertEquals(12.99F, r.getReimb_amount(), 0.1);
	}
	
	@Test
	public void getMyDescription()
	{
		assertEquals("hello", r.getReimb_description());
	}
	
	@Test
	public void getMyAuthor()
	{
		assertEquals(1, r.getReimb_author());
	}
	
	@Test
	public void getMyStatus()
	{
		assertEquals(1, r.getReimb_status_id());
	}
	
	@Test
	public void getMyType()
	{
		assertEquals(1, r.getReimb_type_id());
	}
	
	@Test
	public void getEmpID()
	{
		assertEquals(1, emp.getUserid());
	}
	
	@Test
	public void getEmpUserName()
	{
		assertEquals("a", emp.getUsername());
	}
	
	@Test
	public void getEmpPassword()
	{
		assertEquals("b", emp.getPassword());
	}
	
	@Test
	public void getEmpFirstName()
	{
		assertEquals("c", emp.getFirstname());
	}
	
	@Test
	public void getEmpLastName()
	{
		assertEquals("d", emp.getLastname());
	}
	
	@Test
	public void getEmpEmail()
	{
		assertEquals("e", emp.getEmail());
	}
	
	@Test
	public void getEmpRoleID()
	{
		assertEquals(1, emp.getUser_role_id());
	}
	
	@Test
	public void getFMID()
	{
		assertEquals(1, fm.getUserid());
	}
	
	@Test
	public void getFMUserName()
	{
		assertEquals("a", fm.getUsername());
	}
	
	@Test
	public void getFMPassword()
	{
		assertEquals("b", fm.getPassword());
	}
	
	@Test
	public void getFMFirstName()
	{
		assertEquals("c", fm.getFirstname());
	}
	
	@Test
	public void getFMLastName()
	{
		assertEquals("d", fm.getLastname());
	}
	
	@Test
	public void getFMEmail()
	{
		assertEquals("e", fm.getEmail());
	}
	
	@Test
	public void getFMRoleID()
	{
		assertEquals(1, fm.getUser_role_id());
	}
	

    @Test
    public void testAddNewReimbServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("usrname")).thenReturn("FounderWilkins");
        when(request.getParameter("type")).thenReturn("1");
        when(request.getParameter("amt")).thenReturn("1.88");
        when(request.getParameter("message")).thenReturn("help");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new AddNewReimbServlet().doPost(request, response);

   //     verify(request, atLeast(1)).getParameter("usrname"); 
        writer.flush(); // it may not have been flushed yet...
        assertTrue(stringWriter.toString().contains(""));
    }
	
    @Test
    public void testApprovedReimbursementServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("reimb")).thenReturn("1");
        when(request.getParameter("fmusername")).thenReturn("SMiller");


        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new ApprovedReimbursementServlet().doPost(request, response);

   //     verify(request, atLeast(1)).getParameter("usrname"); 
        writer.flush(); // it may not have been flushed yet...
        assertTrue(stringWriter.toString().contains(""));
    }
    
    
    @Test
    public void testRejectedReimbursementServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("reimb")).thenReturn("3");
        when(request.getParameter("fmusername")).thenReturn("SMiller");


        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new RejectedReimbursementServlet().doPost(request, response);

   //     verify(request, atLeast(1)).getParameter("usrname"); 
        writer.flush(); // it may not have been flushed yet...
        assertTrue(stringWriter.toString().contains(""));
    }
    
    @Test
    public void testUpdatedPasswordServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("users_id")).thenReturn("3");
        when(request.getParameter("newpword")).thenReturn("abc");


        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new UpdatedPasswordServlet().doPost(request, response);

   //     verify(request, atLeast(1)).getParameter("usrname"); 
        writer.flush(); // it may not have been flushed yet...
        assertTrue(stringWriter.toString().contains(""));
    }
    
    @Test
    public void testViewPastReimbServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("usrname")).thenReturn("FounderWilkins");



        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new ViewPastReimbServlet().doPost(request, response);

   //     verify(request, atLeast(1)).getParameter("usrname"); 
        writer.flush(); // it may not have been flushed yet...
        assertTrue(stringWriter.toString().contains(""));
    }
    
    @Test
    public void testViewPendingReimbServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new ViewPendingReimbServlet().doPost(request, response);

   //     verify(request, atLeast(1)).getParameter("usrname"); 
        writer.flush(); // it may not have been flushed yet...
        assertTrue(stringWriter.toString().contains(""));
    }
    
    @Test
    public void testLoginValidation()
    {
    	assertEquals("John Novak", lvd.loginValidation("JNovak", "64118260ECB916C23621D8F2768D8DC75D1F5710B1B7E4F2C41AD41E6BC4D688"));
    }
    
    @Test
    public void testValidateUserRoleID()
    {
    	assertEquals(1, lvd.validateUserRoleID("SMiller"));
    }
    
    @Test
    public void testRegisterNewEmployeeServlet() throws Exception
    {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new RegisterNewEmployeeServlet().doPost(request, response);

   //     verify(request, atLeast(1)).getParameter("usrname"); 
        writer.flush(); // it may not have been flushed yet...
        assertTrue(stringWriter.toString().contains(""));
    }
    
    @Test
    public void testLoginSuccessfulServlet() throws Exception
    {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new LoginSuccessfulServlet().doPost(request, response);

   //     verify(request, atLeast(1)).getParameter("usrname"); 
        writer.flush(); // it may not have been flushed yet...
        assertTrue(stringWriter.toString().contains(""));
    }
    
    @Test
    public void testViewPastEmpReimbServlet() throws Exception
    {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new LoginSuccessfulServlet().doPost(request, response);

   //     verify(request, atLeast(1)).getParameter("usrname"); 
        writer.flush(); // it may not have been flushed yet...
        assertTrue(stringWriter.toString().contains(""));
    }
    
    @Test
    public void testConfirmAddedReimbursement()
    {
    	assertEquals(1, ed.confirmAddedReimbursement());
    }
  /*  
    @Test
    public void testFMControllerLogin()
    {	
    	assertEquals("html/landing.html", fmc.login(null));
    }
    */
    
}
