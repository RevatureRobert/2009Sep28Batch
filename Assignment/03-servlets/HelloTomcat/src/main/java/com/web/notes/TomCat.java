package com.web.notes;




/*
 * 												                    Server
 * 														_______________________
 * 		Client Browser         -----------   				server runtime(tomcat)
 * 										||				__________________________
 * 										------------->	deployment descriptor(web.xml)
 * 															-the browser connects to here. 
 * 															-tells the server runtime what servlet to use
 * 														|
 *														<-->servlet <--> request forwarder
 *																			|
 *																			<-->controller <--> service <--> repo <-->                 Database		 
 * 																																	___________________
 * 
 * 
 * HTTP Request0
 * .
 * 		
 * 
 * 
 */

public class TomCat {

}
