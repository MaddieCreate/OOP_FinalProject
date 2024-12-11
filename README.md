# OOP_FinalProject

# I. Project Overview
The Digital Museum Management System is a user-friendly Java application designed to revolutionize how museums and collectors manage their digital collections. Born out of the need to simplify collection documentation, this system offers an intuitive solution for cataloging and tracking diverse cultural items. Museums and historical institutions often struggle with complex record-keeping, but our application breaks down these barriers by providing a straightforward, step-by-step approach to collection management.

At its core, the system allows users to create a comprehensive digital catalog of museum items, supporting three primary collection types: artworks, artifacts, and historical documents. The process is refreshingly simple: users begin by specifying the number of collections they wish to document, then systematically enter detailed information for each item. With guided prompts, the application captures critical details such as title, creator, description, and type-specific information like year created or origin. This approach ensures that every item's unique story and significance are carefully preserved and easily accessible.

The application's strength lies in its simplicity and flexibility. Once collections are entered, the system generates a clean, organized table display that allows for quick review and comparison of items. Users can easily update metadata, ensuring that collection information remains current and accurate. Whether you're a small museum curator, a historical society volunteer, or an individual collector, this digital management system offers a practical solution to the often overwhelming task of collection documentation.

# II. How OOP Principles were Applied
The combination of OOP principles makes the system maintainable, and extensible, allowing you to add new types of collections with minimal changes to the existing code.

**ENCAPSULATION.** It ensures that the  data security and controlled access through getters, setters, and  private fields. Each collection type **(Artwork, Artifact, HistoricalDocuments)** encapsulates its own data and behaviors.

  title, creator, and description in the class DigitalCollection are private, so they cannot be accessed directly outside the class.
  
  Getter or accessor methods; **getTitle(), getCreator(), and getDescription()** allow controlled access to these private fields.
  
  Setter or update methods; **updateMetadata()** provide a specific way to modify the object without exposing its internal workings directly.

**INHERITANCE.** It allows to shared properties and behaviors to be defined once in the class **(DigitalCollection)** and reused in the classes (Artwork, Artifact, HistoricalDocuments). The class DigitalCollection is an abstract class that serves as the base for specific types of collections.

  Subclasses; **Artwork, Artifact,** and **HistoricalDocument** inherit common properties (title,  creator, description) and methods **(updateMetadata())** from **DigitalCollection.**
  
  This avoids code duplication, as shared attributes and behaviors are written once in the parent class and reused in the child classes.

**POLYMORPHISM.** It provides that while the program executes the appropriate implementations of **displayDetails()**, it can handle different collection kinds (Artwork, Artifact, HistoricalDocuments) appropriately.

  Each subclass (Artwork, Artifact, HistoricalDocuments) overrides the **displayDetails()** method from the main class **DigitalCollection** to provide specific implementation.
  
  Artwork adds **yearCreated** to the display.
  
  Artifact adds **origin** to the display.
  
  HistoricalDocuments adds **yearPublished** to the display.
  
  When iterating through the **ArrayList<DigitalCollection>** in the main program, the **displayDetails()** is called where the system determines at runtime which subclass implementation to invoke based on the actual object type.

**ABSTRACTION.** It hides the complexity of how** displayDetails()** is implemented for each  subclass while ensuring that all subclasses follow a common interface defined by the abstract parent class. The DigitalCollection class is declared as an abstract class. 

  It defines common attributes such as title, creator, description and behaviors which is the **updateMetadata().**
  
  It includes the **displayDetails()** method as an abstract method, which means the subclasses are required to provide their specific implementation.
