<html>
<head>
    <title>File upload</title>
</head>
<body>
<div align="center">
    <div><h2>File upload</h2></div>
    <form action="http://localhost:8080/JavaEE_war_exploded/load-book" method="post" enctype="multipart/form-data">
        <p>
            Description: <input type="text" name="description" size="30" required />
        </p>
        <p>
            <input type="file" name="file" required />
        </p>
        <p>
            <button type="submit">Submit</button>
        </p>
    </form>
</div>
</body>
</html>