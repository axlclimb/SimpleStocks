1.)  mvn spring-boot:run

2.)  http://localhost:8080/calculateDividendYield?stockSymbol=TEA&stockType=COMMON&lastDividend=1.0&fixedDividend=1.0&parValue=100&stockSymbolPrice=2.3

3.)  http://localhost:8080/calculateDividendYield?stockSymbol=TEA&stockType=COMMON&lastDividend=1.0&fixedDividend=1.0&parValue=100&stockSymbolPrice=3.4

4.)  http://localhost:8080/calculatePriceEarningsRatio?stockSymbol=POP&stockType=COMMON&lastDividend=1.0&fixedDividend=1.0&parValue=100&stockSymbolPrice=3.7

5.)  http://localhost:8080/calculatePriceEarningsRatio?stockSymbol=POP&stockType=COMMON&lastDividend=1.0&fixedDividend=1.0&parValue=100&stockSymbolPrice=15.6

6.)  http://localhost:8080/recordTrade?&stockSymbol=TEA&sharesQuantity=100&tradeIndicator=BUY&price=11

7.)  http://localhost:8080/recordTrade?&stockSymbol=TEA&sharesQuantity=100&tradeIndicator=BUY&price=112

8.)  http://localhost:8080/recordTrade?&stockSymbol=POP&sharesQuantity=100&tradeIndicator=BUY&price=345

9.)  http://localhost:8080/recordTrade?&stockSymbol=POP&sharesQuantity=100&tradeIndicator=BUY&price=67

10.) http://localhost:8080/calculateStockPrice?stockSymbol=TEA&startingLimitInMilliseconds=900000

11.) http://localhost:8080/calculateGBCEAllShareIndex