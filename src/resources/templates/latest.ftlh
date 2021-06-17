<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Latest</title>
    </head>
    <body>
        <#list codes as code>
            <div>
                <p><span>${code.date}</span></p>
                <pre>${code.code}</pre>
            </div>
    </body>
</html>