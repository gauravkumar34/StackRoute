## Problem Statement - Sorting E-Commerce Portal's Product List

In this challenge, you are going to work on one the e-commerce product list and need to write an application which can read from the CSV file and after processing and cleaning the data set, can sort on the data set by price and product ratings. The file is available as a CSV(Comma
Separated Value) file, available in the folder named `data` and is called `flipkart_product_sample.csv`.

> Please note that this data set is publicly available and is downloaded from `https://www.kaggle.com/PromptCloudHQ/flipkart-products`.

The file contains the following information:

- pid - contains the unique product ID
- product_name - contains the product name as it is displayed on the site
- brand - contains the brand of the product being sold.
- product_url - contains the URL for the product.
- retail_price - contains the retail price excluding any discount
- discounted_price - contains the discounted price excluding any discount
- product_rating - contains the product_ratings. product_rating can be ranging from 1 to 5. However, there are several products which does not have any rating. In those cases, the ratings should be considered as 0.

Following are the key objectives for this challenge:

- Read the file and store the data in memory in a Array
- write a method to sort the list of products based on it's price. Please note that the sorting can be done in either ascending or descending order. After sorting, it should print the sorted result in a file.
- write a method to sort the list of products based on it's rating in descending order only. After sorting, it should print the sorted result in a file.

> You need handle all exceptional situation that might occur during reading the file,
> parsing the values etc.
