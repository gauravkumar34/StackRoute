## Problem Statement - The Stock Analyzer

**Stock analysis** is a method for investors and traders to make buying and selling decisions. By studying and 
evaluating past and current data, investors and traders attempt to gain an edge in the markets by making informed 
decisions.

In this challenge, you need to build a Stock Analyzer - that will attempt to analyze the historical data of a stock, which is available as a CSV(Comma 
Separated Value) file, which is available in the folder named `data` and is called `CIPLA.NS.CSV`.

The file contains the following information:
- Date - Date of the transaction
- Open - Stock price at the beginning of the day
- High - Highest Stock price for the day
- Low - Lowest Stock price for the day
- Close - Closing Stock price for the day at the time of closing the market
- Adj Close - The adjusted closing price analyzes the stock's dividends, stock splits and new stock offerings to determine an adjusted value.
- Volume - No. of stocks traded

> Note: for all return calculations, we will use the stock price at day close(not Adjusted close)

Following are the key objectives for this challenge:

- Use the stock prices of Cipla, a pharmaceutical company for last 5 years listed in NSE (refer the data file)

- Find the no. of records in the file. Headers must not be counted as a record.

- Provide a solution to the following requirements, you solution should be able to:
    - Find the absolute return between the first record and the last record and display in %
    - Find absolute return between two dates specified and display in %
    - Provide the value of one's investment on a particular date. For instance - if a person has invested some amount on the stock on a particular date, the application should be able to provide an answer on what is the value of one's investment on another date which is specified by the user
    - Find the highest stock price for the stock for the entire range and display the same along with volume and date of transaction
    - Find the lowest stock price for the stock for the entire range and display the same along with volume and date of transaction
    - Find the average daily return of the stock. 

Note: Sort the records by date in ascending order

If we have to find the absolute return between **2020-03-01**(let us call it d1) and **2020-05-02**(let us call it d2), the formula is:
	
	absolute return = (d2-d1)/d1

If we have to find the daily return between **2020-03-01**(let us call it d1) and **2020-03-02**(let us call it d2), the formula is:
	
	daily return = (d2-d1)/d1

Average Daily return can be found out by finding the average of the daily return in %. 


> You need handle all exceptional situation that might occur during reading the file,
> parsing the values etc.
