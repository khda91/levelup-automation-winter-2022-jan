Feature: Comparison

  Scenario Outline: Compare
    Then expression should be next <a> <sign> <b>

    Examples:
      | a | sign | b |
      | 1 | <    | 4 |
