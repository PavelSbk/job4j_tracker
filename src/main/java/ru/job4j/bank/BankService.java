package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Класс описывает простейшую модель банковской системы.
 *
 * @author Public Sbk
 * @version 1.0
 */
public class BankService {

    /**
     * Хранилице данных в виде карточек пользователей с банковскими счетами,
     * реализовано с помощью HashMap user.
     * содержит в себе Экземпляр класса User (в качестве key).
     * содержит в себе коллекцию класса Account (в качестве value).
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод оздаёт карточку пользователя с пустым списком класса Account
     * и размещает её в хранилище users.
     *
     * @param user объект класса User.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет из хранилища users карточку пользователя по паспорту.
     *
     * @param passport принимает номер паспорта класса String.
     * @return возвращает true если удаление прошло успешно.
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод добавляет счёт Account account к уже существующей карточке пользователя.
     * Поиск карточки пользователя осуществляется по паспорту.
     * В методе осуществляется проверка наличия такого же счёта у пользователя,
     * для исключения дублирования счетов.
     *
     * @param passport паспорт пользователя.
     * @param account  новый счёт.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по паспорту.
     *
     * @param passport паспорт пользователя.
     * @return возвращает экземпляр класса User с искомым паспортом passport
     * или null если его не существует.
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> passport.equals(user.getPassport()))
                .findFirst().orElse(null);
    }

    /**
     * Метод ищет счёт пользователя по паспорту пользователя и реквизитам счёта.
     * Сначала метод ищет карточку пользователя по паспорту,
     * далее в списке счетов нужный счёт по реквезитам.
     * В методе осуществляется проверка на наличие в хранилище пользователя.
     *
     * @param passport  паспорт пользователя.
     * @param requisite реквизиты искомого счёта.
     * @return возвращает счёт или null если такого пользователя или счёта не существует.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            return accounts.stream()
                    .filter(account -> requisite.equals(account.getRequisite()))
                    .findFirst().orElse(null);
        }
        return null;
    }

    /**
     * Метод для перевода денег между счетами пользователей.
     * В методе есть проверки:
     * - на наличие в хранилище карточки списания
     * - на наличие в хранилище карточки назначения
     * - на положительную разницу сумм переводов.
     *
     * @param srcPassport   паспорт карточки списания.
     * @param srcRequisite  реквизиты счёта списания.
     * @param destPassport  паспорт карточки назначения.
     * @param destRequisite реквизиты счёта назначения.
     * @param amount        сумма к переводу.
     * @return при успешном переводе возвращает true,
     * если счета не найдены или недостаточно средств на счёте списания,
     * возвращает false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        Account dest = findByRequisite(destPassport, destRequisite);
        Account src = findByRequisite(srcPassport, srcRequisite);
        if (src != null && src.getBalance() >= amount && dest != null) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * Метод позволяет получить доступ к списку счетов пользователя
     *
     * @param user принимает карточку пользователя
     * @return возвращает коллекцию счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
