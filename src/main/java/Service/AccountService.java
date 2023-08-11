package Service;

import DAO.AccountDAO;
import Model.Account;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService() {
        accountDAO = new AccountDAO();
    }

    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public Account addAccount(Account account) {
        if (account.getUsername() == "") {
            return null;
        }
        if (account.getPassword().length() < 4) {
            return null;
        }
        return accountDAO.insertAccount(account);
    }

    public Account accountLogin(Account account) {
        return accountDAO.verifyAccount(account);
    }
}
