class Account:
    # Type is a key word, so have to use accountType instead of Type
    def __init__(self, accountType):
        self.accountType = accountType
        self.balance = self.readBalance()
    
    def readBalance(self):
        return float(input('Initial %s balance: $' %(self.accountType)))
    
    def has(self, amount):
        return self.balance >= amount
    
    def deposit(self, amount):
        self.balance += amount
        
    def withdraw(self, amount):
        self.balance -= amount
        
    def transferTo(self, amount, target):
        target.balance += amount
        self.balance -= amount
    
    def toString(self):
        #print('%s account has $%.2f' %(self.accountType, self.balance))
        amount='{:,.2f}'.format(self.balance)
        print('%s account has $%s' %(self.accountType, amount))
