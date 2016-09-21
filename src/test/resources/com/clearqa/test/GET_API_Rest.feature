Feature: ULC rest api calls

  #Scenario: Get movie by title
   # Given I query movie by "null"
   # When I make the rest call
   # Then response should contain:
   #   """
   #   {
   #   "data": null,
  #	  "error": {
   #    "message": "Route not found"
    #    }
    #  }
    #  """

  Scenario Outline: Compare GET api call with json file
    Given I query movie by "<call>"
    When I make the rest call
    Then response should contain "<file>"
    
    Examples: call info and file
    
    | call        | file         |
    | get-bands |get-bands.json|
    #| Inception    | {"data": null,"error": {"message": "Route not found"}}|
    
   # Examples: Special characters in movie titles 
   # | title        | genres                                                                |
   # | WALL·E       | {"genres": ["Animation", "Adventure", "Family", "Romance", "Sci-Fi"]} |
   # | 8½           | {"genres": ["Mystery", "Sci-Fi", "Thriller"] }                        |