package com.carlaospa.restfull.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.aspectj.bridge.Message;

public class GetUpdates {

    @JsonProperty("update_id")
    private Long updateId;
    private Message message;

    public Long getUpdateId() { return updateId; }

    public void setUpdateId(Long updateId) { this.updateId = updateId; }

    public Message getMessage() { return message; }

    public void setMessage(Message message) { this.message  = message; }
}
