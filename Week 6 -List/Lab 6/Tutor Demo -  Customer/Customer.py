from Account import Account

class Customer:
    
    def __init__(self):
        self.accounts = [Account(accountType = 'Savings'), Account(accountType = 'Loan')]
    
    def use(self):
        choice = self.readChoice()
        while (choice != 'x'):     
            if choice == 'd':
                self.deposit()
            elif choice == 'w':
                self.withdraw()
            elif choice == 't':
                self.transfer()
            elif choice == 'v':
                self.view()
            else:
                self.helpMenu()
            choice = self.readChoice()
    
    def readChoice(self):
        return input('Customer menu (d/w/t/v/x): ')
    
    def readAmount(self, action):
        return float(input('Amount to %s: $' %action))
    
    def readType(self):
        return input('Account type: ')
    
    def account(self, accountType):
        for account in self.accounts:
            if account.hasType(accountType):
                return account
        return None
    
    def deposit(self):
        account = self.account(self.readType())
        if account != None: 
            account.deposit(self.readAmount('deposit'))
        else:
            print('No such account')
            
    def withdraw(self):
        amount = self.readAmount('withdraw')
        savingsAccount = self.account('Savings')
        if savingsAccount.has(amount):
            savingsAccount.withdraw(amount)
        else:
            print('Insufficient funds')
    
    def transfer(self):
        amount = self.readAmount('transfer')
        savingsAccount = self.account('Savings')
        if savingsAccount.has(amount):
            savingsAccount.transferTo(amount, self.account('Loan'))
        else:
            print('Insufficient funds')
    
    def view(self):
        account = self.account(self.readType())
        if account != None:
            account.toString()
        else:
            print('No such account')

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