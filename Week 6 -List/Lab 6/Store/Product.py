class Product:
    
    cash = 0.0

    def __init__(self, name, stock, price):
        self.name = name
        self.stock = stock
        self.price = price

    def sell(self, n):
        self.stock = self.stock - n
        self.cash = self.cash + self.price * n
        return self.cash

    def restock(self, n):
        self.stock = self.stock + n
    
    def has_name(self, name):
        return self.name == name

    def has(self, n):
        return self.stock < n

    def toString(self):
        return self.name + " - " + str(self.stock) + str(self.price)
