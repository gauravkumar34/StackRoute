## Problem Statement - Sales Data
Sales analysis is a process performed on regular interval by the sales managers. By studying and
analyzing the past sales records, the sales manager can decide on the products his team can focus on. Also, it helps the product managers to understand the customer
likes and dislikes more effectively.

In this challenge, you need to build an Analyzer to analyze the historical sales data of an E-Commerce organization, which is available as a CSV(Comma
Separated Value) file, available in the folder named data and is called purchase_details.csv.
The file contains the following information:

    date - contains the date of purchase.
    customer_id - contains the customer_id of the customer who has purchased the product.
    product_category - contains the category_id of the product being sold.
    payment_method - this could have only two values, credit for credit card payment and paypal for PayPal based payments.
    value - contains the sales amount in USD.
    time_on_site - contains the time the customer has spent on the e-commerce site.
    clicks_in_site - contains the number of clicks made by the user while accessing the site. This value is captured to see how many products the customer has visited before making a purchase decision.


Incorporate Java 8 Functional Programming to achieve the objectives of the challenge. Use the built in Functional Interfaces where ever necessary


*Following are the key objectives of the challenge*

1. Display the date of purchase followed by the payment method.
2. Display the customer_id, date of purchase for the customers who made purchase using credit cards only
3. Display the product category for which the highest purchase was made
4. If the total clicks on site is 0, replace the value with 1 : note use a Supplier object to do the neccessary change.
5. List the purchases made on 23/11/18 only.