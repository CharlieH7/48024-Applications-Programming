class Product:

    def __init__(self):
        self.name = "Sticky tape"
        self.stock = 200
        self.price = 2.99

    def sell(self, n):
        self.stock = self.stock - n
        cash = 2.99 * n
        return cash

    def restock(self, n):
        self.stock = self.stock + n

    def has(self, n):
        return self.stock < n

    def toString(self):
        return str(self.stock) + " Sticky tape at $" + str(self.price)
