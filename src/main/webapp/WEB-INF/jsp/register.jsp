<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript">
	window.onload = function () {
		console.log('sdadasd')
		var control = document.getElementById("myFile");
		control.addEventListener("change", function (event) {
			console.log('rafa')
					       var i = 0,
					           files = control.files,
					           len = files.length,
					           maxSize=500000;

					       for (; i < len; i++) {

					           if(files[i].size > maxSize){
					               alert('Przekroczono dopuszczaly rozmiar pliku '+maxSize);
					               this.value="";
					           }else{
					               console.log("Filename: " + files[i].name);
					               console.log("Type: " + files[i].type);
					               console.log("Size: " + files[i].size + " bytes");
					               console.log(this.value);
					           }
					       }
		               }, false);
		            }
	</script>
<title><s:message code="menu.register"/></title>
</head>
<body>
	<div id="menuTable"><%@include file="/WEB-INF/incl/menu.app"%></div>
	<h2 align="center"><s:message code="menu.register"/></h2>
	<p align="center">
		<c:out value="${message}"/>
	</p>
	<sf:form id="usersForm" action="/adduser" modelAttribute="user"
         enctype="multipart/form-data" method="POST">
	
	 <table width="500" border="0" cellpadding="4" cellspacing="1"
           align="center">

        <tr>
            <td width="130" align="right" ><s:message code="register.name"/></td>
            <td width="270" align="left"><sf:input path="name" size="28" id="name" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><font color="red"><sf:errors path="name"/></font></td>
        </tr>

        <tr>
            <td width="130" align="right"><s:message code="register.lastName"/></td>
            <td width="270" align="left"><sf:input path="lastName" size="28" id="lastName" /></td>
        </tr>

        <tr>
            <td colspan="2" align="center"><font color="red"><sf:errors path="lastName"/></font></td>
        </tr>

        <tr>
            <td width="130" align="right" ><s:message code="register.email"/></td>
            <td width="270" align="left"><sf:input path="email" size="28" id="email" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><font color="red"><sf:errors path="email"/></font></td>
        </tr>

        <tr>
            <td width="130" align="right" ><s:message code="register.password"/></td>
            <td width="270" align="left"><sf:password path="password" size="28" id="password" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><font color="red"><sf:errors path="password"/></font></td>
        </tr>
        
        <tr>
            <td width="130" align="right" ><s:message code="register.gender"/></td>
            <td width="270" align="left"><sf:radiobutton path="gender" value="M" class="gender" />Male 
            							 <sf:radiobutton path="gender" value="F" class="gender" />Female
           	</td>
        </tr>
        <tr>
            <td colspan="2" align="center"><font color="red"><sf:errors path="gender"/></font></td>
        </tr>
        
        <tr>
            <td width="130" align="right" ><s:message code="register.country"/></td>
            <td width="270" align="left"><sf:select path="country" id="country">
            								<sf:option value="NONE" label="---Select---"/>
            								<sf:options items="${countryList}" itemValue="id" itemLabel="country"/>
            							</sf:select>
            </td>
        </tr>
         <tr>
            <td colspan="2" align="center"><font color="red"><sf:errors path="country"/></font></td>
        </tr>
        
        <tr>
            <td width="130" align="right" ><s:message code="register.role"/></td>
            <td width="270" align="left"><sf:checkboxes items="${roleList }" itemValue="id" itemLabel="role" path="roles"/>
            </td>
        </tr>
        
        
        <tr>
            <td colspan="2" align="center"><font color="red"><sf:errors path="roles"/></font></td>
        </tr>
        
         <tr>
            <td width="130" align="right" ><s:message code="register.file"/></td>
            <td width="270" align="left"><input type="file" name="file" id="myFile"/>
										
        	</td>
        </tr>
        <tr>
            <td colspan="2" align="center"><font color="red"><c:out value="${errorMessage}"/></font></td>
        </tr>
        

        <tr>
            <td colspan="2" align="center" bgcolor="#fff">
                <input type="submit" value="<s:message code="button.register"/>" />
                <input type="button" value="<s:message code="button.cancel"/>" onclick="window.location.href='${pageContext.request.contextPath}/'"/>
            </td>
        </tr>

    </table>
		
	
	</sf:form>

</body>
</html>