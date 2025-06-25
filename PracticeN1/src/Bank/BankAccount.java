package Bank;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class BankAccount {
    String NameAccount;
    int BalanceMoney;
    LocalDateTime DateOpen;
    boolean BalanceStatusBlock;
    String NumberAccount;

    public BankAccount(String name){
        this.NameAccount = name;
        this.BalanceMoney= 0;
        this.DateOpen=LocalDateTime.now();
        this.BalanceStatusBlock =false; // если false - счёт не заблокирован, иначе заблокирован
        Random random=new Random();
        StringBuilder randomNumber=new StringBuilder();
        for(int i=0;i<8;i++){
            randomNumber.append(random.nextInt(10));
        }
        this.NumberAccount=randomNumber.toString();


    }


    public boolean Deposit(int amount){
        if ((BalanceStatusBlock !=true) && (amount>0) ){
            BalanceMoney+=amount;
            return true;
        }

        return false;
    }
    public boolean Withdraw(int amount){
        if ((BalanceStatusBlock !=true)&&(BalanceMoney >= amount) && (amount > 0)){
            BalanceMoney-=amount;
            return true;
        }
        return false;
    }

    public boolean Transfer(BankAccount otherAccount, int amount){
        if ((BalanceStatusBlock != true && otherAccount.BalanceStatusBlock!=true)&&(BalanceMoney >= amount) && (amount >0)){
            BalanceMoney-=amount;
            otherAccount.Deposit(amount); // используем свой метод вместо otherAccount.BalanceMoney+=amount
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(NumberAccount, that.NumberAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(NumberAccount);
    }


    @Override
    public String toString(){
        return String.format("Number cart: %s \nName: %s\nBalance money: %d\nData open cart: %s\nBalance status blocked: %s",
                NumberAccount,
                NameAccount,
                BalanceMoney,
                DateOpen,
                BalanceStatusBlock ? "Blocked" : "Open"
                );
    }
}

