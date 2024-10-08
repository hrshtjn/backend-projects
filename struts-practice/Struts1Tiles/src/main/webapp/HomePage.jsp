<%@ page language="java" %>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%-- <%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%> --%>

<tiles:insert page="/Layout.jsp" flush="true">
   <tiles:put name="title" type="string" value="Welcome Page" />
   <tiles:put name="header" value="/header.jsp" />
   <tiles:put name="menu" value="/menu.jsp" />
   <tiles:put name="body" value="/body.jsp" />
   <tiles:put name="footer" value="/footer.jsp" /> 
</tiles:insert>