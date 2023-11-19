## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies
- `Log.txt`: Contains records for the important events and transactions along with timestamps. (file will be generated when the application is started)

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.


## Instructions to Run

1) Open the project's root directory and open in VS Code/or any other Java Compatible IDE
code .

2) Open the main file ShoppingSystem.java which contains the main function.

--> Run Java

    Alternatively, you can compile and run the project from the terminal:

--> javac -d bin src/*.java
--> java -cp bin ShoppingSystem

## Sample Input and Output

Options:
1. Login
2. Logout
3. View Products
4. Add to Cart
5. Remove from Cart
6. View Cart
7. Process Payment
8. Exit

## Login
Enter your choice: 1
Enter your account name: Noor
Welcome, Noor!  

Options:
1. Login
2. Logout
3. View Products
4. Add to Cart
5. Remove from Cart
6. View Cart
7. Process Payment
8. Exit
## View Products
Enter your choice: 3
Available Products:
Laptop: High-performance laptop with great features. Price: $800.0
Phone: Latest smartphone with amazing camera and battery life. Price: $500.0
Tablet: Portable tablet with a sleek design and powerful functionality. Price: $300.0
SmartWatch: Stylish smartwatch with health and fitness tracking features. Price: $150.0

Options:
1. Login
2. Logout
3. View Products
4. Add to Cart
5. Remove from Cart
6. View Cart
7. Process Payment
8. Exit
## Add to Cart
Enter your choice: 4
Available Products:
Laptop: High-performance laptop with great features. Price: $800.0
Phone: Latest smartphone with amazing camera and battery life. Price: $500.0
Tablet: Portable tablet with a sleek design and powerful functionality. Price: $300.0
SmartWatch: Stylish smartwatch with health and fitness tracking features. Price: $150.0

Enter product type (laptop/phone/tablet/smartwatch): Tablet
Enter quantity: 3
Cart Contents:
Tablet: 3

Options:
1. Login
2. Logout
3. View Products
4. Add to Cart
5. Remove from Cart
6. View Cart
7. Process Payment
8. Exit
Enter your choice: 4
Available Products:
Laptop: High-performance laptop with great features. Price: $800.0
Phone: Latest smartphone with amazing camera and battery life. Price: $500.0
Tablet: Portable tablet with a sleek design and powerful functionality. Price: $300.0
SmartWatch: Stylish smartwatch with health and fitness tracking features. Price: $150.0

Enter product type (laptop/phone/tablet/smartwatch): phone
Enter quantity: 1
Cart Contents:
phone: 1
Tablet: 3

Options:
1. Login
2. Logout
3. View Products
4. Add to Cart
5. Remove from Cart
6. View Cart
7. Process Payment
8. Exit
## Remove from Cart
Enter your choice: 5
Enter product type to remove (laptop/phone/tablet/smartwatch): phone
Enter quantity to remove: 1
Cart Contents:
Tablet: 3

Options:
1. Login
2. Logout
3. View Products
4. Add to Cart
5. Remove from Cart
6. View Cart
7. Process Payment
8. Exit
## View Cart
Enter your choice: 6
Cart Contents:
Tablet: 3

Options:
1. Login
2. Logout
3. View Products
4. Add to Cart
5. Remove from Cart
6. View Cart
7. Process Payment
8. Exit
## Process Payment
Default account balance is $20,000 (hardcoded)

Enter your choice: 7
Total Price: $900.0
Payment successful!
Remaining balance: $19100.0

Options:
1. Login
2. Logout
3. View Products
4. Add to Cart
5. Remove from Cart
6. View Cart
7. Process Payment
8. Exit
## Logout
Enter your choice: 2
Goodbye, Noor!

Options:
1. Login
2. Logout
3. View Products
4. Add to Cart
5. Remove from Cart
6. View Cart
7. Process Payment
8. Exit

## Retrieve Account
--> To login back to your account use the correct account name
--> It is able to retrieve the account details and the individual cart data is associated with their respective accounts.

Enter your choice: 1
Enter your account name: Noor
Welcome back, Noor!   
