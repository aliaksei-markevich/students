<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <script src="/js/jquery.js" type="text/javascript"></script>
    <script src="/js/jquery-ui.min.js" type="text/javascript"></script>
    <script src="/js/searchAutocomplete.js" type="text/javascript"></script>
    <link href="/css/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div>
    <h4>Форма для поиска клиентов по фамилии</h4>
    <form method="get" action="/viewList?search">
        <input type="text" class="autocomplete" data-url="/search?client"/>
        <input type="hidden" name="index"/>
        <input type="submit" value="Показать"/>
    </form>
    <h4>Форма для поиска в дереве</h4>
    <form method="get" action="/viewTree?search">
        <input type="text" class="autocomplete" data-url="/search?tree"/>
        <input type="hidden" name="index"/>
        <input type="submit" value="Показать"/>
    </form>
</div>
</body>
</html>
