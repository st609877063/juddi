<%-- 
    Document   : settings
    Created on : Apr 6, 2013, 9:45:02 PM
    Author     : Alex O'Ree
--%>

<%@page import="org.apache.juddi.webconsole.resources.ResourceLoader"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="../csrf.jsp" %>
<%
    UddiHub x = UddiHub.getInstance(application, session);
    if (x.isAdminLocalhostOnly() &&  
            !request.getRemoteAddr().equalsIgnoreCase("localhost") && 
            !request.getRemoteHost().equalsIgnoreCase("127.0.0.1") &&
            !request.getRemoteHost().equalsIgnoreCase("0:0:0:0:0:0:0:1")) {
        out.write(ResourceLoader.GetResource(session, "pages.settings.accessdenied.remote"));
        UddiHub.log.fatal("Audit: FAILURE Attempt to alter configuration remotely from " + 
                request.getRemoteAddr() + " " +
                request.getRemoteHost() + " " + 
                request.getRemoteUser());
        response.setStatus(403);
        return;
    } else {
         
        
        //this is controlled by web.xml
    /*if (!request.isUserInRole("uddiadmin")) {
         out.write("Sorry, you need to have the 'uddiadmin' admin role to access this page.");
         response.setStatus(403);
         }*/
        if (request.getMethod().equalsIgnoreCase("post")) {
            UddiHub.log.info("Audit: SUCCESS Altering juddi config " + 
                request.getRemoteAddr() + " " +
                request.getRemoteHost() + " " + 
                request.getRemoteUser());
            
            Enumeration it = request.getParameterNames();
            while (it.hasMoreElements()) {
                String key = (String) it.nextElement();
                String value = request.getParameter(key);
                if (key.startsWith("client.") || key.startsWith("config.")) {
                    //its part of the juddi client config file
                    x.GetJuddiClientConfig().getConfiguration().setProperty(key, value);
                    //this just sets the runtime config

                }
            }
            try {
                x.GetJuddiClientConfig().saveConfig();
                out.write(ResourceLoader.GetResource(session, "actions.saved"));
            } catch (Exception ex) {
                response.setStatus(406);
                
                out.write(x.HandleException(ex));
            }
        }
    }
%>