package ro.homeproject.com.employeematrix.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup
import ro.homeproject.com.employeematrix.accountdata.AccountData
import ro.homeproject.com.employeematrix.model.AccountModel
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD

@ContextConfiguration
@SpringBootTest
@SqlGroup([
        @Sql(value = ["/sql/data.sql"], executionPhase = BEFORE_TEST_METHOD),
])
class AccountServiceTest extends Specification {

    @Autowired
    AccountService accountService

    @Unroll
    def "getClientModelById with good id"() {
        when:
        def result = accountService.getClientModelById(id)

        then:
        expectedResult == result

        where:
        id   | expectedResult
        25L  | AccountData.anAccountModel()
        26L  | AccountData.anAccountModel(id: 26, email: "gigi2@email.com")
        420L | new AccountModel()
    }

    def "testing getAllAccounts"() {
        when:
        def result = accountService.getAllAccounts()

        then:
        result.size() == 2
    }

    def "save account to database"() {
        when:
        def result = accountService.save(AccountData.anAccountModel())

        then:
        result == accountService.getClientModelById(AccountData.anAccountModel().getId())
    }

    def "get all active accounts"() {
        when:
        def result = accountService.getAllActiveAccounts()

        then:
        result == [AccountData.anAccountModel(), AccountData.anAccountModel(id: 26, email: "gigi2@email.com")]
    }

    @Unroll
    def "get account by email"() {
        when:
        def result = accountService.getClientModelByEmail(email)
        then:

        expectedResult == result

        where:
        email             | expectedResult
        "gigi@email.com"  | AccountData.anAccountModel()
        "gigi2@email.com" | AccountData.anAccountModel(id: 26, email: "gigi2@email.com")
        ""                | new AccountModel()
    }
}
