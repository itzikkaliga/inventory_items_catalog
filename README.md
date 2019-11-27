# inventory-items-catalog
A spring boot appliction that maintaining a inventory items catalog

## How to run it?
Simply pull this repository run the project,
and then enter to yout localhost on port 8083 with /swagger-ui.html ending
(in windows http://localhost:8083/swagger-ui.html)
to change and and see you inventory items.

## How to use?
First of all you need
to open InventoryItemsController.

To see all of the items:
Open "getAllItems" and press "Try it!".
Then a list with all the items in it will
return to you.

To add an item:
Open "addItem" and give the folowing detials:

itemno - a long number that will be your ID for this item
name - a string that will be the name of the item
amount - an int number that save the starting amount of this item - positive number!
invCode - a string that will be the code of this item.
Then press "Try it!".
After that a message will return for susuccessfuly adding the item.

To get a specific item data:
Open getItemByItemNum and give an ID (in itemnum)
then press "Try it!".
It will return you an item data if
the ID is valid, if not you will get 
nothing (null).

To withdrawal quantity of a specific item:
Open withdrawQuant and give an ID (in itemnum)
and positive amoount (in decamount) to withdrawal
then press "Try it!".
You will get a response if the action
success or not.

To deposite depositItem of a specific item:
Open depositItem and give an ID (in itemnum)
and positive amoount (addamount).
As it was in withdrawQuant
you will get a response if the action
success or not.

To delete a specific item from the catalog:
Open deleteItem and give an ID (in itemnum)
then press "Try it!".
It will delete the item from the catalog
if Id is valid,
if not nothing will happen.

