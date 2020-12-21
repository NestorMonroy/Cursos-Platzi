from account import Account

class User(Account):
    def __init__(self,name,document):
        super(User,self).__init__(name,document)