# boson assessment

## How to Run:

1. Just run the main class to get the result for the default input.
2. edit transactions.xml file to provide different inputs.

## Design:

1. supports multiple sellers, buyers, and items, not just the ones in default input and more than one of the same item.
2. Most of the design adheres to SOLID principles.
3. used enum class for transaction types that only supports the following:
   1. Credit
   2. Offer
   3. Order
   4. Complete
   5. Complain
4. additional types of transactions is supported provided they are added in the enums and the type classes in constant file.   

## Assumptions Made:

1. assumed Deposit to be crediting the buyers account. Changed deposit to credit in the default input and the model doesn't support Deposit.
2. assumed that there are only 2 kinds of transactions:
    1. Financial kind that credits or debits account (debit can be added)
    2. Trade kind that always have something to do with an item and an exchange (for example: buyer returning an item after buying can be added).
    3. To add more kinds of transactions(other than the above 2): 
       1. create a new enum for that kind in constants file
       2. create a new implementation(class) of that transaction kind in transactions package.
       3. create the necessary type classes in types package(types of transactions in that kind) to process that type of transaction and add the name of the class to transaction  classes in constants file.
3. assumed that the order of transactions is the correct order(for example: there's enough money in user's account before ordering and putting in escrow, and enough money in escrow before completing the transaction.)
4. assumed that data is coming in XML format.


