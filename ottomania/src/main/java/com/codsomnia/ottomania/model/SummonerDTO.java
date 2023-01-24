package com.codsomnia.ottomania.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class SummonerDTO {
 private String accountId;                    // Encrypted account ID. Max length 56 characters.
 private int profileIconId;                   // ID of the summoner icon associated with the summoner.
 private long revisionDate;	                  // Date summoner was last modified specified as epoch milliseconds. The following events will update this timestamp: summoner name change, summoner level change, or profile icon change.
 private String name;	                      // Summoner name.
 private String id;		                      // Encrypted summoner ID. Max length 63 characters.
 private String	puuid;                        // Encrypted PUUID. Exact length of 78 characters.
 private long summonerLevel;		          // Summoner level associated with the summoner.
}
