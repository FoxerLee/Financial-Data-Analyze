package Test.Repositories;

import Test.model.Quote;
import Test.model.QuotePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository  extends JpaRepository<Quote, Integer>{
    Quote findQuoteByQuotePK(QuotePK quotePK);

    @Query(value = "SELECT * FROM Historical_Quotes as h WHERE h.code = ?1", nativeQuery = true)
    List<Quote> findQuotesByCode(String code);
}