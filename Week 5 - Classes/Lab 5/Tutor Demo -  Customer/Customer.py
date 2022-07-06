from Account import Account

class Customer:
    
    def __init__(self):
        self.savingsAccount = Account(accountType = 'Savings')
        self.loanAccount = Account(accountType = 'Loan')
    
    def use(self):
        choice = self.readChoice()
        while (choice != 'x'):     
            if choice == 'd':
                self.deposit()
            elif choice == 'w':
                self.withdraw()
            elif choice == 't':
                self.transfer()
            elif choice == 's':
                self.show()
            else:
                self.helpMenu()
            choice = self.readChoice()

    def readChoice(self):
        return input('Customer menu (d/w/t/s/x): ')
    
    def readAmount(self, action):
        return float(input('Amount to %s: $' %action))
    
    def deposit(self):
        self.savingsAccount.deposit(self.readAmount('deposit'))
    
    def withdraw(self):
        amount = self.readAmount('withdraw')
        if self.savingsAccount.has(amount):
            self.savingsAccount.withdraw(amount)
        else:
            print('Insufficient funds')
    
    def transfer(self):
        amount = self.readAmount('transfer')
        if self.savingsAccount.has(amount):
            self.savingsAccount.transferTo(amount, self.loanAccount)
        else:
            print('Insufficient funds')
    
    def show(self):
        self.savingsAccount.toString()
        self.loanAccount.toString()
    
    def helpMenu(self):
        print("Menu options")
        print("d = deposit")
        print("w = withdraw")
        print("t = transfer")
        print("s = show")
        print("x = exit")

if __name__ == "__main__":
    customer = Customer()
    customer.use()
    print('Done')
