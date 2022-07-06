class CashRegister:

    def __init__(self):
        self.cash = 0.0

    def update_cash(self, amount):
        amount = amount * 2.99
        self.cash = self.cash + amount
        return self.cash
    
    def toString(self):
        amount='{:.2f}'.format(self.cash)
        if self.cash == 0.0:
            return "Cash register: empty"
        else:
            return "Cash register: $" + str(amount)

