class CashRegister:

    def __init__(self):
        self.cash = 0.0

    def update_cash(self, amount):
        self.cash = self.cash + amount
    
    def toString(self):
        amount='{:.2f}'.format(self.cash)
        if self.cash == 0.0:
            return "Cash register: empty"
        else:
            return "Cash: $" + str(amount)

