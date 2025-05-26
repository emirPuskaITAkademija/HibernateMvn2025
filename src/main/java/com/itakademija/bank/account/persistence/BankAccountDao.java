package com.itakademija.bank.account.persistence;

import com.itakademija.Dao;
import org.hibernate.Session;

import java.util.List;
import java.util.function.Function;

public class BankAccountDao implements Dao<BankAccount, String> {

    @Override
    public List<BankAccount> getAll() {
        return executeInTransaction(session -> session.createQuery("from BankAccount").list());
    }

    @Override
    public BankAccount getById(String id) {
        return executeInTransaction(session -> session.get(BankAccount.class, id));
    }

    @Override
    public BankAccount save(BankAccount bankAccount) {
        return executeInTransaction(session -> {
            session.save(bankAccount);
            return bankAccount;
        });
    }

    @Override
    public void delete(BankAccount bankAccount) {
        executeInTransaction(session -> {
            session.delete(bankAccount);
            return true;
        });
    }

    @Override
    public void update(BankAccount bankAccount) {
        executeInTransaction(session -> {
            session.update(bankAccount);
            return true;
        });
    }


    public boolean transfer(BankAccount fromBankAccount, BankAccount toBankAccount, double amount) {
        if (fromBankAccount == null || toBankAccount == null) {
            return false;
        }
        if (fromBankAccount.equals(toBankAccount)) {
            return false;
        }
        if (amount < 0) {
            return false;
        }
        if (fromBankAccount.getAmount() < amount) {
            return false;
        }

        Function<Session, Boolean> sessionBooleanFunction = session -> {
            fromBankAccount.setAmount(fromBankAccount.getAmount() - amount);
            session.update(fromBankAccount);

            toBankAccount.setAmount(toBankAccount.getAmount() + amount);
            session.update(toBankAccount);

            return true;
        };
        return executeInTransaction(sessionBooleanFunction);
    }
}
