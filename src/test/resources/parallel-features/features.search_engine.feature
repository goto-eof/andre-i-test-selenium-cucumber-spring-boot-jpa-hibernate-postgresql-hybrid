Feature: Testing search function

  Scenario Outline: Check if search engine is returning the correct result
    When searching in the search engine the project name "<project_name>"
    Then the result is "<result>"

    Examples:
      | project_name            | result                               |
      | it does not exists      |                                      |
      | it does not exists 2    |                                      |
      | it does not exists 3    |                                      |
      | it does not exists 4    |                                      |
      | ares guard              | Ares Guard (Java)                    |
      | europea library client  | Europea Library Client (TypeScript)  |
      | europea library server  | Europea Library Server (Java)        |
      | minerva europass client | Minerva Europass Client (TypeScript) |
      | minerva europass server | Minerva Europass Server (Java)       |
      | o-reshare server        | O-ReShare Server (Java)              |
