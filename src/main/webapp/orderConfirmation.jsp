<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order Confirmation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #1e1e1e;
            color: #e0e0e0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .confirmation-box {
            background-color: #2e2e2e;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.5);
            text-align: center;
            max-width: 400px;
            width: 100%;
        }

        .confirmation-box h2 {
            color: #ffcc00;
            margin-bottom: 10px;
        }

        .order-details {
            margin: 20px 0;
            text-align: left;
        }

        .order-details p {
            margin: 5px 0;
            color: #ffd633;
        }

        .back-button {
            background-color: #ffcc00;
            color: #121212;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
            margin-top: 15px;
        }

        .back-button:hover {
            background-color: #e6b800;
        }
    </style>
</head>
<body>

    <div class="confirmation-box">
        <h2>Order Placed Successfully!</h2>
        <div class="order-details">
            <p><strong>Customer Name:</strong> ${name}</p>
            <p><strong>Delivery Address:</strong> ${address}</p>
            <p><strong>Ordered Items:</strong> ${items}</p>
            <p><strong>Total Amount:</strong> ₹${total}</p>
        </div>
        <button class="back-button" onclick="window.location.href='index.html';">Back to Home</button>
    </div>

</body>
</html>
