<!DOCTYPE HTML>
<html>
<head>
<title>View Product</title>
<link href="static_resources/css/product.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="global">
    <h4>${message}</h4>
    <p>
        <h5>Details:</h5>
        Product Name: ${product.name}<br/>
        Description: ${product.description}<br/>
        Price: $${product.price}
    </p>
</div>
</body>
</html>