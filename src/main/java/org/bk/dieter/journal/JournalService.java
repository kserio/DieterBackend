package org.bk.dieter.journal;

import org.bk.dieter.product.Product;
import org.bk.dieter.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by redi on 2016-08-30.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class JournalService {

    @Autowired
    JournalRepository journalRepository;

    @Autowired
    ProductRepository productRepository;

    public Journal addProductToTheJournal(Journal journal, Product product) {
        Optional<Product> productOptional = productRepository.findById(product.getId());
        if (!productOptional.isPresent()) {
            productRepository.save(product);
        }
        journal.getProducts().add(product);
        return journal;
    }
}
