
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글수정</title>
</head>
<body>
<h1>글수정</h1>
<div>${requestScope.msg}</div>
<form action="/board/mod" method="post">
    <input type="hidden" name="iboard" value="${requestScope.data.iboard}">
    <div><input type="text" name="title" placeholder="제목" value="<c:out value='${requestScope.data.title}'/>"></div>
    <div><textarea name="ctnt" placeholder="내용"><c:out value="${requestScope.data.ctnt}"/></textarea></div>
    <div>
        <input type="submit" value="수정">
    </div>
</form>
</body>
</html>