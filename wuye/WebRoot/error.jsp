<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

		<title>Insert title here</title>

	</head>
	<body>
		<table>
			<tbody>
				<tr>
					<th class="t1"></th>
				</tr>
				<tr height="490">
					<td class="t1" align="center">
						<font color="red"> <s:fielderror /> </font>
						<font color="red">${mpi}</font>
						<br />
						<a href='javascript:history.go(-1);'
							style="text-decoration: underline">返回</a>
					</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>