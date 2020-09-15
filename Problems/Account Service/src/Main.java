import java.util.Arrays;
import java.util.Optional;

interface AccountService {
    /**
     * It finds an account by owner id
     *
     * @param id owner unique identifier
     * @return account or null
     */
    Account findAccountByOwnerId(long id);

    /**
     * It count the number of account with balance > the given value
     *
     * @param value
     * @return the number of accounts
     */
    long countAccountsWithBalanceGreaterThan(long value);
}

class AccountServiceImpl implements AccountService {

    Account[] accounts;

    public AccountServiceImpl(Account[] accounts) {
        if (accounts == null) {
            this.accounts = new Account[0];
        } else {
            this.accounts = Arrays.copyOf(accounts, accounts.length);
        }
    }

    @Override
    public Account findAccountByOwnerId(long id) {
        Optional<Account> first = Arrays.stream(accounts)
                .filter(account -> account.getOwner().getId() == id)
                .findFirst();
        return first.orElse(null);
    }

    @Override
    public long countAccountsWithBalanceGreaterThan(long value) {
        return Arrays.stream(accounts)
                .filter(account -> account.getBalance() > value)
                .count();
    }
}

class Account {

    private long id;
    private long balance;
    private User owner;

    public Account(long id, long balance, User owner) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public long getBalance() {
        return balance;
    }

    public User getOwner() {
        return owner;
    }
}

class User {

    private long id;
    private String firstName;
    private String lastName;

    public User(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}