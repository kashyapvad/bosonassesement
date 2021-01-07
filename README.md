# boson assessment

## How to Run:

1. Just run the main class to get the result for the default input.
2. edit transactions.xml file to provide different inputs.

## Design:

1. supports multiple sellers, buyers, and items, not just the ones in default input.
2. Most of the design adheres to SOLID principles

## Assumptions Made:

1. assumed Deposit to be crediting the buyers account. Changed deposit to credit in the default input and the model doesn't support Deposit.
2. assumed that there are only 2 types of transactions:

    1. Financial type that credits or debits account (debit can be added)
    2. Trade type transactions that always have something to do with an item


