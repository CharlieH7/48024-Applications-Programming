from Product import Product
from CashRegister import CashRegister

class Store:

    def __init__(self):
        self.product = Product()
        self.cash_in_cash_register = CashRegister()
    
    def read_options(self):
        choice = input("Choice (s/r/v/c/x): ")
        return choice
        
    def use(self):
        options = self.read_options()
        while (options != 'x'):
            if options == 's':
                self.sell()
            elif options == 'r':
                self.restock()
            elif options == 'v':
                self.view_stock()
            elif options == 'c':
                self.view_cash()
            else:
                self.menu()
            options = self.read_options()
        print("Done")

    def read_number(self):
        number = int(input("Number: "))
        return number

    def sell(self):
        amount = self.read_number()
        if (self.product.has(amount)):
            print("Not enough stock") 
        else:
            self.product.sell(amount)
            self.cash_in_cash_register.update_cash(amount)
    
    def restock(self):
        self.product.restock(self.read_number())
    
    def view_stock(self):
        print(self.product.toString())

    def view_cash(self):
        print(self.cash_in_cash_register.toString())
    
    def menu(self):
        print("Menu options")
        print("s = sell")
        print("r = restock")
        print("v = view stock")
        print("c = view cash")
        print("x = exit")
    
if __name__ == "__main__":
    store = Store()
    store.use()

