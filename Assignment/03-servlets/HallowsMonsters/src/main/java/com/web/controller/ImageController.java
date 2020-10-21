package com.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.web.service.ImageService;
import com.web.util.SessionController;

public class ImageController {
	
	private ImageService is;
	private SessionController sc;
	
	public ImageController(ImageService is, SessionController sc) {
		super();
		this.is = is;
		this.sc = sc;
	}
	
	public ImageController() {
		this(new ImageService(), new SessionController());
	}
	
	public void getImage(HttpServletRequest req, HttpServletResponse resp) {
		String s = "";
		String filename = req.getParameter("name");
		File m = is.findByName(filename);
		if(m!=null) {
			s= m.getName();
		} else {
			try {
				req.getRequestDispatcher("html/failed.html").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Image</title>");
			out.println("</head>");
			
			out.println("<body>");
			out.println("<img src = \"html/" + s+"\" width = 100%>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String addImage(HttpServletRequest req) {
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		int x = 0;
		File file = new File("C:\\Users\\enocho\\Desktop\\Revature Project\\2009Sep28Batch\\Assignment\\03-servlets\\HallowsMonsters\\src\\main\\webapp\\html\\img.jpg");
		try {
			List<FileItem> fi = sf.parseRequest(req);
			for(FileItem item : fi) {
				item.write(file);
			}
		x = is.insert(file);
			file.delete();
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(x == 0) {
			return "html/failed.html";
		} else {
			return "html/landing.html";
		}
	}

}
