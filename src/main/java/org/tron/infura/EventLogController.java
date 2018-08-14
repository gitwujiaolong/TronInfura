package org.tron.infura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventLogController {

  @Autowired
  EventLogRepository eventLogRepository;

  @RequestMapping(method = RequestMethod.GET, value = "/events")
  public Iterable<EventLogEntity> events() {
    return eventLogRepository.findAll();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/event/transaction/{transactionId}")
  public EventLogEntity findOneByTransaction(@PathVariable String transactionId) {
    return eventLogRepository.findByTransactionId(transactionId);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/event/contract/{contractAddress}")
  public EventLogEntity findByContractAddress(@PathVariable String contractAddress) {
    return eventLogRepository.findByContractAddress(contractAddress);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/event/contract/{contractAddress}/{eventName}")
  public EventLogEntity findByContractAddressAndEntryName(
      @PathVariable String contractAddress,
      @PathVariable String eventName) {
    return eventLogRepository.findByContractAddressAndEntryName(contractAddress, eventName);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/event/contract/{contractAddress}/{eventName}/{blockNumber}")
  public EventLogEntity findByContractAddressAndEntryNameAndBlockNumber(
      @PathVariable String contractAddress,
      @PathVariable String eventName,
      @PathVariable Long blockNumber) {
    return eventLogRepository
        .findByContractAddressAndEntryNameAndBlockNumber(contractAddress, eventName, blockNumber);
  }

}
