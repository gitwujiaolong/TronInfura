package org.tron.infura;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventLogRepository extends MongoRepository<EventLogEntity, String> {

  @Override
  List<EventLogEntity> findAll();

  EventLogEntity findByTransactionId(String transactionId);

  EventLogEntity findByContractAddress(String contractAddress);

  EventLogEntity findByContractAddressAndEntryName(String contractAddress, String entryName);

  EventLogEntity findByContractAddressAndEntryNameAndBlockNumber(String contractAddress,
      String entryName, Long blockNumber);

}