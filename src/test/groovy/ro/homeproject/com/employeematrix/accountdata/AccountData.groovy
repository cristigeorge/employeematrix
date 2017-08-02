package ro.homeproject.com.employeematrix.accountdata

import ro.homeproject.com.employeematrix.entities.Account
import ro.homeproject.com.employeematrix.entities.Role
import ro.homeproject.com.employeematrix.model.AccountModel

class AccountData {

    static anAccountModel(Map overrides = [:]) {
        Map values = [id   : 25L, firstName: "Gigi", lastName: "Bkl", email: "gigi@email.com",
                      phone: "07669504", password: "password", role: Role.ADMIN, jobTitle: "sef", active: true]
        values << overrides
        return AccountModel.newInstance(values)
    }

    static anAccount(Map overrides = [:]) {
        Map values = [id   : 25L, firstName: "Gigi", lastName: "Bkl", email: "gigi@email.com",
                      phone: "07669504", password: "password", role: Role.ADMIN, jobTitle: "sef", active: true]
        values << overrides
        return Account.newInstance(values)
    }
}
