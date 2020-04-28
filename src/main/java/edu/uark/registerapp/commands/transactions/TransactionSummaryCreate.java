package edu.uark.registerapp.commands.transactions;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.models.api.Product;
import edu.uark.registerapp.models.entities.TransactionEntryEntity;
import edu.uark.registerapp.models.repositories.TransactionEntryRepository;
import edu.uark.registerapp.models.repositories.TransactionRepository;
import edu.uark.registerapp.models.repositories.ActiveUserRepository;
import edu.uark.registerapp.models.repositories.EmployeeRepository;
import edu.uark.registerapp.models.repositories.ProductRepository;

@Service
public class TransactionSummaryCreate implements ResultCommandInterface<List<Product>> {
    @Override
    public List<Product> execute() {
        final LinkedList<Product> summary = new LinkedList<Product>();
        
        
        for (final TransactionEntryEntity transactionEntity : transactionEntryRepository.findByTransactionId(this.transactionId)) {
            //summary.addLast(new Product(productRepository.findById(transactionEntity.getProductId())));

		}
		
		return summary;
    }
    
    // Properties
	public TransactionSummaryCreate setProductId(final UUID productId) {
		this.productId = productId;
		return this;
	}

	private UUID productId;
	public UUID getProductId() {
		return this.productId;
	}

    private UUID transactionId;
    public UUID getTransactionId(){
        return this.transactionId;
    }

    private UUID cashierId;
    public UUID getCashierId(){
        return this.cashierId;
    }

    private UUID referenceId;
	public UUID getReferenceId() {
		return this.referenceId;
	}

    private UUID activeUserId;
    public UUID getEmployeeId(){
        return this.activeUserId;
    }

	@Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private ActiveUserRepository activeUser;

	@Autowired
    private TransactionEntryRepository transactionEntryRepository;

    @Autowired 
    private EmployeeRepository employeeRepo;

}