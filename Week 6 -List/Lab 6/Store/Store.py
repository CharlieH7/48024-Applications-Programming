from Product import Product
from CashRegister import CashRegister

class Store:

    products = []
    matches1 = []
    matches2 = []

    def __init__(self):
        self.products.append(Product("Whiteboard Marker", 85, 1.50))
        self.products.append(Product("Whiteboard Eraser", 45, 5.00))
        self.products.append(Product("Black Pen", 100, 1.50))
        self.products.append(Product("Red Pen", 100, 1.50))
        self.products.append(Product("Blue Pen", 100, 1.50))
        self.cash_in_cash_register = CashRegister()
    
    def product(self, name):
        for product in self.products:
            if name == product.name:
                return product
        return None
    
    def read_options(self):
        choice = input("Choice (s/r/v/c/p/x): ")
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
            elif options == 'p':
                self.prune_products()
            else:
                self.menu()
            options = self.read_options()
        print("Done")

    def read_number(self):
        number = int(input("Number: "))
        return number
    
    def read_name(self):
        name = input("Name: ")
        return name

    def read_price(self):
        price = float(input("Price: $"))
        return price
    
    def contain_pen(self, products):
        for product in products:
            if "Pen" in product.name:
                self.matches1.append(product)
        return self.matches1

    def view_matches1(self):
        print("Multiple products match:")
        for obj in self.matches1:
            print(obj.name + " - " + str(obj.stock) + " at $" + str("{:.2f}".format(obj.price)))
    
    def contain_whiteb(self, products):
        for product in products:
            if "Whiteb" in product.name:
                self.matches2.append(product)
        return self.matches2

    def view_matches2(self):
        print("Multiple products match:")
        for obj in self.matches2:
            print(obj.name + " - " + str(obj.stock) + " at $" + str("{:.2f}".format(obj.price)))

    def sell(self):
        product = self.read_name()
        name = product.title()
        p = self.product(name)

        if p != None:
            print("Selling " + name)
            amount = self.read_number()
            if p.has(amount):
                print("Not enough stock")
            else:
                money = p.sell(amount)
                self.cash_in_cash_register.update_cash(money)
        elif name == "Pen":
            self.contain_pen(self.products)
            self.view_matches1()
        elif name == "Whiteb":
            self.contain_whiteb(self.products)
            self.view_matches2()
        else:
            print("No such product")
        
    def restock(self):
        s = self.read_name()
        words = s.title()
        p = self.product(words)
        if p != None:
            print("Restocking " + words)
            p.restock(self.read_number())
        elif words == "Pen":
            self.contain_pen(self.products).clear()
            self.contain_pen(self.products)
            for i in self.matches1:
                print("Restocking " + i.name)
                i.restock(self.read_number())
        elif words == "Whiteboard":
            self.contain_whiteb(self.products).clear()
            self.contain_whiteb(self.products)
            for i in self.matches2:
                print("Restocking " + i.name)
                i.restock(self.read_number())
        else:
            print("Adding new product")
            number = self.read_number()
            price = self.read_price()
            self.products.append(Product(words, number, price))

    
    def view_stock(self):
        for obj in self.products:
            print(obj.name + " - " + str(obj.stock) + " at $" + str("{:.2f}".format(obj.price)))

    def view_cash(self):
        print(self.cash_in_cash_register.toString())
    
    def prune_products(self):
        for product in self.products:
            if product.stock == 0:
                self.products.remove(product)
        return self.products
    
    def menu(self):
        print("Menu options")
        print("s = sell")
        print("r = restock")
        print("v = view stock")
        print("c = view cash")
        print("p = prune products")
        print("x = exit")
    
if __name__ == "__main__":
    store = Store()
    store.use()

